package com.cburch.logisim.statemachine.codegen;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
  
  public void export(final FSM fsm, final File f) {
    try {
      final PrintStream ps = new PrintStream(f);
      CharSequence _generate = this.generate(fsm);
      ps.append(_generate);
      ps.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
        return ("_" + _name_2);
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
      {
        EList<State> _states_1 = e.getStates();
        for(final State s : _states_1) {
          _builder.append("\t");
          _builder.append("constant ");
          String _name_2 = s.getName();
          _builder.append(_name_2, "\t");
          _builder.append(" is std_logic_vector(");
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
      _builder.append("symCS <= _");
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
        String _genPred = FSMVHDLCodeGen.genPred(_predicate);
        _builder.append(_genPred, "\t\t\t\t");
        _builder.append(" then");
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
        _builder.append("symCS <= _");
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
        _builder.append(_dst_2, "\t\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("symCS <= _");
        Transition _default_2 = this.getDefault(state);
        State _dst_3 = _default_2.getDst();
        _builder.append(_dst_3, "\t\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected static String _genPred(final OrExpr b) {
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
  
  protected static String _genPred(final AndExpr b) {
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
  
  protected static String _genPred(final NotExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    BoolExpr _get = _args.get(0);
    Object _genPred = FSMVHDLCodeGen.genPred(_get);
    String _plus = ("(/" + _genPred);
    return (_plus + ")");
  }
  
  protected static String _genPred(final PortRef b) {
    Port _port = b.getPort();
    return _port.getName();
  }
  
  protected static String _genPred(final Constant b) {
    return b.getValue();
  }
  
  public CharSequence genCommand(final State s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("when ");
    String _name = s.getName();
    _builder.append(_name, "");
    _builder.append(" => ");
    _builder.newLineIfNotEmpty();
    {
      CommandList _commandList = s.getCommandList();
      EList<Command> _commands = _commandList.getCommands();
      for(final Command c : _commands) {
        String _genCommand = this.genCommand(c);
        _builder.append(_genCommand, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String genCommand(final Command c) {
    OutputPort _name = c.getName();
    String _name_1 = _name.getName();
    String _plus = (_name_1 + "<=");
    BoolExpr _value = c.getValue();
    String _genPred = FSMVHDLCodeGen.genPred(_value);
    String _plus_1 = (_plus + _genPred);
    return (_plus_1 + ";");
  }
  
  public void gen(final Port port) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public CharSequence generate(final FSM e) {
    return _generate(e);
  }
  
  public static String genPred(final BoolExpr b) {
    if (b instanceof AndExpr) {
      return _genPred((AndExpr)b);
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
