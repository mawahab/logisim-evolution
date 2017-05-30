package com.cburch.logisim.statemachine.simulator;

import com.cburch.logisim.statemachine.PrettyPrinter;
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
import com.cburch.logisim.statemachine.fSMDSL.Range;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class FSMSimulator {
  private FSM fsm;
  
  private State current;
  
  private HashMap<Port, String> inputs;
  
  private HashMap<Port, String> outputs;
  
  public FSMSimulator(final FSM fsm) {
    this.fsm = fsm;
    HashMap<Port, String> _hashMap = new HashMap<Port, String>();
    this.inputs = _hashMap;
    HashMap<Port, String> _hashMap_1 = new HashMap<Port, String>();
    this.outputs = _hashMap_1;
    State _start = fsm.getStart();
    this.current = _start;
    this.refreshPorts();
  }
  
  public String quote(final String s) {
    return (("\"" + s) + "\"");
  }
  
  public String zeros(final int width) {
    String _xblockexpression = null;
    {
      String res = "";
      IntegerRange _upTo = new IntegerRange(0, (width - 1));
      for (final int i : _upTo) {
        String _res = res;
        res = (_res + "0");
      }
      _xblockexpression = this.quote(res);
    }
    return _xblockexpression;
  }
  
  public String ones(final int width) {
    String _xblockexpression = null;
    {
      String res = "";
      IntegerRange _upTo = new IntegerRange(0, (width - 1));
      for (final int i : _upTo) {
        String _res = res;
        res = (_res + "1");
      }
      _xblockexpression = this.quote(res);
    }
    return _xblockexpression;
  }
  
  private final static String ZERO = "\"0\"";
  
  private final static String ONE = "\"1\"";
  
  public boolean isTrue(final String s) {
    return s.equals(FSMSimulator.ONE);
  }
  
  public void refreshPorts() {
    this.inputs.clear();
    this.outputs.clear();
    EList<Port> _in = this.fsm.getIn();
    final Consumer<Port> _function = (Port ip) -> {
      int _width = ip.getWidth();
      String _zeros = this.zeros(_width);
      this.inputs.put(ip, _zeros);
    };
    _in.forEach(_function);
    EList<Port> _out = this.fsm.getOut();
    final Consumer<Port> _function_1 = (Port op) -> {
      int _width = op.getWidth();
      String _zeros = this.zeros(_width);
      this.outputs.put(op, _zeros);
    };
    _out.forEach(_function_1);
  }
  
  public FSM getFSM() {
    return this.fsm;
  }
  
  public State reset() {
    State _start = this.fsm.getStart();
    return this.current = _start;
  }
  
  public void setInput(final String ip, final String b) {
    Set<Port> _keySet = this.inputs.keySet();
    for (final Port p : _keySet) {
      String _name = p.getName();
      boolean _equals = Objects.equal(_name, ip);
      if (_equals) {
        this.setInput(((InputPort) p), b);
        return;
      }
    }
    String _name_1 = this.fsm.getName();
    String _plus = ((ip + " is not a known input for fsm ") + _name_1);
    String _plus_1 = (_plus + " ");
    EList<Port> _in = this.fsm.getIn();
    final Function1<Port, String> _function = (Port p_1) -> {
      return p_1.getName();
    };
    List<String> _map = ListExtensions.<Port, String>map(_in, _function);
    String _plus_2 = (_plus_1 + _map);
    throw new RuntimeException(_plus_2);
  }
  
  public String getOutput(final int i) {
    try {
      EList<Port> _out = this.fsm.getOut();
      Port _get = _out.get(i);
      return this.outputs.get(_get);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _plus = (Integer.valueOf(i) + " is not a known output for fsm ");
        String _name = this.fsm.getName();
        String _plus_1 = (_plus + _name);
        String _plus_2 = (_plus_1 + " ");
        EList<Port> _out_1 = this.fsm.getOut();
        final Function1<Port, String> _function = (Port p) -> {
          return p.getName();
        };
        List<String> _map = ListExtensions.<Port, String>map(_out_1, _function);
        String _plus_3 = (_plus_2 + _map);
        throw new RuntimeException(_plus_3);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public String setInput(final InputPort ip, final String b) {
    return this.inputs.put(ip, b);
  }
  
  public State update() {
    String _name = this.current.getName();
    String _plus = ("Current state " + _name);
    InputOutput.<String>println(_plus);
    Set<Port> _keySet = this.inputs.keySet();
    for (final Port e : _keySet) {
      String _name_1 = e.getName();
      String _plus_1 = ("\tinputs" + _name_1);
      String _plus_2 = (_plus_1 + "=>");
      String _get = this.inputs.get(e);
      String _plus_3 = (_plus_2 + _get);
      InputOutput.<String>println(_plus_3);
    }
    CommandList _commandList = this.current.getCommandList();
    EList<Command> _commands = _commandList.getCommands();
    for (final Command c : _commands) {
      {
        BoolExpr _value = c.getValue();
        final String res = this.eval(_value);
        OutputPort _name_2 = c.getName();
        this.outputs.replace(_name_2, res);
        OutputPort _name_3 = c.getName();
        String _name_4 = _name_3.getName();
        String _plus_4 = ("\t" + _name_4);
        String _plus_5 = (_plus_4 + "=");
        String _plus_6 = (_plus_5 + res);
        InputOutput.<String>println(_plus_6);
      }
    }
    State defaultDst = null;
    State nextDst = null;
    EList<Transition> _transition = this.current.getTransition();
    for (final Transition t : _transition) {
      {
        String _pp = PrettyPrinter.pp(t);
        String _plus_4 = ("Evaluating transition= " + _pp);
        InputOutput.<String>println(_plus_4);
        BoolExpr _predicate = t.getPredicate();
        if ((_predicate instanceof DefaultPredicate)) {
          State _dst = t.getDst();
          defaultDst = _dst;
        } else {
          BoolExpr _predicate_1 = t.getPredicate();
          final String res = this.eval(_predicate_1);
          boolean _isTrue = this.isTrue(res);
          if (_isTrue) {
            State _dst_1 = t.getDst();
            nextDst = _dst_1;
            String _name_2 = nextDst.getName();
            String _plus_5 = ("\nTransition fired : next state is " + _name_2);
            InputOutput.<String>println(_plus_5);
          } else {
            InputOutput.<String>println("\nTransition not actived");
          }
        }
      }
    }
    boolean _notEquals = (!Objects.equal(nextDst, null));
    if (_notEquals) {
      this.current = nextDst;
    } else {
      boolean _notEquals_1 = (!Objects.equal(defaultDst, null));
      if (_notEquals_1) {
        this.current = defaultDst;
        String _name_2 = defaultDst.getName();
        String _plus_4 = ("\nDefault transition fired " + _name_2);
        InputOutput.<String>println(_plus_4);
      }
    }
    return this.current;
  }
  
  protected String _eval(final BoolExpr exp) {
    String _pp = PrettyPrinter.pp(exp);
    String _plus = ("Unsupported operation" + _pp);
    throw new RuntimeException(_plus);
  }
  
  protected String _eval(final DefaultPredicate exp) {
    return FSMSimulator.ZERO;
  }
  
  protected String _eval(final CmpExpr b) {
    String _xblockexpression = null;
    {
      EList<BoolExpr> _args = b.getArgs();
      int _size = _args.size();
      boolean _notEquals = (_size != 2);
      if (_notEquals) {
        String _pp = PrettyPrinter.pp(b);
        String _plus = ("Inconsistent arity for expression " + _pp);
        throw new RuntimeException(_plus);
      }
      EList<BoolExpr> _args_1 = b.getArgs();
      BoolExpr _get = _args_1.get(0);
      EList<BoolExpr> _args_2 = b.getArgs();
      BoolExpr _get_1 = _args_2.get(1);
      final boolean equ = _get.equals(_get_1);
      String _switchResult = null;
      String _op = b.getOp();
      switch (_op) {
        case "==":
          String _xifexpression = null;
          if (equ) {
            _xifexpression = this.quote("1");
          } else {
            _xifexpression = this.quote("0");
          }
          _switchResult = _xifexpression;
          break;
        case "!=":
          String _xifexpression_1 = null;
          if (equ) {
            _xifexpression_1 = this.quote("0");
          } else {
            _xifexpression_1 = this.quote("1");
          }
          _switchResult = _xifexpression_1;
          break;
        default:
          String _op_1 = b.getOp();
          String _plus_1 = ("Inconsistent operator " + _op_1);
          String _plus_2 = (_plus_1 + " for expression ");
          String _pp_1 = PrettyPrinter.pp(b);
          String _plus_3 = (_plus_2 + _pp_1);
          throw new RuntimeException(_plus_3);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  protected String _eval(final Constant exp) {
    return exp.getValue();
  }
  
  public String setCharAt(final String s, final char c, final int i) {
    String _xblockexpression = null;
    {
      final StringBuilder myName = new StringBuilder(s);
      myName.setCharAt(i, c);
      _xblockexpression = myName.toString();
    }
    return _xblockexpression;
  }
  
  protected String _eval(final OrExpr b) {
    String _xblockexpression = null;
    {
      int width = (-1);
      List<String> l = new ArrayList<String>();
      String orRes = "";
      EList<BoolExpr> _args = b.getArgs();
      for (final BoolExpr arg : _args) {
        {
          final String res = this.eval(arg);
          l.add(res);
          if ((width == (-1))) {
            int _length = res.length();
            width = _length;
            String _zeros = this.zeros(width);
            orRes = _zeros;
          } else {
            int _length_1 = res.length();
            boolean _notEquals = (width != _length_1);
            if (_notEquals) {
              String _pp = PrettyPrinter.pp(b);
              String _plus = ("Inconsistent width in expression " + _pp);
              throw new RuntimeException(_plus);
            }
          }
          IntegerRange _upTo = new IntegerRange(0, (width - 1));
          for (final Integer i : _upTo) {
            char _charAt = orRes.charAt((i).intValue());
            char _charAt_1 = res.charAt((i).intValue());
            char _or = this.or(_charAt, _charAt_1);
            this.setCharAt(orRes, _or, (i).intValue());
          }
        }
      }
      _xblockexpression = this.quote(orRes);
    }
    return _xblockexpression;
  }
  
  protected String _eval(final AndExpr b) {
    String _xblockexpression = null;
    {
      int width = (-1);
      List<String> l = new ArrayList<String>();
      String andRes = "";
      EList<BoolExpr> _args = b.getArgs();
      for (final BoolExpr arg : _args) {
        {
          final String res = this.eval(arg);
          l.add(res);
          if ((width == (-1))) {
            int _length = res.length();
            width = _length;
            String _zeros = this.zeros(width);
            andRes = _zeros;
          } else {
            int _length_1 = res.length();
            boolean _notEquals = (width != _length_1);
            if (_notEquals) {
              String _pp = PrettyPrinter.pp(b);
              String _plus = ("Inconsistent width in expression " + _pp);
              throw new RuntimeException(_plus);
            }
          }
          IntegerRange _upTo = new IntegerRange(0, (width - 1));
          for (final Integer i : _upTo) {
            char _charAt = andRes.charAt((i).intValue());
            char _charAt_1 = res.charAt((i).intValue());
            char _and = this.and(_charAt, _charAt_1);
            this.setCharAt(andRes, _and, (i).intValue());
          }
        }
      }
      _xblockexpression = this.quote(andRes);
    }
    return _xblockexpression;
  }
  
  protected String _eval(final NotExpr b) {
    String _xblockexpression = null;
    {
      EList<BoolExpr> _args = b.getArgs();
      int _size = _args.size();
      boolean _notEquals = (_size != 1);
      if (_notEquals) {
        String _pp = PrettyPrinter.pp(b);
        String _plus = ("Inconsistent arity for expression " + _pp);
        throw new RuntimeException(_plus);
      }
      int width = (-1);
      List<String> l = new ArrayList<String>();
      String notExpr = "";
      EList<BoolExpr> _args_1 = b.getArgs();
      BoolExpr _get = _args_1.get(0);
      final String res = this.eval(_get);
      l.add(res);
      int _length = res.length();
      width = _length;
      String _zeros = this.zeros(width);
      notExpr = _zeros;
      IntegerRange _upTo = new IntegerRange(0, (width - 1));
      for (final Integer i : _upTo) {
        char _charAt = res.charAt((i).intValue());
        char _not = this.not(_charAt);
        this.setCharAt(notExpr, _not, (i).intValue());
      }
      _xblockexpression = this.quote(notExpr);
    }
    return _xblockexpression;
  }
  
  public char or(final char c, final char b) {
    char _xifexpression = (char) 0;
    boolean _or = false;
    boolean _equals = Objects.equal(Character.valueOf(c), "1");
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(Character.valueOf(b), "1");
      _or = _equals_1;
    }
    if (_or) {
      _xifexpression = '1';
    } else {
      _xifexpression = '0';
    }
    return _xifexpression;
  }
  
  public char and(final char c, final char b) {
    char _xifexpression = (char) 0;
    boolean _and = false;
    boolean _equals = Objects.equal(Character.valueOf(c), "1");
    if (!_equals) {
      _and = false;
    } else {
      boolean _equals_1 = Objects.equal(Character.valueOf(b), "1");
      _and = _equals_1;
    }
    if (_and) {
      _xifexpression = '1';
    } else {
      _xifexpression = '0';
    }
    return _xifexpression;
  }
  
  public char not(final char c) {
    char _xifexpression = (char) 0;
    boolean _equals = Objects.equal(Character.valueOf(c), "1");
    if (_equals) {
      _xifexpression = '0';
    } else {
      _xifexpression = '1';
    }
    return _xifexpression;
  }
  
  protected String _eval(final PortRef b) {
    String _xifexpression = null;
    Range _range = b.getRange();
    boolean _notEquals = (!Objects.equal(_range, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        Range _range_1 = b.getRange();
        int _lb = _range_1.getLb();
        final int lb = (_lb + 1);
        Range _range_2 = b.getRange();
        int _ub = _range_2.getUb();
        final int ub = (_ub + 1);
        Port _port = b.getPort();
        String _get = this.inputs.get(_port);
        String _substring = _get.substring(lb, ub);
        _xblockexpression = this.quote(_substring);
      }
      _xifexpression = _xblockexpression;
    } else {
      Port _port = b.getPort();
      _xifexpression = this.inputs.get(_port);
    }
    return _xifexpression;
  }
  
  public String eval(final BoolExpr b) {
    if (b instanceof AndExpr) {
      return _eval((AndExpr)b);
    } else if (b instanceof CmpExpr) {
      return _eval((CmpExpr)b);
    } else if (b instanceof Constant) {
      return _eval((Constant)b);
    } else if (b instanceof DefaultPredicate) {
      return _eval((DefaultPredicate)b);
    } else if (b instanceof NotExpr) {
      return _eval((NotExpr)b);
    } else if (b instanceof OrExpr) {
      return _eval((OrExpr)b);
    } else if (b instanceof PortRef) {
      return _eval((PortRef)b);
    } else if (b != null) {
      return _eval(b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
