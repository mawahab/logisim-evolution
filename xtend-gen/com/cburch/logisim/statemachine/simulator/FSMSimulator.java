package com.cburch.logisim.statemachine.simulator;

import com.cburch.logisim.statemachine.PrettyPrinter;
import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class FSMSimulator {
  private FSM fsm;
  
  private State current;
  
  private HashMap<Port, Boolean> inputs;
  
  private HashMap<Port, Boolean> outputs;
  
  public FSMSimulator(final FSM fsm) {
    this.fsm = fsm;
    HashMap<Port, Boolean> _hashMap = new HashMap<Port, Boolean>();
    this.inputs = _hashMap;
    HashMap<Port, Boolean> _hashMap_1 = new HashMap<Port, Boolean>();
    this.outputs = _hashMap_1;
    State _start = fsm.getStart();
    this.current = _start;
    this.refreshPorts();
  }
  
  public void refreshPorts() {
    this.inputs.clear();
    this.outputs.clear();
    EList<Port> _in = this.fsm.getIn();
    final Consumer<Port> _function = (Port ip) -> {
      this.inputs.put(ip, Boolean.valueOf(false));
    };
    _in.forEach(_function);
    EList<Port> _out = this.fsm.getOut();
    final Consumer<Port> _function_1 = (Port op) -> {
      this.outputs.put(op, Boolean.valueOf(false));
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
  
  public void setInput(final String ip, final Boolean b) {
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
  
  public Boolean getOutput(final int i) {
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
  
  public Boolean setInput(final InputPort ip, final Boolean b) {
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
      Boolean _get = this.inputs.get(e);
      String _plus_3 = (_plus_2 + _get);
      InputOutput.<String>println(_plus_3);
    }
    CommandList _commandList = this.current.getCommandList();
    EList<Command> _commands = _commandList.getCommands();
    for (final Command c : _commands) {
      {
        BoolExpr _value = c.getValue();
        final boolean res = this.eval(_value);
        OutputPort _name_2 = c.getName();
        this.outputs.replace(_name_2, Boolean.valueOf(res));
        OutputPort _name_3 = c.getName();
        String _name_4 = _name_3.getName();
        String _plus_4 = ("\t" + _name_4);
        String _plus_5 = (_plus_4 + "=");
        String _plus_6 = (_plus_5 + Boolean.valueOf(res));
        InputOutput.<String>println(_plus_6);
      }
    }
    EList<Transition> _transition = this.current.getTransition();
    for (final Transition t : _transition) {
      {
        String _pp = PrettyPrinter.pp(t);
        String _plus_4 = ("Evaluating transition= " + _pp);
        InputOutput.<String>println(_plus_4);
        BoolExpr _predicate = t.getPredicate();
        boolean _eval = this.eval(_predicate);
        if (_eval) {
          State _dst = t.getDst();
          this.current = _dst;
          String _name_2 = this.current.getName();
          String _plus_5 = ("\nTransition fired : next state is " + _name_2);
          InputOutput.<String>println(_plus_5);
        } else {
          InputOutput.<String>println("\nTransition no actived");
        }
      }
    }
    return this.current;
  }
  
  protected boolean _eval(final BoolExpr exp) {
    return false;
  }
  
  protected boolean _eval(final Constant exp) {
    boolean _xifexpression = false;
    String _value = exp.getValue();
    boolean _equals = _value.equals("\"0\"");
    if (_equals) {
      _xifexpression = false;
    } else {
      boolean _xifexpression_1 = false;
      String _value_1 = exp.getValue();
      boolean _equals_1 = _value_1.equals("\"1\"");
      if (_equals_1) {
        _xifexpression_1 = true;
      } else {
        InputOutput.<String>println("ËRROR");
        throw new UnsupportedOperationException("NYI");
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected boolean _eval(final OrExpr b) {
    boolean _xblockexpression = false;
    {
      EList<BoolExpr> _args = b.getArgs();
      for (final BoolExpr arg : _args) {
        boolean _eval = this.eval(arg);
        if (_eval) {
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  protected boolean _eval(final AndExpr b) {
    boolean _xblockexpression = false;
    {
      EList<BoolExpr> _args = b.getArgs();
      for (final BoolExpr arg : _args) {
        boolean _eval = this.eval(arg);
        boolean _not = (!_eval);
        if (_not) {
          return false;
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  protected boolean _eval(final NotExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    BoolExpr _get = _args.get(0);
    boolean _eval = this.eval(_get);
    return (!_eval);
  }
  
  protected boolean _eval(final PortRef b) {
    Port _port = b.getPort();
    return (this.inputs.get(_port)).booleanValue();
  }
  
  public boolean eval(final BoolExpr b) {
    if (b instanceof AndExpr) {
      return _eval((AndExpr)b);
    } else if (b instanceof Constant) {
      return _eval((Constant)b);
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
