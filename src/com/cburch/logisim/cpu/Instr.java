package com.cburch.logisim.cpu;

import java.util.ArrayList;

public class Instr {
	public enum niosType {
		RTYPE, ITYPE, JTYPE, UNKNOWN
	}

	public enum niosOpCode {
		call(0x00), jmpi(0X01), ldbu(0x03), addi(0x04), stb(0x05), br(0x06), ldb(0x07), cmpgei(0x08), ldhu(0x0b), andi(
				0x0c), sth(0x0d), bge(0x0e), ldh(0x0f), cmplti(0x10), initda(0x23), ori(0x14), stw(0x15), blt(
						0x16), ldw(0x17), cmpnei(0x18), flushda(0x1b), xori(0x1c), bne(0x1e), cmpeqi(0x20), ldbuio(
								0x23), muli(0x24), stbio(0x25), beq(0x26), ldbio(0x27), cmpgeui(0x28), ldhuio(
										0x2b), andhi(0x2c), sthio(0x2d), bgeu(0x2e), ldhio(0x2f), cmpltui(0x30), custom(
												0x32), initd(0x33), orhi(0x34), stwio(0x35), bltu(0x36), ldwio(
														0x37), rdprs(0x38), RTYPE(0x3a), flushd(0x3b), xorhi(
																0x3c), unknown(0x3f);

		private int opCodeValue;

		private niosOpCode(int opCodeValue) {
			this.opCodeValue = opCodeValue;
		}

		public int getOpCode() {
			return opCodeValue;
		}

	}

	public enum niosOpxCode {

		eret(0x01), roli(0x02), rol(0x03), flushp(0x04), ret(0x05), nor(0x06), mulxuu(0x07), cmpge(0x08), bret(
				0x09), ror(0x0b), flushi(0x0c), jmp(0x0d), and(0x0e), cmplt(0x10), slli(0x12), sll(0x13), wrprs(
						0x14), or(0x16), mulxsu(0x17), cmpne(0x18), srli(0x1a), srl(0x1b), nextpc(0x1c), callr(
								0x1d), xor(0x1e), mulxss(0x1f), cmpeq(0x20), divu(0x24), div(0x25), rdctl(0x26), mul(
										0x27), cmpgeu(0x28), initi(0x29), trap(0x2d), wrctl(0x2e), cmpltu(0x30), add(
												0x31), _break(0x34), sync(0x36), sub(0x39), srai(0x3a), sra(0x3b);

		private int opxCodeValue;

		private niosOpxCode(int opxCodeValue) {
			this.opxCodeValue = opxCodeValue;
		}

		public int getOpxCode() {
			return opxCodeValue;
		}

	}

	private niosOpCode op;
	private niosType type;
	private niosOpxCode opx;

	private int imm5;
	private int imm16;
	private int imm26;
	private int ra;
	private int rb;
	private int rc;

	public Instr(long binaryInstruction) {
		int opBinary = (int) (binaryInstruction & 0x3f);

		for (niosOpCode opcode : niosOpCode.values()) {
			if (opcode.getOpCode() == opBinary) {
				this.op = opcode;
				break;
			}

			this.op = niosOpCode.unknown;
		}

		switch (op) {
		case RTYPE:
			this.type = niosType.RTYPE;
			int opxBinary = (int) ((binaryInstruction >> 11) & 0x3f);

			for (niosOpxCode opxcode : niosOpxCode.values())
				if (opxcode.getOpxCode() == opxBinary) {
					this.opx = opxcode;
					break;
				}

			this.imm5 = (int) ((binaryInstruction >> 6) & 0x1f);
			this.rc = (int) ((binaryInstruction >> 17) & 0x1f);
			this.rb = (int) ((binaryInstruction >> 22) & 0x1f);
			this.ra = (int) ((binaryInstruction >> 27) & 0x1f);
			break;
		case call:
		case jmpi:
			this.type = niosType.JTYPE;
			this.imm26 = (int) ((binaryInstruction >> 6) & 0x3ffffff);
			break;
		case unknown:
			this.type = niosType.UNKNOWN;
			break;
		default:
			this.type = niosType.ITYPE;
			this.imm16 = (int) ((binaryInstruction >> 6) & 0xffff);
			this.rb = (int) ((binaryInstruction >> 22) & 0x1f);
			this.ra = (int) ((binaryInstruction >> 27) & 0x1f);
			break;
		}

	}

	public String toString() {
		switch (this.type) {
		case RTYPE:
			switch (this.opx) {
			case roli:
			case slli:
			case srli:
			case srai:
				return this.opx.name() + " r" + this.rc + ", r" + this.ra + ", " + this.imm5;
			default:
				return this.opx.name() + " r" + this.rc + ", r" + this.ra + ", r" + this.rb;
			}
		case ITYPE:
			switch (this.op) {
			case ldbu:
			case ldb:
			case ldhu:
			case ldh:
			case ldw:
			case ldbuio:
			case ldbio:
			case ldhuio:
			case ldhio:
			case ldwio:
			case stb:
			case sth:
			case stw:
			case stbio:
			case sthio:
			case stwio:
				return this.op.name() + " r" + this.rb + ", " + getSignedValue16(this.imm16) + " (r" + this.ra + ")";
			case br:
			case bge:
			case blt:
			case bne:
			case beq:
			case bgeu:
				return this.op.name() + " r" + this.ra + ", r" + this.rb + "," + getSignedValue16(this.imm16);
			default:
				return this.op.name() + " r" + this.rb + ", r" + this.ra + ", " + getSignedValue16(this.imm16);
			}
		case JTYPE:
			return this.op.name() + " "+this.imm26;
		case UNKNOWN:
			return "Illegal inst";
		default:
			break;

		}
		return this.op.name() + " r" + this.ra + ", r" + this.rb + ", r" + this.rc;
	}

	public long getSignedValue16(long imm16) {
		imm16 = imm16 & 0xffff;
		if (imm16 > Math.pow(2, 15))
			imm16 -= Math.pow(2, 16);

		return imm16;
	}

	public static void main(String[] args) {
		Instr test1 = new Instr(0x18d1883a); // add r8,r3,r3
		System.out.println(test1);

		Instr test2 = new Instr(0x12806217); // ldw r10,392(r2)
		System.out.println(test2);

		Instr test3 = new Instr(0x80805215); // stw r2,328(r16)

		System.out.println(test3);
	}

}
