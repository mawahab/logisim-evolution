package com.cburch.logisim.statemachine.editor.view;

import com.cburch.logisim.statemachine.PrettyPrinter;
import com.cburch.logisim.statemachine.bdd.BDDOptimizer;
import com.cburch.logisim.statemachine.bdd.BitWidthAnalyzer;
import com.cburch.logisim.statemachine.editor.view.FSMCustomFactory;
import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.Range;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FSMValidation {
  private FSM fsm;
  
  private HashSet<State> targets = new HashSet<State>();
  
  private List<String> warnings = new ArrayList<String>();
  
  private List<String> errors = new ArrayList<String>();
  
  private BitWidthAnalyzer analyzer = new BitWidthAnalyzer();
  
  public FSMValidation(final FSM fsm) {
    this.fsm = fsm;
  }
  
  public List<String> getErrors() {
    return this.errors;
  }
  
  public List<String> getWarnings() {
    return this.warnings;
  }
  
  public Boolean _validate(final FSM e) {
    State _start = e.getStart();
    boolean _equals = Objects.equal(_start, null);
    if (_equals) {
      this.error("No initial state");
    }
    EList<State> _states = e.getStates();
    int _size = _states.size();
    boolean _equals_1 = (_size == 0);
    if (_equals_1) {
      this.error("The FSM has no states !");
    }
    EList<Port> _out = e.getOut();
    boolean _equals_2 = Objects.equal(_out, Integer.valueOf(0));
    if (_equals_2) {
      this.warning("The FSM has no output pins !");
    }
    EList<Port> _in = e.getIn();
    boolean _equals_3 = Objects.equal(_in, Integer.valueOf(0));
    if (_equals_3) {
      this.warning("The FSM has no input pins !");
    }
    EList<State> _states_1 = e.getStates();
    for (final State s : _states_1) {
      this.validate(s);
    }
    EList<State> _states_2 = e.getStates();
    for (final State s_1 : _states_2) {
      boolean _and = false;
      State _start_1 = this.fsm.getStart();
      boolean _notEquals = (!Objects.equal(s_1, _start_1));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _contains = this.targets.contains(s_1);
        boolean _not = (!_contains);
        _and = _not;
      }
      if (_and) {
        String _pp = PrettyPrinter.pp(s_1);
        String _plus = ("State " + _pp);
        String _plus_1 = (_plus + " is not reachable from initial state ");
        State _start_2 = e.getStart();
        String _pp_1 = PrettyPrinter.pp(_start_2);
        String _plus_2 = (_plus_1 + _pp_1);
        this.warning(_plus_2);
      }
    }
    return null;
  }
  
  public boolean warning(final String string) {
    return this.warnings.add(string);
  }
  
  public boolean error(final String string) {
    return this.errors.add(string);
  }
  
  public Boolean _validate(final FSMElement e) {
    return null;
  }
  
  public Boolean _validate(final CommandList cl) {
    EList<Command> _commands = cl.getCommands();
    for (final Command c : _commands) {
      {
        try {
          BoolExpr _value = c.getValue();
          this.analyzer.computeBitwidth(_value);
        } catch (final Throwable _t) {
          if (_t instanceof RuntimeException) {
            final RuntimeException e = (RuntimeException)_t;
            String _message = e.getMessage();
            this.error(_message);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        BoolExpr _value_1 = c.getValue();
        this.validateExpr(_value_1, false);
        BoolExpr _value_2 = c.getValue();
        final BDDOptimizer optimizer = new BDDOptimizer(_value_2);
        optimizer.simplify();
        boolean _isAlwaysFalse = optimizer.isAlwaysFalse();
        if (_isAlwaysFalse) {
          String _pp = PrettyPrinter.pp(c);
          String _plus = ("command " + _pp);
          String _plus_1 = (_plus + " is always evaluated to 0");
          this.warning(_plus_1);
        }
        boolean _and = false;
        boolean _isAlwaysTrue = optimizer.isAlwaysTrue();
        if (!_isAlwaysTrue) {
          _and = false;
        } else {
          _and = (!(c instanceof Constant));
        }
        if (_and) {
          String _pp_1 = PrettyPrinter.pp(c);
          String _plus_2 = ("command " + _pp_1);
          String _plus_3 = (_plus_2 + " is always evaluated to 1");
          this.warning(_plus_3);
        }
      }
    }
    return null;
  }
  
  public Boolean _validate(final Transition t) {
    boolean _xblockexpression = false;
    {
      final BoolExpr p = t.getPredicate();
      BoolExpr _predicate = t.getPredicate();
      boolean _equals = Objects.equal(_predicate, null);
      if (_equals) {
        throw new RuntimeException("null Predicate");
      }
      BoolExpr _predicate_1 = t.getPredicate();
      this.validateExpr(_predicate_1, true);
      boolean _xifexpression = false;
      BoolExpr _predicate_2 = t.getPredicate();
      boolean _not = (!(_predicate_2 instanceof DefaultPredicate));
      if (_not) {
        boolean _xtrycatchfinallyexpression = false;
        try {
          boolean _xblockexpression_1 = false;
          {
            final BDDOptimizer optimizer = new BDDOptimizer(p);
            optimizer.simplify();
            boolean _isAlwaysFalse = optimizer.isAlwaysFalse();
            if (_isAlwaysFalse) {
              String _pp = PrettyPrinter.pp(t);
              String _plus = ("Transition  " + _pp);
              String _plus_1 = (_plus + " can never be taken (evaluated to 0)");
              this.error(_plus_1);
            }
            boolean _xifexpression_1 = false;
            boolean _and = false;
            boolean _isAlwaysTrue = optimizer.isAlwaysTrue();
            if (!_isAlwaysTrue) {
              _and = false;
            } else {
              BoolExpr _predicate_3 = t.getPredicate();
              boolean _not_1 = (!(_predicate_3 instanceof DefaultPredicate));
              _and = _not_1;
            }
            if (_and) {
              String _pp_1 = PrettyPrinter.pp(t);
              String _plus_2 = ("Transition " + _pp_1);
              String _plus_3 = (_plus_2 + " is always taken (evaluated to 1)");
              _xifexpression_1 = this.warning(_plus_3);
            }
            _xblockexpression_1 = _xifexpression_1;
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            String _pp = PrettyPrinter.pp(t);
            String _plus = ("BDD analysis for " + _pp);
            String _plus_1 = (_plus + " failed : ");
            String _message = e.getMessage();
            String _plus_2 = (_plus_1 + _message);
            String _plus_3 = (_plus_2 + "\n");
            StackTraceElement[] _stackTrace = e.getStackTrace();
            String _plus_4 = (_plus_3 + _stackTrace);
            _xtrycatchfinallyexpression = this.error(_plus_4);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xifexpression = _xtrycatchfinallyexpression;
      }
      _xblockexpression = _xifexpression;
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public Boolean _validate(final State e) {
    int i = 0;
    int j = 0;
    EObject _eContainer = e.eContainer();
    if ((_eContainer instanceof FSM)) {
      EObject _eContainer_1 = e.eContainer();
      final FSM fsm = ((FSM) _eContainer_1);
      String _code = e.getCode();
      int _length = _code.length();
      int _width = fsm.getWidth();
      int _plus = (_width + 2);
      boolean _notEquals = (_length != _plus);
      if (_notEquals) {
        String _pp = PrettyPrinter.pp(e);
        String _plus_1 = ("State " + _pp);
        String _plus_2 = (_plus_1 + " code is not consistent with FSM configuration (");
        int _width_1 = fsm.getWidth();
        String _plus_3 = (_plus_2 + Integer.valueOf(_width_1));
        String _plus_4 = (_plus_3 + " bits expected");
        this.error(_plus_4);
      }
    }
    EList<Transition> _transition = e.getTransition();
    int _size = _transition.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      String _pp_1 = PrettyPrinter.pp(e);
      String _plus_5 = ("State " + _pp_1);
      String _plus_6 = (_plus_5 + " has no output transition");
      this.warning(_plus_6);
    }
    EList<Transition> _transition_1 = e.getTransition();
    final Function1<Transition, Boolean> _function = (Transition t) -> {
      BoolExpr _predicate = t.getPredicate();
      return Boolean.valueOf((!(_predicate instanceof DefaultPredicate)));
    };
    Iterable<Transition> _filter = IterableExtensions.<Transition>filter(_transition_1, _function);
    final List<Transition> nonDefaultTransitions = IterableExtensions.<Transition>toList(_filter);
    EList<Transition> _transition_2 = e.getTransition();
    int _size_1 = _transition_2.size();
    int _length_1 = ((Object[])Conversions.unwrapArray(nonDefaultTransitions, Object.class)).length;
    int _minus = (_size_1 - _length_1);
    boolean _greaterThan = (_minus > 1);
    if (_greaterThan) {
      String _pp_2 = PrettyPrinter.pp(e);
      String _plus_7 = ("State " + _pp_2);
      String _plus_8 = (_plus_7 + " has multiple default transitions");
      this.error(_plus_8);
    }
    for (final Transition a : nonDefaultTransitions) {
      {
        this.validate(a);
        State _dst = a.getDst();
        this.targets.add(_dst);
        j = 0;
        for (final Transition b : nonDefaultTransitions) {
          {
            if ((i < j)) {
              final BoolExpr pa = a.getPredicate();
              final BoolExpr pb = b.getPredicate();
              BoolExpr _copy = EcoreUtil.<BoolExpr>copy(pa);
              BoolExpr _copy_1 = EcoreUtil.<BoolExpr>copy(pb);
              final OrExpr or = FSMCustomFactory.or(_copy, _copy_1);
              final BDDOptimizer optimizer = new BDDOptimizer(or);
              boolean _isAlwaysFalse = optimizer.isAlwaysFalse();
              boolean _not = (!_isAlwaysFalse);
              if (_not) {
                String _pp_3 = PrettyPrinter.pp(pa);
                String _plus_9 = ("Transitions predicates " + _pp_3);
                String _plus_10 = (_plus_9 + " and ");
                String _pp_4 = PrettyPrinter.pp(pb);
                String _plus_11 = (_plus_10 + _pp_4);
                String _plus_12 = (_plus_11 + " are not mutually exclusive");
                this.error(_plus_12);
              }
            }
            int _j = j;
            j = (_j + 1);
          }
        }
        int _i = i;
        i = (_i + 1);
      }
    }
    return null;
  }
  
  public Boolean _validateExpr(final BoolExpr b, final boolean predicate) {
    return null;
  }
  
  public Boolean _validateExpr(final OrExpr b, final boolean predicate) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.validateExpr(a, predicate);
    };
    _args.forEach(_function);
    return null;
  }
  
  public Boolean _validateExpr(final CmpExpr b, final boolean predicate) {
    EList<BoolExpr> _args = b.getArgs();
    int _size = _args.size();
    boolean _notEquals = (_size != 2);
    if (_notEquals) {
      String _pp = PrettyPrinter.pp(b);
      String _plus = ("Inconsistent number of arguments for " + _pp);
      String _plus_1 = (_plus + " ");
      this.error(_plus_1);
    }
    EList<BoolExpr> _args_1 = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.validateExpr(a, predicate);
    };
    _args_1.forEach(_function);
    return null;
  }
  
  public Boolean _validateExpr(final AndExpr b, final boolean predicate) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.validateExpr(a, predicate);
    };
    _args.forEach(_function);
    return null;
  }
  
  public Boolean _validateExpr(final NotExpr b, final boolean predicate) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.validateExpr(a, predicate);
    };
    _args.forEach(_function);
    return null;
  }
  
  public Boolean _validateExpr(final Constant b, final boolean predicate) {
    return null;
  }
  
  public Boolean _validateExpr(final PortRef b, final boolean predicate) {
    boolean _xifexpression = false;
    Range _range = b.getRange();
    boolean _notEquals = (!Objects.equal(_range, null));
    if (_notEquals) {
      boolean _xblockexpression = false;
      {
        Range _range_1 = b.getRange();
        int _ub = _range_1.getUb();
        Port _port = b.getPort();
        int _width = _port.getWidth();
        int _minus = (_width - 1);
        boolean _greaterThan = (_ub > _minus);
        if (_greaterThan) {
          Range _range_2 = b.getRange();
          int _ub_1 = _range_2.getUb();
          String _plus = ("Inconsistent range [" + Integer.valueOf(_ub_1));
          String _plus_1 = (_plus + ":");
          Range _range_3 = b.getRange();
          int _lb = _range_3.getLb();
          String _plus_2 = (_plus_1 + Integer.valueOf(_lb));
          String _plus_3 = (_plus_2 + "] for port ");
          Port _port_1 = b.getPort();
          String _name = _port_1.getName();
          String _plus_4 = (_plus_3 + _name);
          String _plus_5 = (_plus_4 + "[");
          Port _port_2 = b.getPort();
          int _width_1 = _port_2.getWidth();
          int _minus_1 = (_width_1 - 1);
          String _plus_6 = (_plus_5 + Integer.valueOf(_minus_1));
          String _plus_7 = (_plus_6 + ":0]");
          this.error(_plus_7);
        }
        Range _range_4 = b.getRange();
        int _lb_1 = _range_4.getLb();
        Port _port_3 = b.getPort();
        int _width_2 = _port_3.getWidth();
        int _minus_2 = (_width_2 - 1);
        boolean _greaterThan_1 = (_lb_1 > _minus_2);
        if (_greaterThan_1) {
          Range _range_5 = b.getRange();
          int _ub_2 = _range_5.getUb();
          String _plus_8 = ("Inconsistent range [" + Integer.valueOf(_ub_2));
          String _plus_9 = (_plus_8 + ":");
          Range _range_6 = b.getRange();
          int _lb_2 = _range_6.getLb();
          String _plus_10 = (_plus_9 + Integer.valueOf(_lb_2));
          String _plus_11 = (_plus_10 + "] for port ");
          Port _port_4 = b.getPort();
          String _name_1 = _port_4.getName();
          String _plus_12 = (_plus_11 + _name_1);
          String _plus_13 = (_plus_12 + "[");
          Port _port_5 = b.getPort();
          int _width_3 = _port_5.getWidth();
          int _minus_3 = (_width_3 - 1);
          String _plus_14 = (_plus_13 + Integer.valueOf(_minus_3));
          String _plus_15 = (_plus_14 + ":0]");
          this.error(_plus_15);
        }
        boolean _xifexpression_1 = false;
        Range _range_7 = b.getRange();
        int _lb_3 = _range_7.getLb();
        Range _range_8 = b.getRange();
        int _lb_4 = _range_8.getLb();
        boolean _greaterThan_2 = (_lb_3 > _lb_4);
        if (_greaterThan_2) {
          Range _range_9 = b.getRange();
          int _ub_3 = _range_9.getUb();
          String _plus_16 = ("Inconsistent range [" + Integer.valueOf(_ub_3));
          String _plus_17 = (_plus_16 + ":");
          Range _range_10 = b.getRange();
          int _lb_5 = _range_10.getLb();
          String _plus_18 = (_plus_17 + Integer.valueOf(_lb_5));
          String _plus_19 = (_plus_18 + "] ");
          _xifexpression_1 = this.error(_plus_19);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return Boolean.valueOf(_xifexpression);
  }
  
  public Boolean _validateExpr(final DefaultPredicate b, final boolean predicate) {
    boolean _xifexpression = false;
    if ((!predicate)) {
      _xifexpression = this.error("keyword \"default\" not allowed in command expressions, use \"0\" or \"1\" instead");
    }
    return Boolean.valueOf(_xifexpression);
  }
  
  public Boolean validate(final FSMElement cl) {
    if (cl instanceof CommandList) {
      return _validate((CommandList)cl);
    } else if (cl instanceof FSM) {
      return _validate((FSM)cl);
    } else if (cl instanceof State) {
      return _validate((State)cl);
    } else if (cl instanceof Transition) {
      return _validate((Transition)cl);
    } else if (cl != null) {
      return _validate(cl);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(cl).toString());
    }
  }
  
  public Boolean validateExpr(final BoolExpr b, final boolean predicate) {
    if (b instanceof AndExpr) {
      return _validateExpr((AndExpr)b, predicate);
    } else if (b instanceof CmpExpr) {
      return _validateExpr((CmpExpr)b, predicate);
    } else if (b instanceof Constant) {
      return _validateExpr((Constant)b, predicate);
    } else if (b instanceof DefaultPredicate) {
      return _validateExpr((DefaultPredicate)b, predicate);
    } else if (b instanceof NotExpr) {
      return _validateExpr((NotExpr)b, predicate);
    } else if (b instanceof OrExpr) {
      return _validateExpr((OrExpr)b, predicate);
    } else if (b instanceof PortRef) {
      return _validateExpr((PortRef)b, predicate);
    } else if (b != null) {
      return _validateExpr(b, predicate);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b, predicate).toString());
    }
  }
}
