package com.cburch.logisim.statemachine.codegen;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class FSMVHDLCodeGen {
  /**
   * Constructor. Initialize the color to the default color and create the
   * ArrayList to hold the shapes.
   * @param defaultColor
   */
  public FSMVHDLCodeGen() {
  }
  
  public void export(final FSM fsm, final File f) throws FileNotFoundException {
    final PrintStream ps = new PrintStream(f);
    CharSequence _generate = this.generate(fsm);
    ps.append(_generate);
    ps.close();
  }
  
  protected CharSequence _generate(final FSM e) {
    CharSequence _xblockexpression = null;
    {
      ArrayList<Port> ios = new ArrayList<Port>();
      EList<Port> _in = e.getIn();
      ios.addAll(_in);
      EList<Port> _out = e.getOut();
      ios.addAll(_out);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("library IEEE;  ");
      _builder.newLine();
      _builder.append("use IEEE.std_logic_1164.all; ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity ");
      String _name = e.getName();
      _builder.append(_name, "");
      _builder.append(" is port (");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("clk : in std_logic;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("clr : in std_logic;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("en  : in std_logic;");
      _builder.newLine();
      {
        boolean _hasElements = false;
        for(final Port i : ios) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(";", "\t");
          }
          _builder.append("\t");
          CharSequence _genPort = this.genPort(i);
          _builder.append(_genPort, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append(");");
      _builder.newLine();
      _builder.append("end entity;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("architecture RTL of ");
      String _name_1 = e.getName();
      _builder.append(_name_1, "");
      _builder.append(" is");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("type state_type is (");
      EList<State> _states = e.getStates();
      final Function1<State, String> _function = (State s) -> {
        String _name_2 = s.getName();
        return ("S_" + _name_2);
      };
      List<String> _map = ListExtensions.<State, String>map(_states, _function);
      final Function2<String, String, String> _function_1 = (String s1, String s2) -> {
        return ((s1 + ",") + s2);
      };
      String _reduce = IterableExtensions.<String>reduce(_map, _function_1);
      _builder.append(_reduce, "\t");
      _builder.append(");  ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("signal symCS : state_type ;  ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("signal CS : std_logic_vector(");
      int _width = e.getWidth();
      int _minus = (_width - 1);
      _builder.append(_minus, "\t");
      _builder.append(" downto 0) ;  ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("constant ONE : std_logic:=\'1\';");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("constant ZERO : std_logic:=\'0\';");
      _builder.newLine();
      _builder.newLine();
      {
        EList<State> _states_1 = e.getStates();
        for(final State s : _states_1) {
          _builder.append("\t");
          _builder.append("constant ");
          String _name_2 = s.getName();
          _builder.append(_name_2, "\t");
          _builder.append(" : std_logic_vector(");
          int _width_1 = e.getWidth();
          int _minus_1 = (_width_1 - 1);
          _builder.append(_minus_1, "\t");
          _builder.append(" downto 0):=");
          String _code = s.getCode();
          _builder.append(_code, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("begin");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("UPDATE: process(clk,clr)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("begin");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if clr=\'1\' then");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CS <= ");
      State _start = e.getStart();
      String _name_3 = _start.getName();
      _builder.append(_name_3, "\t\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("symCS <= S_");
      State _start_1 = e.getStart();
      String _name_4 = _start_1.getName();
      _builder.append(_name_4, "\t\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("elsif rising_edge(clk) then");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case (CS) is");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      {
        EList<State> _states_2 = e.getStates();
        for(final State s_1 : _states_2) {
          CharSequence _genTransition = this.genTransition(s_1);
          _builder.append(_genTransition, "\t\t\t\t");
        }
      }
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("when others => null;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("end case; ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("end if;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("end process;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("OUTPUT : process(CS,");
      {
        EList<Port> _in_1 = e.getIn();
        boolean _hasElements_1 = false;
        for(final Port i_1 : _in_1) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(",", "\t");
          }
          String _name_5 = i_1.getName();
          _builder.append(_name_5, "\t");
        }
      }
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("begin");
      _builder.newLine();
      _builder.append("\t\t");
      {
        EList<Port> _out_1 = e.getOut();
        for(final Port o : _out_1) {
          CharSequence _genDefaultValue = this.genDefaultValue(o);
          _builder.append(_genDefaultValue, "\t\t");
        }
      }
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("case (CS) is");
      _builder.newLine();
      _builder.append("\t\t\t");
      {
        EList<State> _states_3 = e.getStates();
        for(final State s_2 : _states_3) {
          CharSequence _genCommand = this.genCommand(s_2);
          _builder.append(_genCommand, "\t\t\t");
        }
      }
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("when others => null;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("end case; ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("end process;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("end RTL;");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence genDefaultValue(final Port port) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      int _width = port.getWidth();
      boolean _equals = (_width == 1);
      if (_equals) {
        _xifexpression = "\'0\'";
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        int _width_1 = port.getWidth();
        int _doubleLessThan = (1 << _width_1);
        int _minus = (_doubleLessThan - 1);
        String _binaryString = Integer.toBinaryString(_minus);
        _builder.append(_binaryString, "");
        _builder.append(" \"");
        _xifexpression = _builder.toString();
      }
      final String value = _xifexpression;
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name = port.getName();
      _builder_1.append(_name, "");
      _builder_1.append(" <= ");
      _builder_1.append(value, "");
      _builder_1.append(";");
      _xblockexpression = _builder_1;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _genPort(final Port port) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected CharSequence _genPort(final InputPort port) {
    CharSequence _xifexpression = null;
    int _width = port.getWidth();
    boolean _greaterThan = (_width > 1);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = port.getName();
      _builder.append(_name, "");
      _builder.append(" : in std_logic_vector(");
      int _width_1 = port.getWidth();
      int _minus = (_width_1 - 1);
      _builder.append(_minus, "");
      _builder.append(" downto 0)");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_1 = port.getName();
      _builder_1.append(_name_1, "");
      _builder_1.append(" : in std_logic");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  protected CharSequence _genPort(final OutputPort port) {
    CharSequence _xifexpression = null;
    int _width = port.getWidth();
    boolean _greaterThan = (_width > 1);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = port.getName();
      _builder.append(_name, "");
      _builder.append(" : out std_logic_vector(");
      int _width_1 = port.getWidth();
      int _minus = (_width_1 - 1);
      _builder.append(_minus, "");
      _builder.append(" downto 0)");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_1 = port.getName();
      _builder_1.append(_name_1, "");
      _builder_1.append(" : out std_logic");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public Transition getDefault(final State s) {
    EList<Transition> _transition = s.getTransition();
    final Function1<Transition, Boolean> _function = (Transition p) -> {
      BoolExpr _predicate = p.getPredicate();
      return Boolean.valueOf((_predicate instanceof DefaultPredicate));
    };
    return IterableExtensions.<Transition>findFirst(_transition, _function);
  }
  
  public CharSequence genTransition(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("when ");
    String _name = state.getName();
    _builder.append(_name, "");
    _builder.append(" =>");
    _builder.newLineIfNotEmpty();
    {
      EList<Transition> _transition = state.getTransition();
      final Function1<Transition, Boolean> _function = (Transition t) -> {
        BoolExpr _predicate = t.getPredicate();
        return Boolean.valueOf((!(_predicate instanceof DefaultPredicate)));
      };
      Iterable<Transition> _filter = IterableExtensions.<Transition>filter(_transition, _function);
      for(final Transition t : _filter) {
        _builder.append("\t\t\t\t");
        _builder.append("if ");
        BoolExpr _predicate = t.getPredicate();
        CharSequence _genPred = FSMVHDLCodeGen.genPred(_predicate);
        _builder.append(_genPred, "\t\t\t\t");
        _builder.append("=\'1\'  then");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("CS <= ");
        State _dst = t.getDst();
        String _name_1 = _dst.getName();
        _builder.append(_name_1, "\t\t\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("symCS <= S_");
        State _dst_1 = t.getDst();
        String _name_2 = _dst_1.getName();
        _builder.append(_name_2, "\t\t\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("end if;");
        _builder.newLine();
      }
    }
    {
      Transition _default = this.getDefault(state);
      boolean _notEquals = (!Objects.equal(_default, null));
      if (_notEquals) {
        _builder.append("\t\t\t\t");
        _builder.append("-- default transition");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("CS <= ");
        Transition _default_1 = this.getDefault(state);
        State _dst_2 = _default_1.getDst();
        String _name_3 = _dst_2.getName();
        _builder.append(_name_3, "\t\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("symCS <= S_");
        Transition _default_2 = this.getDefault(state);
        State _dst_3 = _default_2.getDst();
        String _name_4 = _dst_3.getName();
        _builder.append(_name_4, "\t\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected static CharSequence _genPred(final CmpExpr b) {
    CharSequence _switchResult = null;
    String _op = b.getOp();
    switch (_op) {
      case "==":
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        EList<BoolExpr> _args = b.getArgs();
        BoolExpr _get = _args.get(0);
        Object _genPred = FSMVHDLCodeGen.genPred(_get);
        _builder.append(_genPred, "");
        _builder.append("==");
        EList<BoolExpr> _args_1 = b.getArgs();
        BoolExpr _get_1 = _args_1.get(1);
        Object _genPred_1 = FSMVHDLCodeGen.genPred(_get_1);
        _builder.append(_genPred_1, "");
        _builder.append(")");
        _switchResult = _builder;
        break;
      case "!=":
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(");
        EList<BoolExpr> _args_2 = b.getArgs();
        BoolExpr _get_2 = _args_2.get(0);
        Object _genPred_2 = FSMVHDLCodeGen.genPred(_get_2);
        _builder_1.append(_genPred_2, "");
        _builder_1.append("/=");
        EList<BoolExpr> _args_3 = b.getArgs();
        BoolExpr _get_3 = _args_3.get(1);
        Object _genPred_3 = FSMVHDLCodeGen.genPred(_get_3);
        _builder_1.append(_genPred_3, "");
        _builder_1.append(")");
        _switchResult = _builder_1;
        break;
      default:
        throw new UnsupportedOperationException("Not implemented");
    }
    return _switchResult;
  }
  
  protected static CharSequence _genPred(final OrExpr b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      EList<BoolExpr> _args = b.getArgs();
      boolean _hasElements = false;
      for(final BoolExpr i : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(" or ", "");
        }
        Object _genPred = FSMVHDLCodeGen.genPred(i);
        _builder.append(_genPred, "");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
  
  protected static CharSequence _genPred(final AndExpr b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      EList<BoolExpr> _args = b.getArgs();
      boolean _hasElements = false;
      for(final BoolExpr i : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(" and ", "");
        }
        Object _genPred = FSMVHDLCodeGen.genPred(i);
        _builder.append(_genPred, "");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
  
  protected static CharSequence _genPred(final NotExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    BoolExpr _get = _args.get(0);
    Object _genPred = FSMVHDLCodeGen.genPred(_get);
    String _plus = ("(/" + _genPred);
    return (_plus + ")");
  }
  
  protected static CharSequence _genPred(final PortRef b) {
    Port _port = b.getPort();
    return _port.getName();
  }
  
  protected static CharSequence _genPred(final Constant b) {
    String _xblockexpression = null;
    {
      String _value = b.getValue();
      int _length = _value.length();
      boolean _greaterThan = (_length > 3);
      if (_greaterThan) {
        b.getValue();
      } else {
        String _value_1 = b.getValue();
        switch (_value_1) {
          case "\"0\"":
            return "ZERO";
          case "\"1\"":
            return "ONE";
          default:
            String _value_2 = b.getValue();
            String _plus = ("Invalivd one-bit value " + _value_2);
            throw new UnsupportedOperationException(_plus);
        }
      }
      String _value_2 = b.getValue();
      _xblockexpression = _value_2.replace("\"", "\'");
    }
    return _xblockexpression;
  }
  
  public CharSequence genCommand(final State s) {
    CharSequence _xifexpression = null;
    CommandList _commandList = s.getCommandList();
    EList<Command> _commands = _commandList.getCommands();
    int _size = _commands.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("when ");
      String _name = s.getName();
      _builder.append(_name, "");
      _builder.append(" => null;");
      _builder.newLineIfNotEmpty();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("when ");
      String _name_1 = s.getName();
      _builder_1.append(_name_1, "");
      _builder_1.append(" => ");
      _builder_1.newLineIfNotEmpty();
      {
        CommandList _commandList_1 = s.getCommandList();
        EList<Command> _commands_1 = _commandList_1.getCommands();
        for(final Command c : _commands_1) {
          String _genCommand = this.genCommand(c);
          _builder_1.append(_genCommand, "");
          _builder_1.newLineIfNotEmpty();
        }
      }
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public String genCommand(final Command c) {
    OutputPort _name = c.getName();
    String _name_1 = _name.getName();
    String _plus = (_name_1 + "<=");
    BoolExpr _value = c.getValue();
    CharSequence _genPred = FSMVHDLCodeGen.genPred(_value);
    String _plus_1 = (_plus + _genPred);
    return (_plus_1 + ";");
  }
  
  public void gen(final Port port) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public CharSequence generate(final FSM e) {
    return _generate(e);
  }
  
  public CharSequence genPort(final Port port) {
    if (port instanceof InputPort) {
      return _genPort((InputPort)port);
    } else if (port instanceof OutputPort) {
      return _genPort((OutputPort)port);
    } else if (port != null) {
      return _genPort(port);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(port).toString());
    }
  }
  
  public static CharSequence genPred(final BoolExpr b) {
    if (b instanceof AndExpr) {
      return _genPred((AndExpr)b);
    } else if (b instanceof CmpExpr) {
      return _genPred((CmpExpr)b);
    } else if (b instanceof Constant) {
      return _genPred((Constant)b);
    } else if (b instanceof NotExpr) {
      return _genPred((NotExpr)b);
    } else if (b instanceof OrExpr) {
      return _genPred((OrExpr)b);
    } else if (b instanceof PortRef) {
      return _genPred((PortRef)b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
