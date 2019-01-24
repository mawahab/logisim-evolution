package com.cburch.logisim.cpu;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created by rob on 13/11/14.
 */
public class Cpu {
//
//    private final long gpr[] = new long[32];
//
//      private long pc = 0x2000;
//    private long instructionsRetired = 0;
//
//  
//    private final ThreadMXBean threadMXBean;
//
//    private final boolean useThreadCpuTime;
//
//    public static final int RDCYCLE =    0b110000000000;
//    public static final int RDCYCLEH =   0b110010000000;
//    public static final int RDTIME =     0b110000000001;
//    public static final int RDTIMEH =    0b110010000001;
//    public static final int RDINSTRET =  0b110000000010;
//    public static final int RDINSTRETH = 0b110010000010;
//
//    public Cpu(MemoryManagementUnit mmu) {
//        this.mmu = mmu;
//        // Try to isolate thread cpu time
//        threadMXBean = ManagementFactory.getThreadMXBean();
//        if (threadMXBean.isCurrentThreadCpuTimeSupported()) {
//            useThreadCpuTime = true;
//            if (!threadMXBean.isThreadCpuTimeEnabled()) {
//                threadMXBean.setThreadCpuTimeEnabled(true);
//            }
//        }
//        else {
//            useThreadCpuTime = false;
//        }
//
//        csr[RDCYCLE] = new RdCycle();
//        csr[RDCYCLEH] = new RdCycle();
//        csr[RDTIME] = new RdTime();
//        csr[RDTIMEH] = new RdTimeH();
//        csr[RDINSTRET] = new RdInstret();
//        csr[RDINSTRETH] = new RdInstretH();
//        csr[0b101000] = new NoopControlStatusRegister(); // TODO
//    }
//
//    public void setProgramCounter(long pc) {
//        this.pc = pc;
//    }
//
//    public void executeInstruction() {
//        int instruction = mmu.readInstruction(pc);
//        executeInstruction(instruction);
//    }
//
//
//    public void executeInstruction(int instruction) {
//
//        int majorOpcode = (instruction & 0x7f) >> 2;
//
//    	public enum niosOpCode {
//            load(0b00000),
//            store(0b01000), // "STORE"
//            madd(0b10000), //"MADD"
//            branch(0b11000), //"BRANCH"
//            loadfp(0b00001), //"LOAD-FP"
//            storefp(0b01001), //"STORE-FP"
//            msub(0b10001), //"MSUB"
//            jlar(0b11001), //"JALR"
//
//            nmsud(0b10010), //"NMSUB"
//            reserved(0b11010), //"reserved"
//
//            miscmem(0b00011), "MISC-MEM"
//            amo(0b01011), // "AMO"
//            nmadd(0b10011), // "NMADD"
//            jal(0b11011), // "JAL"
//
//            opimm(0b00100), // "OP-IMM"
//            op(0b01100), // "OP"
//            opfp(0b10100), // "OP-FP"
//            system(0b11100), // "SYSTEM"
//            auipc(0b00101), // "AUIPC"
//            lui(0b01101), // "LUI"
//            opimm32(0b00110), // "OP-IMM-32"
//            op032(0b01110), // "OP032"
//
//            reserved2(0b10101), // "reserved"
//            reserved3(0b11101), // "reserved"
//
//            custom0(0b00010), // "custom-0"
//            custom1(0b01010), // "custom-1"
//            custom2(0b10110), // "custom-2"
//            custom3(0b11110), // "custom-3"
//            ext48b(0b00111), // "48b"
//            ext64b(0b01111), // "64b"
//            ext48b(0b10111), // "48b"
//            ext80b(0b11111), // "80b+"
//        }
//
//        ++instructionsRetired;
//    }
//
//    public void branch(int instruction) {
//        int funct3 = (instruction >>> 12) & 0b111;
//        ), // rs1 = gpr[(instruction >>> 15) & 0b11111];
//        long rs2 = gpr[(instruction >>> 20) & 0b11111];
//
//        boolean branch = false;
//
//        switch (funct3) {
//            beq(0b000), // BEQ
//                branch = rs1 == rs2;
//                break;
//
//            bne(0b001), // BNE
//                branch = rs1 != rs2;
//                break;
//
//            blt(0b100), // BLT
//                branch = rs1 < rs2;
//                break;
//
//            (0b101), // BGE
//                branch = rs1 > rs2;
//                break;
//
//            (0b110), // BLTU
//                branch = rs1 < rs2; // TODO unsigned
//                break;
//
//            (0b111), // BGTU
//                branch = rs1 > rs2; // TODO unsigned
//                break;
//
//            default:
//                throw new IllegalInstruction("Unknown BRANCH funct3 " +
//                        Integer.toBinaryString(funct3) +
//                        " at " + Long.toHexString(pc), pc);
//        }
//
//        if (branch) {
//            throw new RuntimeException("Branch, please!");
//        }
//        else {
//            pc += 4;
//        }
//    }
//
//    public enum opImm  {
//        addi(0b000), // ADDI
//        slli(0b001), // SLLI
//        slti(0b010), // SLTI
//        sltiu(0b011), // SLTIU, need to check signExt here
//        xori(0b100), // XORI
//        srli(0b101), // SRLI and SRAI
//        ori(0b110), // ORI
//        andi(0b111); // ANDI
//        
//		public int opImmValue;
//
//		private opImm(int opImmValue) {
//			this.opImmValue = opImmValue;
//		}
//
//		public int getOpImm() {
//			return opImmValue;
//		}
//
//    }
//
//    public void opImm(int instruction) {
//        int rd = (instruction >>> 7) & 0b11111;
//        int rs1 = (instruction >>> 15) & 0b11111;
//        int funct3 = (instruction >>> 12) & 0x111;
//        long immediate = (instruction >> 20);
//
//     }
//
//    void system(int instruction) {
//        int rd = (instruction >> 7) & 0b11111;
//        int funct3 = (instruction >> 12) & 0b111;
//        int rs1 = (instruction >> 15) & 0b11111;
//        int funct7 = (instruction >> 25) & 0b1111111;
//
//        switch (funct3) {
//            (0b000), // PRIV
//                if (funct7 == 0 && rd == 0 && rs1 == 0) {
//                    throw new UnsupportedInstruction("SCALL", pc);
//                }
//                else if (funct7 == 1 && rd == 0 && rs1 == 0) {
//                    throw new UnsupportedInstruction("SBREAK", pc);
//                }
//                throw new IllegalInstruction(pc);
//            (0b001:
//                throw new IllegalInstruction("CSRW", pc);
//            (0b010:
//                csrrs(funct7, rd, rs1);
//                break;
//            (0b011:
//                csrrc(funct7, rd, rs1);
//                break;
//
//            (0b100:
//                throw new IllegalInstruction("CSRWI", pc);
//
//            (0b101:
//                throw new IllegalInstruction("CSRSI", pc);
//
//            (0b110:
//                throw new IllegalInstruction("CSRCI", pc);
//
//            (0b111:
//                throw new IllegalInstruction("0b111", pc);
//
//            default:
//                throw new IllegalInstruction(pc);
//        }
//    }
//
//    public long getInstructionsRetired() {
//        return instructionsRetired;
//    }
//
//    public long getCycleTime() {
//        if (useThreadCpuTime) {
//            return threadMXBean.getCurrentThreadCpuTime();
//        }
//        return System.nanoTime();
//    }
//
//    private void csrrs(int funct7, int rd, int rs1) {
//
//        ControlStatusRegister controlStatusRegister = csr[funct7];
//
//        if (controlStatusRegister == null) {
//            throw new IllegalInstruction(
//                    "Undefined CSR " + Integer.toBinaryString(funct7) + " in CSRRS at " + Long.toHexString(pc), pc);
//        }
//
//        gpr[rd] = controlStatusRegister.readAndSet(this, rs1);
//    }
//
//    private void csrrc(int funct7, int rd, int rs1) {
//
//        ControlStatusRegister controlStatusRegister = csr[funct7];
//
//        if (controlStatusRegister == null) {
//            throw new IllegalInstruction(
//                    "Undefined CSR " + Integer.toBinaryString(funct7) + " in CSRRC at " + Long.toHexString(pc), pc);
//        }
//
//        gpr[rd] = controlStatusRegister.readAndClear(this, rs1);
//    }
}
