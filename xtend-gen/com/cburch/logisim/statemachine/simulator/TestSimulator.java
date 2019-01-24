package com.cburch.logisim.statemachine.simulator;

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PredicateStmt;
import com.cburch.logisim.statemachine.parser.FSMSerializer;
import com.cburch.logisim.statemachine.simulator.FSMSimulator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestSimulator {
  public static BoolExpr boolExpr(final String in) throws IOException {
    BoolExpr _xblockexpression = null;
    {
      byte[] _bytes = in.getBytes(StandardCharsets.UTF_8);
      InputStream fis = new ByteArrayInputStream(_bytes);
      EObject _parse = FSMSerializer.parse(fis);
      final PredicateStmt stmt = ((PredicateStmt) _parse);
      _xblockexpression = stmt.getPredicate();
    }
    return _xblockexpression;
  }
  
  private List<List<String>> in = Collections.<List<String>>unmodifiableList(CollectionLiterals.<List<String>>newArrayList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("1100", "1")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("1100", "0")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("0011", "1")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("0000", "0")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("0000", "0"))));
  
  private List<List<String>> out = Collections.<List<String>>unmodifiableList(CollectionLiterals.<List<String>>newArrayList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S0", "0001")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S0", "0001")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S1", "0010")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S2", "0000")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("S0", "0001"))));
  
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
  
  @Test
  public void test1() {
    this.testFSM(this.fsm, this.in, this.out);
  }
  
  public void testFSM(final String sfsm, final List<List<String>> in, final List<List<String>> out) {
    try {
      final FSM fsm = FSMSerializer.load(sfsm);
      final FSMSimulator fsmSim = new FSMSimulator(fsm);
      fsmSim.reset();
      int tick = 0;
      for (tick = 0; (tick < in.size()); tick++) {
        {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(" ");
          _builder.append("current state = ");
          String _name = fsmSim.getCurrentState().getName();
          _builder.append(_name, " ");
          InputOutput.<String>println(_builder.toString());
          int _size = fsm.getIn().size();
          int _minus = (_size - 1);
          IntegerRange _upTo = new IntegerRange(0, _minus);
          for (final Integer i : _upTo) {
            {
              Port _get = fsm.getIn().get((i).intValue());
              final InputPort iport = ((InputPort) _get);
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("    ");
              _builder_1.append("- input ");
              String _name_1 = iport.getName();
              _builder_1.append(_name_1, "    ");
              _builder_1.append("=>");
              String _get_1 = in.get(tick).get((i).intValue());
              _builder_1.append(_get_1, "    ");
              InputOutput.<String>println(_builder_1.toString());
              fsmSim.updateInput(iport, this.quote(in.get(tick).get((i).intValue())));
            }
          }
          fsmSim.updateState();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(" ");
          _builder_1.append("new state = ");
          String _name_1 = fsmSim.getCurrentState().getName();
          _builder_1.append(_name_1, " ");
          InputOutput.<String>println(_builder_1.toString());
          boolean _equals = out.get(tick).get(0).equals(fsmSim.getCurrentState().getName());
          boolean _not = (!_equals);
          if (_not) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("Inconsitent state at tick ");
            _builder_2.append(tick);
            _builder_2.append(", state ");
            String _get = out.get(tick).get(0);
            _builder_2.append(_get);
            _builder_2.append(" expected, ");
            String _name_2 = fsmSim.getCurrentState().getName();
            _builder_2.append(_name_2);
            _builder_2.append(" observed");
            Assert.fail(_builder_2.toString());
          }
          fsmSim.updateCommands();
          int _size_1 = fsm.getOut().size();
          int _minus_1 = (_size_1 - 1);
          IntegerRange _upTo_1 = new IntegerRange(0, _minus_1);
          for (final Integer i_1 : _upTo_1) {
            {
              Port _get_1 = fsm.getOut().get((i_1).intValue());
              final OutputPort oport = ((OutputPort) _get_1);
              final String v = fsmSim.getOutput((i_1).intValue());
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("    ");
              _builder_3.append("- output ");
              String _name_3 = oport.getName();
              _builder_3.append(_name_3, "    ");
              _builder_3.append("=>");
              _builder_3.append(v, "    ");
              InputOutput.<String>println(_builder_3.toString());
              final String ref = this.quote(out.get(tick).get(((i_1).intValue() + 1)));
              boolean _equals_1 = ref.equals(v);
              boolean _not_1 = (!_equals_1);
              if (_not_1) {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("Inconsitent output for ");
                String _name_4 = oport.getName();
                _builder_4.append(_name_4);
                _builder_4.append(" at tick ");
                _builder_4.append(tick);
                _builder_4.append(", value ");
                String _get_2 = out.get(tick).get((i_1).intValue());
                _builder_4.append(_get_2);
                _builder_4.append(" expected, ");
                _builder_4.append(v);
                _builder_4.append(" observed");
                Assert.fail(_builder_4.toString());
              }
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String quote(final String string) {
    return (("\"" + string) + "\"");
  }
}
