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

import com.cburch.logisim.instance.InstanceData;

class Nios2Data extends ClockState implements InstanceData {
	int regs[]= new int[32];;
	int PC=0, IR=0, offset=0;
	CPUState state = CPUState.IDLE;
	
	enum CPUState{IDLE, ILLEGAL_INSTR, BUS_ERROR, FETCH, DECODE, EXECUTE, WAIT}

	int lastRegEvent = -1;
	private int cpuAddress;
	private int cpuDout;
	
	public CPUState getState() {
		return state;
	}

	public void setState(CPUState state) {
		this.state = state;
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
	}

	public void clear() {
		for (int i = 0; i < regs.length; i++) {
			regs[i]=0;
		}
	}
	public int getReg(int add) {
		return regs[add];
	}

	public void setReg(int addr, int value) {
		this.regs[addr] = value;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public int getCPUAddress() {
		return cpuAddress;
	}

	public int getCPUDout() {
		return cpuDout;
	}
	
	
}