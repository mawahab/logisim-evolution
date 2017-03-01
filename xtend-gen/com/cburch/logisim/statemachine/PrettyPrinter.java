package com.cburch.logisim.statemachine;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class PrettyPrinter {
  protected static String _pp(final FSMElement b) {
    return "";
  }
  
  protected static String _pp(final State b) {
    String _name = b.getName();
    String _plus = (_name + "[");
    String _code = b.getCode();
    String _plus_1 = (_plus + _code);
    return (_plus_1 + "]");
  }
  
  protected static String _pp(final Transition b) {
    String _xifexpression = null;
    State _src = b.getSrc();
    boolean _notEquals = (!Objects.equal(_src, null));
    if (_notEquals) {
      State _src_1 = b.getSrc();
      String _pp = PrettyPrinter.pp(_src_1);
      String _plus = (_pp + "->");
      State _dst = b.getDst();
      String _pp_1 = PrettyPrinter.pp(_dst);
      String _plus_1 = (_plus + _pp_1);
      String _plus_2 = (_plus_1 + " when ");
      BoolExpr _predicate = b.getPredicate();
      String _pp_2 = PrettyPrinter.pp(_predicate);
      _xifexpression = (_plus_2 + _pp_2);
    } else {
      State _dst_1 = b.getDst();
      String _pp_3 = PrettyPrinter.pp(_dst_1);
      String _plus_3 = ("goto" + _pp_3);
      String _plus_4 = (_plus_3 + " when ");
      BoolExpr _predicate_1 = b.getPredicate();
      String _pp_4 = PrettyPrinter.pp(_predicate_1);
      _xifexpression = (_plus_4 + _pp_4);
    }
    return _xifexpression;
  }
  
  protected static String _pp(final CommandList b) {
    EList<Command> _commands = b.getCommands();
    final Function1<Command, String> _function = (Command c) -> {
      return PrettyPrinter.pp(c);
    };
    List<String> _map = ListExtensions.<Command, String>map(_commands, _function);
    final Function2<String, String, String> _function_1 = (String p1, String p2) -> {
      return ((p1 + ";") + p1);
    };
    return IterableExtensions.<String>reduce(_map, _function_1);
  }
  
  protected static String _pp(final BoolExpr b) {
    return "";
  }
  
  protected static String _pp(final Command c) {
    OutputPort _name = c.getName();
    String _name_1 = _name.getName();
    String _plus = (_name_1 + "=");
    BoolExpr _value = c.getValue();
    String _pp = PrettyPrinter.pp(_value);
    return (_plus + _pp);
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
        Object _pp = PrettyPrinter.pp(i);
        _builder.append(_pp, "");
      }
    }
    _builder.append(")");
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
        Object _pp = PrettyPrinter.pp(i);
        _builder.append(_pp, "");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
  
  protected static String _pp(final NotExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    BoolExpr _get = _args.get(0);
    Object _pp = PrettyPrinter.pp(_get);
    String _plus = ("(/" + _pp);
    return (_plus + ")");
  }
  
  protected static String _pp(final PortRef b) {
    Port _port = b.getPort();
    return _port.getName();
  }
  
  protected static String _pp(final DefaultPredicate b) {
    return "default";
  }
  
  protected static String _pp(final Constant b) {
    return b.getValue();
  }
  
  public static String pp(final EObject b) {
    if (b instanceof AndExpr) {
      return _pp((AndExpr)b);
    } else if (b instanceof CommandList) {
      return _pp((CommandList)b);
    } else if (b instanceof Constant) {
      return _pp((Constant)b);
    } else if (b instanceof DefaultPredicate) {
      return _pp((DefaultPredicate)b);
    } else if (b instanceof NotExpr) {
      return _pp((NotExpr)b);
    } else if (b instanceof OrExpr) {
      return _pp((OrExpr)b);
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
    } else if (b instanceof FSMElement) {
      return _pp((FSMElement)b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
