package com.cburch.logisim.statemachine.analysis;

import com.cburch.logisim.statemachine.analysis.InputVectorGenerator;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.parser.FSMSerializer;
import com.cburch.logisim.statemachine.simulator.FSMSimulator;
import com.google.common.base.Objects;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class TableExport {
  public ArrayList<String> genName(final Port ip) {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> il = new ArrayList<String>();
      int _width = ip.getWidth();
      int _minus = (_width - 1);
      IntegerRange _upTo = new IntegerRange(_minus, 0);
      for (final Integer off : _upTo) {
        String _name = ip.getName();
        String _plus = (_name + "_");
        String _plus_1 = (_plus + off);
        il.add(_plus_1);
      }
      _xblockexpression = il;
    }
    return _xblockexpression;
  }
  
  public CharSequence genSIS(final FSM fsm) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Port> _in = fsm.getIn();
      boolean _hasElements = false;
      for(final Port ip : _in) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(";", "");
        }
        {
          ArrayList<String> _genName = this.genName(ip);
          boolean _hasElements_1 = false;
          for(final String n : _genName) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(";", "");
            }
            _builder.append(n, "");
          }
        }
      }
    }
    _builder.append(" ");
    {
      int _width = fsm.getWidth();
      IntegerRange _upTo = new IntegerRange(0, _width);
      boolean _hasElements_2 = false;
      for(final Integer i : _upTo) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(";", "");
        }
        _builder.append("cs_");
        _builder.append(i, "");
      }
    }
    _builder.append(";;");
    {
      EList<Port> _out = fsm.getOut();
      boolean _hasElements_3 = false;
      for(final Port op : _out) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
        } else {
          _builder.appendImmediate(";", "");
        }
        {
          ArrayList<String> _genName_1 = this.genName(op);
          boolean _hasElements_4 = false;
          for(final String n_1 : _genName_1) {
            if (!_hasElements_4) {
              _hasElements_4 = true;
            } else {
              _builder.appendImmediate(";", "");
            }
            _builder.append(n_1, "");
          }
        }
      }
    }
    _builder.append(" ");
    {
      int _width_1 = fsm.getWidth();
      IntegerRange _upTo_1 = new IntegerRange(0, _width_1);
      boolean _hasElements_5 = false;
      for(final Integer i_1 : _upTo_1) {
        if (!_hasElements_5) {
          _hasElements_5 = true;
        } else {
          _builder.appendImmediate(";", "");
        }
        _builder.append("ns_");
        _builder.append(i_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      ArrayList<String> _buildTruthTable = this.buildTruthTable(fsm);
      for(final String l : _buildTruthTable) {
        _builder.append(l, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public ArrayList<String> buildTruthTable(final FSM fsm) {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> buffer = new ArrayList<String>();
      InputVectorGenerator ic = new InputVectorGenerator(fsm);
      final FSMSimulator sim = new FSMSimulator(fsm);
      sim.refreshInputPorts();
      do {
        {
          EList<Port> _in = fsm.getIn();
          int _size = _in.size();
          int _minus = (_size - 1);
          IntegerRange _upTo = new IntegerRange(0, _minus);
          for (final int i : _upTo) {
            {
              EList<Port> _in_1 = fsm.getIn();
              Port _get = _in_1.get(i);
              final InputPort ip = ((InputPort) _get);
              String _quotedBinaryValue = ic.getQuotedBinaryValue(i);
              sim.updateInput(ip, _quotedBinaryValue);
            }
          }
          EList<Port> _in_1 = fsm.getIn();
          int _size_1 = _in_1.size();
          final String currentCode = ic.getQuotedBinaryValue(_size_1);
          sim.setCurrentState(null);
          EList<State> _states = fsm.getStates();
          for (final State s : _states) {
            String _code = s.getCode();
            boolean _equals = Objects.equal(_code, currentCode);
            if (_equals) {
              sim.setCurrentState(s);
            }
          }
          State _currentState = sim.getCurrentState();
          boolean _equals_1 = Objects.equal(_currentState, null);
          if (_equals_1) {
            throw new RuntimeException("Error not matching state in FSM");
          }
          String line = "";
          int _size_2 = ic.getSize();
          int _minus_1 = (_size_2 - 1);
          IntegerRange _upTo_1 = new IntegerRange(0, _minus_1);
          for (final int i_1 : _upTo_1) {
            String _line = line;
            String _binaryValue = ic.getBinaryValue(i_1);
            line = (_line + _binaryValue);
          }
          String _line_1 = line;
          line = (_line_1 + ";");
          sim.updateState();
          sim.updateCommands();
          String _line_2 = line;
          State _currentState_1 = sim.getCurrentState();
          String _code_1 = _currentState_1.getCode();
          String _replace = _code_1.replace("\"", "");
          line = (_line_2 + _replace);
          EList<Port> _out = fsm.getOut();
          int _size_3 = _out.size();
          int _minus_2 = (_size_3 - 1);
          IntegerRange _upTo_2 = new IntegerRange(0, _minus_2);
          for (final Integer i_2 : _upTo_2) {
            String _line_3 = line;
            String _output = sim.getOutput((i_2).intValue());
            String _replace_1 = _output.replace("\"", "");
            line = (_line_3 + _replace_1);
          }
          String _replace_2 = line.replace("0", "0;");
          line = _replace_2;
          String _replace_3 = line.replace("1", "1;");
          line = _replace_3;
          buffer.add(line);
        }
      } while(ic.inc());
      _xblockexpression = buffer;
    }
    return _xblockexpression;
  }
  
  private final static String ex = new Function0<String>() {
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
      _builder.append("\t\t");
      _builder.append("state S3 = \"11\"  { ");
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
      return _builder.toString();
    }
  }.apply();
  
  public static void main(final String[] args) {
    try {
      final FSM fsm = FSMSerializer.load(TableExport.ex);
      final TableExport tt = new TableExport();
      String _name = fsm.getName();
      String _plus = (_name + ".csv");
      File _file = new File(_plus);
      final PrintStream ps = new PrintStream(_file);
      CharSequence _genSIS = tt.genSIS(fsm);
      ps.append(_genSIS);
      ps.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
