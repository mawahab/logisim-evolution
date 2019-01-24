/*******************************************************************************
 * This file is part of logisim-evolution.
 *
 *   logisim-evolution is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   logisim-evolution is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   Original code by Carl Burch (http://www.cburch.com), 2011.
 *   Subsequent modifications by :
 *     + Haute École Spécialisée Bernoise
 *       http://www.bfh.ch
 *     + Haute École du paysage, d'ingénierie et d'architecture de Genève
 *       http://hepia.hesge.ch/
 *     + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 *       http://www.heig-vd.ch/
 *   The project is currently maintained by :
 *     + REDS Institute - HEIG-VD
 *       Yverdon-les-Bains, Switzerland
 *       http://reds.heig-vd.ch
 *******************************************************************************/

package com.cburch.logisim.std.memory;

import com.cburch.logisim.cpu.NIOS2Instr;
import com.cburch.logisim.instance.InstanceData;

class Nios2Data extends ClockState implements InstanceData {
	int R[]= new int[32];;
	int PC=0, IR=0, offset=0; NIOS2Instr instr;
	CPUState nextState = CPUState.FETCH;
	CPUState currentState = CPUState.IDLE;
	int cpt=0;
	enum CPUState{IDLE, ILLEGAL_INSTR, BUS_ERROR, FETCH, DECODE, EXECUTE, IO_READ, IO_WRITE, MEM_READ, MEM_WRITE}

	int lastRegEvent = -1;
	private int cpuAddress;
	private int cpuDout;
	
	public CPUState getNextState() {
		return nextState;
	}

	public void setNextState(CPUState state) {
		this.nextState = state;
	}

	public Nios2Data() {
		clear();
	}

	public int getPC() {
		return PC;
	}

	public void setPC(int pC) {
		PC = pC;
	}

	public int getIR() {
		return IR;
	}

	public void setIR(int iR) {
		IR = iR;
		instr= new NIOS2Instr(iR);
	}

	public void clear() {
		nextState=CPUState.IDLE;
		IR=0;
		PC=0;
		cpuAddress=0;
		cpuDout=0;
		for (int i = 0; i < R.length; i++) {
			R[i]=0;
		}
	}
	public int getReg(int add) {
		if (add!=0)
			return R[add];
		else 
			return 0;
	}

	public void setReg(int addr, int value) {
		if(addr!=0)
			this.R[addr] = value;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	public static int sext(int v) {
		if ((v&0x8000)==0) {
			return v;
		} else {
			return 0xFFFF0000|v;
		}
	}
	public void execute() {
		NIOS2Instr i =  new NIOS2Instr(getIR());
		int sext = sext(i.imm16);
		switch (i.op) {
		case addi : { 
			R[i.rb]=R[i.ra]+sext; 
			PC= PC+4; 
			break;
			}
		case call : { 
			R[31]=PC+4;
			PC=i.imm26*4; 
			break;}
		case beq : { if (R[i.ra]==R[i.rb]) PC= PC+sext+4; else PC= PC+4; break;}
		case bne : { if (R[i.ra]!=R[i.rb]) PC= PC+sext+4; else PC= PC+4; break;}
		case blt : { if (R[i.ra]<R[i.rb]) PC= PC+sext+4; else PC= PC+4; break;}
		case bge : { if (R[i.ra]<=R[i.rb]) PC= PC+sext+4; else PC= PC+4; break;}
		case orhi: { 
			R[i.rb]=R[i.ra]|(sext<<16); 
			PC= PC+4; 
			break;
			}
		case andi: { R[i.rb]=R[i.ra]&sext; PC= PC+4; break;}
		case RTYPE : { 
				switch(i.opx) {
					case add : { R[i.rc]=R[i.ra]+R[i.rb]; PC= PC+4; break;}
					case sub : { R[i.rc]=R[i.ra]-R[i.rb]; PC= PC+4; break;}
					case and : { R[i.rc]=R[i.ra]&R[i.rb]; PC= PC+4; break;}
					case mul : { R[i.rc]=R[i.ra]*R[i.rb]; PC= PC+4; break;}
					case xor : { R[i.rc]=R[i.ra]^R[i.rb]; PC= PC+4; break;}
					case or :  { R[i.rc]=R[i.ra]|R[i.ra]; PC= PC+4; break;}
					case sll : { 
						R[i.rc]=R[i.ra]<<R[i.rb] ; 
						PC= PC+4; break;}
					case sra : { 
						R[i.rc]=R[i.ra]>>>R[i.rb]; 
						PC= PC+4; break;
					}
					case srl : { R[i.rc]=R[i.ra]>>R[i.rb]; PC= PC+4; break;}
					case slli : { 
						R[i.rc]=R[i.ra]<<i.imm5; 
						PC= PC+4; 
						break;
						}
					case srli : { 
						R[i.rc]=R[i.ra]>>i.imm5; 
						PC= PC+4; 
						break;
						}
					case ret : { 
						PC=R[31];
						break;}

				}
			}
			break;
		case ldb : 
		case ldh : 
		case ldw : 
		{ 
			cpuAddress=R[i.ra]+sext; PC= PC+4;
			nextState = CPUState.MEM_READ; 
			break;
		}
		case stb : { 
			cpuAddress=R[i.ra]+sext; 
			int shift = cpuAddress&0x3;
			cpuDout=(R[i.rb]&0xFF)<<(shift*8);PC= PC+4;
			nextState = CPUState.MEM_WRITE; 
			break;
		}
		case sth : { 
			cpuAddress=R[i.ra]+sext; 
			int shift = (cpuAddress&0x2);
			cpuDout=(R[i.rb]&0xFFFF)<<(shift*8);
			PC= PC+4;
			nextState = CPUState.MEM_WRITE; 
			break;
		}
		case stw : { 
			cpuAddress=R[i.ra]+sext; 
			cpuDout=R[i.rb];PC= PC+4;
			nextState = CPUState.MEM_WRITE; 
			break;
		}
		case ldbio : 
		case ldhio : 
		case ldwio : 
		{ 
			cpuAddress=R[i.ra]+sext; PC= PC+4;
			nextState = CPUState.IO_READ; 
			break;
		}
		case stbio : 
		{ 
			cpuAddress=R[i.ra]+sext; 
			int shift = cpuAddress&0x3;
			cpuDout=(R[i.rb]&0xFF)<<(shift*8);PC= PC+4;
			nextState = CPUState.IO_WRITE; 
			break;
		}
		case sthio : 
		{ 
			cpuAddress=R[i.ra]+sext; 
			int shift = (cpuAddress&0x2);
			cpuDout=(R[i.rb]&0xFFFF)<<(shift*8);
			nextState = CPUState.IO_WRITE; 
			break;
		}
		case stwio : 
		{ 
			cpuAddress=R[i.ra]+sext; 
			cpuDout=R[i.rb];PC= PC+4;
			nextState = CPUState.IO_WRITE; 
			break;
		}
		}
		
		R[0]=0;
	}

	public int getCPUAddress() {
		return cpuAddress;
	}

	public int getCPUDout() {
		return cpuDout;
	}
	
	
}