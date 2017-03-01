package com.cburch.logisim.statemachine.editor.view;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;

@SuppressWarnings("all")
public class FSMCustomFactory {
  public static FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
  
  public static int CMD_OFFSETX = 45;
  
  public static int CMD_OFFSETY = 15;
  
  public static int CMD_WIDTH = 60;
  
  public static int CMD_HEIGHT = 40;
  
  public static int PRED_WIDTH = 20;
  
  public static int PRED_HEIGHT = 15;
  
  public static int PORT_HEIGHT = 30;
  
  public static int PORT_WIDTH = 20;
  
  public static int FSMINFO_HEIGHT = 50;
  
  public static int FSMINFO_WIDTH = 80;
  
  public static int STATE_RADIUS = 30;
  
  public static State state(final String label, final String code, final int x, final int y) {
    State _xblockexpression = null;
    {
      final State s = FSMCustomFactory.factory.createState();
      s.setName(label);
      s.setCode(code);
      CommandList _createCommandList = FSMCustomFactory.factory.createCommandList();
      s.setCommandList(_createCommandList);
      CommandList _commandList = s.getCommandList();
      LayoutInfo _createLayoutInfo = FSMCustomFactory.factory.createLayoutInfo();
      _commandList.setLayout(_createLayoutInfo);
      CommandList _commandList_1 = s.getCommandList();
      LayoutInfo _layout = _commandList_1.getLayout();
      _layout.setX((x + FSMCustomFactory.CMD_OFFSETX));
      CommandList _commandList_2 = s.getCommandList();
      LayoutInfo _layout_1 = _commandList_2.getLayout();
      _layout_1.setY((y + FSMCustomFactory.CMD_OFFSETY));
      CommandList _commandList_3 = s.getCommandList();
      LayoutInfo _layout_2 = _commandList_3.getLayout();
      _layout_2.setWidth(FSMCustomFactory.CMD_WIDTH);
      CommandList _commandList_4 = s.getCommandList();
      LayoutInfo _layout_3 = _commandList_4.getLayout();
      _layout_3.setHeight(FSMCustomFactory.CMD_HEIGHT);
      LayoutInfo _createLayoutInfo_1 = FSMCustomFactory.factory.createLayoutInfo();
      s.setLayout(_createLayoutInfo_1);
      LayoutInfo _layout_4 = s.getLayout();
      _layout_4.setX(x);
      LayoutInfo _layout_5 = s.getLayout();
      _layout_5.setY(y);
      LayoutInfo _layout_6 = s.getLayout();
      _layout_6.setWidth(FSMCustomFactory.STATE_RADIUS);
      LayoutInfo _layout_7 = s.getLayout();
      _layout_7.setHeight(FSMCustomFactory.STATE_RADIUS);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static FSM fsm(final String label) {
    FSM _xblockexpression = null;
    {
      final FSM s = FSMCustomFactory.factory.createFSM();
      s.setName(label);
      LayoutInfo _createLayoutInfo = FSMCustomFactory.factory.createLayoutInfo();
      s.setLayout(_createLayoutInfo);
      LayoutInfo _layout = s.getLayout();
      _layout.setX(15);
      LayoutInfo _layout_1 = s.getLayout();
      _layout_1.setY(15);
      LayoutInfo _layout_2 = s.getLayout();
      _layout_2.setWidth(FSMCustomFactory.FSMINFO_WIDTH);
      LayoutInfo _layout_3 = s.getLayout();
      _layout_3.setHeight(FSMCustomFactory.FSMINFO_WIDTH);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static Transition transition(final State src, final State dst, final int x, final int y) {
    Transition _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final Transition t = factory.createTransition();
      t.setDst(dst);
      t.setSrc(src);
      LayoutInfo _createLayoutInfo = factory.createLayoutInfo();
      t.setLayout(_createLayoutInfo);
      LayoutInfo _layout = t.getLayout();
      _layout.setX(x);
      LayoutInfo _layout_1 = t.getLayout();
      _layout_1.setY(y);
      LayoutInfo _layout_2 = t.getLayout();
      _layout_2.setWidth(FSMCustomFactory.PRED_WIDTH);
      LayoutInfo _layout_3 = t.getLayout();
      _layout_3.setHeight(FSMCustomFactory.PRED_HEIGHT);
      EList<Transition> _transition = src.getTransition();
      _transition.add(t);
      DefaultPredicate _defaultPred = FSMCustomFactory.defaultPred();
      t.setPredicate(_defaultPred);
      _xblockexpression = t;
    }
    return _xblockexpression;
  }
  
  public static DefaultPredicate defaultPred() {
    DefaultPredicate _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final DefaultPredicate t = factory.createDefaultPredicate();
      _xblockexpression = t;
    }
    return _xblockexpression;
  }
  
  public static InputPort inport(final String label, final int width, final int x, final int y) {
    InputPort _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final InputPort s = factory.createInputPort();
      s.setName(label);
      s.setWidth(width);
      LayoutInfo _createLayoutInfo = factory.createLayoutInfo();
      s.setLayout(_createLayoutInfo);
      LayoutInfo _layout = s.getLayout();
      _layout.setX(x);
      LayoutInfo _layout_1 = s.getLayout();
      _layout_1.setY(y);
      LayoutInfo _layout_2 = s.getLayout();
      _layout_2.setWidth(FSMCustomFactory.PORT_WIDTH);
      LayoutInfo _layout_3 = s.getLayout();
      _layout_3.setHeight(FSMCustomFactory.PORT_HEIGHT);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static OutputPort outport(final String label, final int width, final int x, final int y) {
    OutputPort _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final OutputPort s = factory.createOutputPort();
      s.setName(label);
      s.setWidth(width);
      LayoutInfo _createLayoutInfo = factory.createLayoutInfo();
      s.setLayout(_createLayoutInfo);
      LayoutInfo _layout = s.getLayout();
      _layout.setWidth(FSMCustomFactory.PORT_WIDTH);
      LayoutInfo _layout_1 = s.getLayout();
      _layout_1.setHeight(FSMCustomFactory.PORT_HEIGHT);
      LayoutInfo _layout_2 = s.getLayout();
      _layout_2.setX(x);
      LayoutInfo _layout_3 = s.getLayout();
      _layout_3.setY(y);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static PortRef pref(final Port p) {
    PortRef _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final PortRef s = factory.createPortRef();
      s.setPort(p);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static NotExpr negpref(final Port p) {
    PortRef _pref = FSMCustomFactory.pref(p);
    return FSMCustomFactory.not(_pref);
  }
  
  public static AndExpr and(final BoolExpr a, final BoolExpr b) {
    AndExpr _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final AndExpr s = factory.createAndExpr();
      EList<BoolExpr> _args = s.getArgs();
      _args.add(a);
      EList<BoolExpr> _args_1 = s.getArgs();
      _args_1.add(b);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static AndExpr and(final List<BoolExpr> list) {
    AndExpr _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final AndExpr s = factory.createAndExpr();
      for (final BoolExpr bexp : list) {
        boolean _notEquals = (!Objects.equal(bexp, null));
        if (_notEquals) {
          EList<BoolExpr> _args = s.getArgs();
          _args.add(bexp);
        }
      }
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static AndExpr and(final BoolExpr[] list) {
    AndExpr _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final AndExpr s = factory.createAndExpr();
      for (final BoolExpr bexp : list) {
        boolean _notEquals = (!Objects.equal(bexp, null));
        if (_notEquals) {
          EList<BoolExpr> _args = s.getArgs();
          _args.add(bexp);
        }
      }
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static OrExpr or(final BoolExpr a, final BoolExpr b) {
    OrExpr _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final OrExpr s = factory.createOrExpr();
      EList<BoolExpr> _args = s.getArgs();
      _args.add(a);
      EList<BoolExpr> _args_1 = s.getArgs();
      _args_1.add(b);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static OrExpr or(final List<BoolExpr> list) {
    OrExpr _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final OrExpr s = factory.createOrExpr();
      for (final BoolExpr bexp : list) {
        boolean _notEquals = (!Objects.equal(bexp, null));
        if (_notEquals) {
          EList<BoolExpr> _args = s.getArgs();
          _args.add(bexp);
        }
      }
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static OrExpr or(final BoolExpr[] list) {
    OrExpr _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final OrExpr s = factory.createOrExpr();
      for (final BoolExpr bexp : list) {
        boolean _notEquals = (!Objects.equal(bexp, null));
        if (_notEquals) {
          EList<BoolExpr> _args = s.getArgs();
          _args.add(bexp);
        }
      }
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static NotExpr not(final BoolExpr args) {
    NotExpr _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final NotExpr s = factory.createNotExpr();
      EList<BoolExpr> _args = s.getArgs();
      _args.add(args);
      _xblockexpression = s;
    }
    return _xblockexpression;
  }
  
  public static Constant cst(final String v) {
    Constant _xblockexpression = null;
    {
      final FSMDSLFactory factory = FSMDSLFactory.eINSTANCE;
      final Constant p = factory.createConstant();
      p.setValue(v);
      _xblockexpression = p;
    }
    return _xblockexpression;
  }
  
  public static Constant cst(final boolean b) {
    Constant _xifexpression = null;
    if (b) {
      _xifexpression = FSMCustomFactory.cst("\"1\"");
    } else {
      _xifexpression = FSMCustomFactory.cst("\"0\"");
    }
    return _xifexpression;
  }
}
