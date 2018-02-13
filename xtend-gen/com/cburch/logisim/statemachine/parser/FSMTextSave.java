package com.cburch.logisim.statemachine.parser;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.ConcatExpr;
import com.cburch.logisim.statemachine.fSMDSL.ConstRef;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.ConstantDef;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.Range;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FSMTextSave {
  protected static String _pp(final FSM f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("state_machine ");
    String _name = f.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    LayoutInfo _layout = f.getLayout();
    String _pp = FSMTextSave.pp(_layout);
    _builder.append(_pp, "");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<ConstantDef> _constants = f.getConstants();
      for(final ConstantDef s : _constants) {
        String _pp_1 = FSMTextSave.pp(s);
        _builder.append(_pp_1, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("in ");
    {
      EList<Port> _in = f.getIn();
      for(final Port s_1 : _in) {
        String _pp_2 = FSMTextSave.pp(s_1);
        _builder.append(_pp_2, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("out ");
    {
      EList<Port> _out = f.getOut();
      for(final Port s_2 : _out) {
        String _pp_3 = FSMTextSave.pp(s_2);
        _builder.append(_pp_3, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("codeWidth = ");
    int _width = f.getWidth();
    _builder.append(_width, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("reset = ");
    State _start = f.getStart();
    String _name_1 = _start.getName();
    _builder.append(_name_1, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<State> _states = f.getStates();
      for(final State s_3 : _states) {
        String _pp_4 = FSMTextSave.pp(s_3);
        _builder.append(_pp_4, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected static String _pp(final State b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("state ");
    String _name = b.getName();
    _builder.append(_name, "");
    _builder.append("[");
    String _code = b.getCode();
    _builder.append(_code, "");
    _builder.append("]:");
    _builder.newLineIfNotEmpty();
    _builder.append(" \t");
    {
      LayoutInfo _layout = b.getLayout();
      boolean _tripleNotEquals = (_layout != null);
      if (_tripleNotEquals) {
        LayoutInfo _layout_1 = b.getLayout();
        String _pp = FSMTextSave.pp(_layout_1);
        _builder.append(_pp, " \t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      boolean _and = false;
      CommandList _commandList = b.getCommandList();
      boolean _tripleNotEquals_1 = (_commandList != null);
      if (!_tripleNotEquals_1) {
        _and = false;
      } else {
        CommandList _commandList_1 = b.getCommandList();
        EList<Command> _commands = _commandList_1.getCommands();
        int _size = _commands.size();
        boolean _greaterThan = (_size > 0);
        _and = _greaterThan;
      }
      if (_and) {
        _builder.append("set ");
        {
          CommandList _commandList_2 = b.getCommandList();
          EList<Command> _commands_1 = _commandList_2.getCommands();
          for(final Command c : _commands_1) {
            String _pp_1 = FSMTextSave.pp(c);
            _builder.append(_pp_1, "\t");
          }
        }
        _builder.append("  ");
        LayoutInfo _layout_2 = b.getLayout();
        String _pp_2 = FSMTextSave.pp(_layout_2);
        _builder.append(_pp_2, "\t");
      }
    }
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<Transition> _transition = b.getTransition();
      final Function1<Transition, Boolean> _function = (Transition t) -> {
        BoolExpr _predicate = t.getPredicate();
        return Boolean.valueOf((!(_predicate instanceof DefaultPredicate)));
      };
      Iterable<Transition> _filter = IterableExtensions.<Transition>filter(_transition, _function);
      for(final Transition t : _filter) {
        String _pp_3 = FSMTextSave.pp(t);
        _builder.append(_pp_3, "\t");
      }
    }
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<Transition> _transition_1 = b.getTransition();
      final Function1<Transition, Boolean> _function_1 = (Transition t_1) -> {
        BoolExpr _predicate = t_1.getPredicate();
        return Boolean.valueOf((_predicate instanceof DefaultPredicate));
      };
      Iterable<Transition> _filter_1 = IterableExtensions.<Transition>filter(_transition_1, _function_1);
      for(final Transition t_1 : _filter_1) {
        String _pp_4 = FSMTextSave.pp(t_1);
        _builder.append(_pp_4, "\t");
      }
    }
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected static String _pp(final Port b) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = b.getName();
    _builder.append(_name, "");
    _builder.append("[");
    int _width = b.getWidth();
    _builder.append(_width, "");
    _builder.append("] ");
    {
      LayoutInfo _layout = b.getLayout();
      boolean _tripleNotEquals = (_layout != null);
      if (_tripleNotEquals) {
        _builder.append("  ");
        LayoutInfo _layout_1 = b.getLayout();
        String _pp = FSMTextSave.pp(_layout_1);
        _builder.append(_pp, "");
      }
    }
    _builder.append(";");
    return _builder.toString();
  }
  
  protected static String _pp(final LayoutInfo l) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    String _layout = FSMTextSave.layout(l);
    _builder.append(_layout, "");
    return _builder.toString();
  }
  
  public static String layout(final LayoutInfo l) {
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(l, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[");
      int _x = l.getX();
      _builder.append(_x, "");
      _builder.append(",");
      int _y = l.getY();
      _builder.append(_y, "");
      _builder.append(",");
      int _width = l.getWidth();
      _builder.append(_width, "");
      _builder.append(",");
      int _height = l.getHeight();
      _builder.append(_height, "");
      _builder.append("]");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("[0,0,0,0]");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  protected static String _pp(final Transition b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("goto ");
    State _dst = b.getDst();
    String _name = _dst.getName();
    _builder.append(_name, "");
    _builder.append("  when ");
    BoolExpr _predicate = b.getPredicate();
    String _pp = FSMTextSave.pp(_predicate);
    _builder.append(_pp, "");
    _builder.append(" ");
    {
      LayoutInfo _layout = b.getLayout();
      boolean _tripleNotEquals = (_layout != null);
      if (_tripleNotEquals) {
        _builder.append("  ");
        LayoutInfo _layout_1 = b.getLayout();
        String _pp_1 = FSMTextSave.pp(_layout_1);
        _builder.append(_pp_1, "");
      }
    }
    _builder.append("; ");
    return (_builder.toString() + "\n");
  }
  
  protected static String _pp(final BoolExpr b) {
    return "";
  }
  
  protected static String _pp(final Command c) {
    OutputPort _name = c.getName();
    String _name_1 = _name.getName();
    String _plus = (_name_1 + "=");
    BoolExpr _value = c.getValue();
    String _pp = FSMTextSave.pp(_value);
    String _plus_1 = (_plus + _pp);
    return (_plus_1 + ";");
  }
  
  protected static String _pp(final OrExpr b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      EList<BoolExpr> _args = b.getArgs();
      boolean _hasElements = false;
      for(final BoolExpr i : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("+", "");
        }
        Object _pp = FSMTextSave.pp(i);
        _builder.append(_pp, "");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
  
  protected static String _pp(final ConcatExpr b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    {
      EList<BoolExpr> _args = b.getArgs();
      boolean _hasElements = false;
      for(final BoolExpr i : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        Object _pp = FSMTextSave.pp(i);
        _builder.append(_pp, "");
      }
    }
    _builder.append("}");
    return _builder.toString();
  }
  
  protected static String _pp(final AndExpr b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      EList<BoolExpr> _args = b.getArgs();
      boolean _hasElements = false;
      for(final BoolExpr i : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(".", "");
        }
        Object _pp = FSMTextSave.pp(i);
        _builder.append(_pp, "");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
  
  protected static String _pp(final CmpExpr b) {
    String _switchResult = null;
    String _op = b.getOp();
    switch (_op) {
      case "==":
        EList<BoolExpr> _args = b.getArgs();
        BoolExpr _get = _args.get(0);
        Object _pp = FSMTextSave.pp(_get);
        String _plus = ("(" + _pp);
        String _plus_1 = (_plus + "==");
        EList<BoolExpr> _args_1 = b.getArgs();
        BoolExpr _get_1 = _args_1.get(1);
        Object _pp_1 = FSMTextSave.pp(_get_1);
        String _plus_2 = (_plus_1 + _pp_1);
        _switchResult = (_plus_2 + ")");
        break;
      case "/=":
        EList<BoolExpr> _args_2 = b.getArgs();
        BoolExpr _get_2 = _args_2.get(0);
        Object _pp_2 = FSMTextSave.pp(_get_2);
        String _plus_3 = ("(" + _pp_2);
        String _plus_4 = (_plus_3 + "/=");
        EList<BoolExpr> _args_3 = b.getArgs();
        BoolExpr _get_3 = _args_3.get(1);
        Object _pp_3 = FSMTextSave.pp(_get_3);
        String _plus_5 = (_plus_4 + _pp_3);
        _switchResult = (_plus_5 + ")");
        break;
      default:
        _switchResult = "????";
        break;
    }
    return _switchResult;
  }
  
  protected static String _pp(final NotExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    BoolExpr _get = _args.get(0);
    Object _pp = FSMTextSave.pp(_get);
    String _plus = ("(/" + _pp);
    return (_plus + ")");
  }
  
  protected static String _pp(final PortRef b) {
    String _xifexpression = null;
    Range _range = b.getRange();
    boolean _notEquals = (!Objects.equal(_range, null));
    if (_notEquals) {
      String _xifexpression_1 = null;
      Range _range_1 = b.getRange();
      int _ub = _range_1.getUb();
      boolean _notEquals_1 = (_ub != (-1));
      if (_notEquals_1) {
        Port _port = b.getPort();
        String _name = _port.getName();
        String _plus = (_name + "[");
        Range _range_2 = b.getRange();
        int _ub_1 = _range_2.getUb();
        String _plus_1 = (_plus + Integer.valueOf(_ub_1));
        String _plus_2 = (_plus_1 + ":");
        Range _range_3 = b.getRange();
        int _lb = _range_3.getLb();
        String _plus_3 = (_plus_2 + Integer.valueOf(_lb));
        _xifexpression_1 = (_plus_3 + "]");
      } else {
        Port _port_1 = b.getPort();
        String _name_1 = _port_1.getName();
        String _plus_4 = (_name_1 + "[");
        Range _range_4 = b.getRange();
        int _lb_1 = _range_4.getLb();
        String _plus_5 = (_plus_4 + Integer.valueOf(_lb_1));
        _xifexpression_1 = (_plus_5 + "]");
      }
      _xifexpression = _xifexpression_1;
    } else {
      Port _port_2 = b.getPort();
      _xifexpression = _port_2.getName();
    }
    return _xifexpression;
  }
  
  protected static String _pp(final ConstRef b) {
    ConstantDef _const = b.getConst();
    String _name = _const.getName();
    return ("#" + _name);
  }
  
  protected static String _pp(final DefaultPredicate b) {
    return "default";
  }
  
  protected static String _pp(final Constant b) {
    return b.getValue();
  }
  
  protected static String _pp(final ConstantDef b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("define ");
    String _name = b.getName();
    _builder.append(_name, "");
    _builder.append("=");
    BoolExpr _value = b.getValue();
    Object _pp = FSMTextSave.pp(_value);
    _builder.append(_pp, "");
    _builder.append(" ;");
    String _string = _builder.toString();
    return (_string + "\n");
  }
  
  public static String pp(final EObject b) {
    if (b instanceof AndExpr) {
      return _pp((AndExpr)b);
    } else if (b instanceof CmpExpr) {
      return _pp((CmpExpr)b);
    } else if (b instanceof ConcatExpr) {
      return _pp((ConcatExpr)b);
    } else if (b instanceof ConstRef) {
      return _pp((ConstRef)b);
    } else if (b instanceof Constant) {
      return _pp((Constant)b);
    } else if (b instanceof DefaultPredicate) {
      return _pp((DefaultPredicate)b);
    } else if (b instanceof FSM) {
      return _pp((FSM)b);
    } else if (b instanceof NotExpr) {
      return _pp((NotExpr)b);
    } else if (b instanceof OrExpr) {
      return _pp((OrExpr)b);
    } else if (b instanceof Port) {
      return _pp((Port)b);
    } else if (b instanceof PortRef) {
      return _pp((PortRef)b);
    } else if (b instanceof State) {
      return _pp((State)b);
    } else if (b instanceof Transition) {
      return _pp((Transition)b);
    } else if (b instanceof BoolExpr) {
      return _pp((BoolExpr)b);
    } else if (b instanceof Command) {
      return _pp((Command)b);
    } else if (b instanceof ConstantDef) {
      return _pp((ConstantDef)b);
    } else if (b instanceof LayoutInfo) {
      return _pp((LayoutInfo)b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
