package com.cburch.logisim.statemachine.editor.editpanels;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr;
import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class PortReferenceFix {
  private HashMap<String, Port> portMap = new HashMap<String, Port>();
  
  public PortReferenceFix(final FSM fsm) {
    EList<Port> _in = fsm.getIn();
    final Consumer<Port> _function = (Port ip) -> {
      String _name = ip.getName();
      this.portMap.put(_name, ip);
    };
    _in.forEach(_function);
    EList<Port> _out = fsm.getOut();
    final Consumer<Port> _function_1 = (Port op) -> {
      String _name = op.getName();
      this.portMap.put(_name, op);
    };
    _out.forEach(_function_1);
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
  
  protected void _replaceRef(final BoolExpr b) {
    throw new UnsupportedOperationException("NYI");
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
  
  public void replaceRef(final EObject b) {
    if (b instanceof AndExpr) {
      _replaceRef((AndExpr)b);
      return;
    } else if (b instanceof CmpExpr) {
      _replaceRef((CmpExpr)b);
      return;
    } else if (b instanceof Constant) {
      _replaceRef((Constant)b);
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
