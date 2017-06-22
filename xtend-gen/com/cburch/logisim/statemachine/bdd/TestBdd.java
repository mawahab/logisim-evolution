package com.cburch.logisim.statemachine.bdd;

import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.parser.FSMSerializer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestBdd {
  private final String fsm = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("fsm example  { ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("in  keypad [ 4 ]; ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("in  A [ 1 ]; ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("out X [ 4 ] ; ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("codeWidth = 2 ; ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("reset = S0 ; ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("state S0 = \"01\" { ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("commands  { X = \"0001\" ; }");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("transitions { ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("S0 -> S1 when A.keypad/=\"1100\" ; ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("state S1 = \"10\" { ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("commands { X = \"0010\" ; } ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("transitions { ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("S1 -> S2 when keypad/=\"1010\"   ; ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("state S2 = \"00\"  { ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("commands { X = { \"0000\" } ; } ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("transitions { ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("S2 -> S0 when default   ; ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  public void testFSM(final String sfsm) {
    try {
      final FSM fsm = FSMSerializer.load(sfsm);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    Assert.fail("Not yet implemented");
  }
}
