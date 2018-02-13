package com.cburch.logisim.std.memory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class NIOSIIASM {
  private final Set<?> opxMap = Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet(Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet("add", Integer.valueOf(12))), "addi", "stw", "bne", "add", "sra", "srl", "ret", "call", "r9", "r10", "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "sp", "fp", "ea", "er", "ra"));
  
  private final Set<String> opMap = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("add", "sub", "xor", "and", "mul", "r5", "r6", "r7", "r8", "r9", "r10", "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "sp", "fp", "ea", "er", "ra"));
  
  private final Set<String> regs = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("r0", "r1", "r2", "r3", "r4", "r5", "r6", "r7", "r8", "r9", "r10", "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "sp", "fp", "ea", "er", "ra"));
  
  private final HashMap<String, Integer> regMap = new HashMap<String, Integer>();
  
  public NIOSIIASM() {
  }
}
