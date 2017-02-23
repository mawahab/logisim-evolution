package com.cburch.logisim.statemachine.editor.view;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class FSMRemoveElement {
  private FSM fsm;
  
  public FSMRemoveElement(final FSM fsm) {
    this.fsm = fsm;
  }
  
  protected Boolean _remove(final EObject e) {
    return null;
  }
  
  protected Boolean _remove(final State s) {
    EList<State> _states = this.fsm.getStates();
    _states.remove(s);
    TreeIterator<EObject> _eAllContents = this.fsm.eAllContents();
    Iterator<Transition> _filter = Iterators.<Transition>filter(_eAllContents, Transition.class);
    final Function1<Transition, Boolean> _function = (Transition t) -> {
      State _dst = t.getDst();
      return Boolean.valueOf(Objects.equal(_dst, s));
    };
    Iterator<Transition> _filter_1 = IteratorExtensions.<Transition>filter(_filter, _function);
    final List<Transition> deadTransitions = IteratorExtensions.<Transition>toList(_filter_1);
    for (final Transition t : deadTransitions) {
      this.remove(t);
    }
    return null;
  }
  
  protected Boolean _remove(final Transition t) {
    EObject _eContainer = t.eContainer();
    EList<Transition> _transition = ((State) _eContainer).getTransition();
    return Boolean.valueOf(_transition.remove(t));
  }
  
  protected void _replaceByZero(final PortRef pr) {
    final Constant cst = FSMDSLFactory.eINSTANCE.createConstant();
    cst.setValue("0");
    Port _port = pr.getPort();
    int _width = _port.getWidth();
    boolean _notEquals = (_width != 1);
    if (_notEquals) {
      throw new UnsupportedOperationException("Support for port width>1 not yet available");
    }
    EObject _eContainer = pr.eContainer();
    final BoolExpr roor = ((BoolExpr) _eContainer);
    boolean _matched = false;
    if (!_matched) {
      if (roor instanceof AndExpr) {
        _matched=true;
        EList<BoolExpr> _args = ((AndExpr)roor).getArgs();
        final UnaryOperator<BoolExpr> _function = (BoolExpr x) -> {
          BoolExpr _xifexpression = null;
          boolean _equals = Objects.equal(x, pr);
          if (_equals) {
            _xifexpression = cst;
          } else {
            _xifexpression = x;
          }
          return _xifexpression;
        };
        _args.replaceAll(_function);
      }
    }
    if (!_matched) {
      if (roor instanceof OrExpr) {
        _matched=true;
        EList<BoolExpr> _args = ((OrExpr)roor).getArgs();
        final UnaryOperator<BoolExpr> _function = (BoolExpr x) -> {
          BoolExpr _xifexpression = null;
          boolean _equals = Objects.equal(x, pr);
          if (_equals) {
            _xifexpression = cst;
          } else {
            _xifexpression = x;
          }
          return _xifexpression;
        };
        _args.replaceAll(_function);
      }
    }
    if (!_matched) {
      if (roor instanceof NotExpr) {
        _matched=true;
        EList<BoolExpr> _args = ((NotExpr)roor).getArgs();
        final UnaryOperator<BoolExpr> _function = (BoolExpr x) -> {
          BoolExpr _xifexpression = null;
          boolean _equals = Objects.equal(x, pr);
          if (_equals) {
            _xifexpression = cst;
          } else {
            _xifexpression = x;
          }
          return _xifexpression;
        };
        _args.replaceAll(_function);
      }
    }
  }
  
  protected Boolean _remove(final InputPort e) {
    EList<Port> _in = this.fsm.getIn();
    _in.remove(e);
    TreeIterator<EObject> _eAllContents = this.fsm.eAllContents();
    Iterator<PortRef> _filter = Iterators.<PortRef>filter(_eAllContents, PortRef.class);
    final Function1<PortRef, Boolean> _function = (PortRef c) -> {
      Port _port = c.getPort();
      String _name = _port.getName();
      return Boolean.valueOf(Objects.equal(_name, e));
    };
    Iterator<PortRef> _filter_1 = IteratorExtensions.<PortRef>filter(_filter, _function);
    final List<PortRef> deadRefs = IteratorExtensions.<PortRef>toList(_filter_1);
    for (final PortRef r : deadRefs) {
      this.replaceByZero(r);
    }
    return null;
  }
  
  protected Boolean _remove(final Command c) {
    EObject _eContainer = c.eContainer();
    EList<Command> _commands = ((CommandList) _eContainer).getCommands();
    return Boolean.valueOf(_commands.remove(c));
  }
  
  protected Boolean _remove(final OutputPort op) {
    EList<Port> _out = this.fsm.getOut();
    _out.remove(op);
    TreeIterator<EObject> _eAllContents = this.fsm.eAllContents();
    Iterator<Command> _filter = Iterators.<Command>filter(_eAllContents, Command.class);
    final Function1<Command, Boolean> _function = (Command c) -> {
      OutputPort _name = c.getName();
      return Boolean.valueOf(Objects.equal(_name, op));
    };
    Iterator<Command> _filter_1 = IteratorExtensions.<Command>filter(_filter, _function);
    final List<Command> deadCommands = IteratorExtensions.<Command>toList(_filter_1);
    for (final Command t : deadCommands) {
      this.remove(t);
    }
    return null;
  }
  
  public Boolean remove(final EObject e) {
    if (e instanceof InputPort) {
      return _remove((InputPort)e);
    } else if (e instanceof OutputPort) {
      return _remove((OutputPort)e);
    } else if (e instanceof State) {
      return _remove((State)e);
    } else if (e instanceof Transition) {
      return _remove((Transition)e);
    } else if (e instanceof Command) {
      return _remove((Command)e);
    } else if (e != null) {
      return _remove(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public void replaceByZero(final PortRef pr) {
    _replaceByZero(pr);
    return;
  }
}
