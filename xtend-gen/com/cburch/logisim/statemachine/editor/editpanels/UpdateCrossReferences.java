package com.cburch.logisim.statemachine.editor.editpanels;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.ConcatExpr;
import com.cburch.logisim.statemachine.fSMDSL.ConstRef;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.ConstantDef;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class UpdateCrossReferences {
  private HashMap<String, Port> portMap = new HashMap<String, Port>();
  
  private HashMap<String, ConstantDef> constMap = new HashMap<String, ConstantDef>();
  
  public UpdateCrossReferences(final FSM fsm) {
    EList<ConstantDef> _constants = fsm.getConstants();
    final Consumer<ConstantDef> _function = (ConstantDef cst) -> {
      String _name = cst.getName();
      this.constMap.put(_name, cst);
    };
    _constants.forEach(_function);
    EList<Port> _in = fsm.getIn();
    final Consumer<Port> _function_1 = (Port ip) -> {
      String _name = ip.getName();
      this.portMap.put(_name, ip);
    };
    _in.forEach(_function_1);
    EList<Port> _out = fsm.getOut();
    final Consumer<Port> _function_2 = (Port op) -> {
      String _name = op.getName();
      this.portMap.put(_name, op);
    };
    _out.forEach(_function_2);
  }
  
  protected void _replaceRef(final Command c) {
    OutputPort _name = c.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
      OutputPort _name_1 = c.getName();
      String _name_2 = _name_1.getName();
      Port _get = this.portMap.get(_name_2);
      c.setName(((OutputPort) _get));
    }
    BoolExpr _value = c.getValue();
    this.replaceRef(_value);
  }
  
  protected void _replaceRef(final Transition t) {
    BoolExpr _predicate = t.getPredicate();
    this.replaceRef(_predicate);
  }
  
  protected void _replaceRef(final BoolExpr b) {
    Class<? extends BoolExpr> _class = b.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("Support for class " + _simpleName);
    String _plus_1 = (_plus + " NYI");
    throw new UnsupportedOperationException(_plus_1);
  }
  
  protected void _replaceRef(final DefaultPredicate b) {
  }
  
  protected void _replaceRef(final Constant b) {
  }
  
  protected void _replaceRef(final OrExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.replaceRef(a);
    };
    _args.forEach(_function);
  }
  
  protected void _replaceRef(final AndExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.replaceRef(a);
    };
    _args.forEach(_function);
  }
  
  protected void _replaceRef(final CmpExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.replaceRef(a);
    };
    _args.forEach(_function);
  }
  
  protected void _replaceRef(final ConcatExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.replaceRef(a);
    };
    _args.forEach(_function);
  }
  
  protected void _replaceRef(final NotExpr b) {
    EList<BoolExpr> _args = b.getArgs();
    final Consumer<BoolExpr> _function = (BoolExpr a) -> {
      this.replaceRef(a);
    };
    _args.forEach(_function);
  }
  
  protected void _replaceRef(final PortRef b) {
    Port _port = b.getPort();
    boolean _notEquals = (!Objects.equal(_port, null));
    if (_notEquals) {
      Port _port_1 = b.getPort();
      String _name = _port_1.getName();
      Port _get = this.portMap.get(_name);
      b.setPort(_get);
    } else {
    }
  }
  
  protected void _replaceRef(final ConstRef b) {
    boolean _and = false;
    ConstantDef _const = b.getConst();
    boolean _notEquals = (!Objects.equal(_const, null));
    if (!_notEquals) {
      _and = false;
    } else {
      ConstantDef _const_1 = b.getConst();
      String _name = _const_1.getName();
      boolean _containsKey = this.constMap.containsKey(_name);
      _and = _containsKey;
    }
    if (_and) {
      ConstantDef _const_2 = b.getConst();
      String _name_1 = _const_2.getName();
      ConstantDef _get = this.constMap.get(_name_1);
      b.setConst(_get);
    }
  }
  
  public void replaceRef(final EObject b) {
    if (b instanceof AndExpr) {
      _replaceRef((AndExpr)b);
      return;
    } else if (b instanceof CmpExpr) {
      _replaceRef((CmpExpr)b);
      return;
    } else if (b instanceof ConcatExpr) {
      _replaceRef((ConcatExpr)b);
      return;
    } else if (b instanceof ConstRef) {
      _replaceRef((ConstRef)b);
      return;
    } else if (b instanceof Constant) {
      _replaceRef((Constant)b);
      return;
    } else if (b instanceof DefaultPredicate) {
      _replaceRef((DefaultPredicate)b);
      return;
    } else if (b instanceof NotExpr) {
      _replaceRef((NotExpr)b);
      return;
    } else if (b instanceof OrExpr) {
      _replaceRef((OrExpr)b);
      return;
    } else if (b instanceof PortRef) {
      _replaceRef((PortRef)b);
      return;
    } else if (b instanceof Transition) {
      _replaceRef((Transition)b);
      return;
    } else if (b instanceof BoolExpr) {
      _replaceRef((BoolExpr)b);
      return;
    } else if (b instanceof Command) {
      _replaceRef((Command)b);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
