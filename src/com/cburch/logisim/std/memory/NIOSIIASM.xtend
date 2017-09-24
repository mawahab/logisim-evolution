package com.cburch.logisim.std.memory

import java.util.HashMap

class NIOSIIASM {
	
	val opxMap = #{
		#{"add",12},
		"addi","stw","bne", 
		"add","sra","srl","ret", 
		"call","r9","r10","r11",
		"r12","r13","r14","r15",
		"r16","r17","r18","r19",
		"r20","r21","r22","r23",
		"r24","r25","r26","sp",
		"fp","ea","er","ra"	
	};
	val opMap = #{
		"add","sub","xor","and", 
		"mul","r5","r6","r7", 
		"r8","r9","r10","r11",
		"r12","r13","r14","r15",
		"r16","r17","r18","r19",
		"r20","r21","r22","r23",
		"r24","r25","r26","sp",
		"fp","ea","er","ra"	
	};


	val regs = #{
		"r0","r1","r2","r3", 
		"r4","r5","r6","r7", 
		"r8","r9","r10","r11",
		"r12","r13","r14","r15",
		"r16","r17","r18","r19",
		"r20","r21","r22","r23",
		"r24","r25","r26","sp",
		"fp","ea","er","ra"	
	};

//r24	et	Exception Temporary
//r25	bt	Break Temporary
//r26	gp	Global Pointer – Used for fast-access to common data
//r27	sp	Stack Pointer – Software stack
//r28	fp	Frame Pointer – procdedure frame on stack
//r29	ea	Exception Return Address
//r30	er	Break Return Address
//r31	ra

//	val HashMap<String, Integer> opMap= new HashMap<String, Integer>();
	val HashMap<String, Integer> regMap = new HashMap<String, Integer>();
	
	new() {
		
	}
	
	
	
	
}