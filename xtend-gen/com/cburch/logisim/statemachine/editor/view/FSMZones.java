package com.cburch.logisim.statemachine.editor.view;

import com.cburch.logisim.statemachine.editor.FSMEditorController;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class FSMZones {
  public enum AreaType {
    INPUT,
    
    OUTPUT,
    
    STATE,
    
    TRANSITION,
    
    NONE;
  }
  
  private FSMEditorController ctrl;
  
  public FSMZones(final FSMEditorController ctrl) {
    this.ctrl = ctrl;
  }
  
  public FSMElement getSelectedElement(final Point p, final FSMElement e) {
    FSMElement _xifexpression = null;
    boolean _isWithinElement = this.isWithinElement(p, e);
    if (_isWithinElement) {
      _xifexpression = e;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  private int xmin;
  
  private int ymin;
  
  private int xmax;
  
  private int ymax;
  
  public int updateBoundingBox(final FSMElement e) {
    int _xblockexpression = (int) 0;
    {
      LayoutInfo _layout = e.getLayout();
      int _x = _layout.getX();
      int _min = Math.min(this.xmin, _x);
      this.xmin = _min;
      LayoutInfo _layout_1 = e.getLayout();
      int _y = _layout_1.getY();
      int _min_1 = Math.min(this.ymin, _y);
      this.ymin = _min_1;
      LayoutInfo _layout_2 = e.getLayout();
      int _x_1 = _layout_2.getX();
      LayoutInfo _layout_3 = e.getLayout();
      int _width = _layout_3.getWidth();
      int _plus = (_x_1 + _width);
      int _max = Math.max(this.xmax, _plus);
      this.xmax = _max;
      LayoutInfo _layout_4 = e.getLayout();
      int _y_1 = _layout_4.getY();
      LayoutInfo _layout_5 = e.getLayout();
      int _height = _layout_5.getHeight();
      int _plus_1 = (_y_1 + _height);
      int _max_1 = Math.max(this.ymax, _plus_1);
      _xblockexpression = this.ymax = _max_1;
    }
    return _xblockexpression;
  }
  
  public void computeBoundingBox(final FSM fsm) {
    this.xmin = Integer.MAX_VALUE;
    this.ymin = Integer.MAX_VALUE;
    this.xmax = 0;
    this.ymax = 0;
    this.updateBoundingBox(fsm);
    EList<State> _states = fsm.getStates();
    for (final State s : _states) {
      {
        this.updateBoundingBox(s);
        EList<Transition> _transition = s.getTransition();
        for (final Transition t : _transition) {
          this.updateBoundingBox(t);
        }
      }
    }
  }
  
  public void detectElement(final Point p, final FSMElement o, final List<FSMElement> l) {
    final boolean isWithinElement = this.isWithinElement(p, o);
    if (((isWithinElement && (o != null)) && (l != null))) {
      l.add(o);
    }
  }
  
  public List<FSMElement> getActiveElement(final Point p) {
    List<FSMElement> candidates = new ArrayList<FSMElement>();
    final FSM fsm = this.ctrl.getFSM();
    this.detectElement(p, fsm, candidates);
    EList<Port> _in = fsm.getIn();
    for (final Port ip : _in) {
      this.detectElement(p, ip, candidates);
    }
    EList<Port> _out = fsm.getOut();
    for (final Port op : _out) {
      this.detectElement(p, op, candidates);
    }
    EList<State> _states = fsm.getStates();
    for (final State s : _states) {
      {
        this.detectElement(p, s, candidates);
        CommandList _commandList = s.getCommandList();
        this.detectElement(p, _commandList, candidates);
        EList<Transition> _transition = s.getTransition();
        for (final Transition t : _transition) {
          this.detectElement(p, t, candidates);
        }
      }
    }
    int nbmatch = candidates.size();
    InputOutput.<List<FSMElement>>println(candidates);
    return candidates;
  }
  
  public FSMZones.AreaType getAreaType(final Point p, final FSM fsm) {
    final List<FSMElement> selection = this.getActiveElement(p);
    int _size = selection.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final FSMElement first = selection.get(0);
      if ((first instanceof State)) {
        return FSMZones.AreaType.TRANSITION;
      }
    }
    this.computeBoundingBox(fsm);
    if (((p.y > this.ymin) && (p.y < this.ymax))) {
      if ((p.x < this.xmin)) {
        return FSMZones.AreaType.INPUT;
      } else {
        if ((p.x > this.xmax)) {
          return FSMZones.AreaType.OUTPUT;
        } else {
          return FSMZones.AreaType.STATE;
        }
      }
    } else {
      return FSMZones.AreaType.NONE;
    }
  }
  
  protected boolean _isWithinElement(final Point p, final FSMElement e) {
    return false;
  }
  
  public static boolean inRectangle(final int x, final int y, final LayoutInfo l) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    int _x = l.getX();
    boolean _greaterEqualsThan = (x >= _x);
    if (!_greaterEqualsThan) {
      _and_2 = false;
    } else {
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus = (_x_1 + _width);
      boolean _lessEqualsThan = (x <= _plus);
      _and_2 = _lessEqualsThan;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      int _y = l.getY();
      boolean _greaterEqualsThan_1 = (y >= _y);
      _and_1 = _greaterEqualsThan_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _y_1 = l.getY();
      int _height = l.getHeight();
      int _plus_1 = (_y_1 + _height);
      boolean _lessEqualsThan_1 = (y <= _plus_1);
      _and = _lessEqualsThan_1;
    }
    return _and;
  }
  
  protected boolean _isWithinElement(final Point p, final CommandList e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      String _plus = ((((("(" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within CommandList[") + Integer.valueOf(_x));
      String _plus_1 = (_plus + ",");
      int _y = l.getY();
      int _height = l.getHeight();
      int _minus = (_y - _height);
      String _plus_2 = (_plus_1 + Integer.valueOf(_minus));
      String _plus_3 = (_plus_2 + ",");
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus_4 = (_x_1 + _width);
      String _plus_5 = (_plus_3 + Integer.valueOf(_plus_4));
      String _plus_6 = (_plus_5 + ",");
      int _y_1 = l.getY();
      String _plus_7 = (_plus_6 + Integer.valueOf(_y_1));
      String _plus_8 = (_plus_7 + "]");
      InputOutput.<String>println(_plus_8);
      LayoutInfo _layout = e.getLayout();
      int _height_1 = _layout.getHeight();
      int _plus_9 = (p.y + _height_1);
      LayoutInfo _layout_1 = e.getLayout();
      _xblockexpression = FSMZones.inRectangle(p.x, _plus_9, _layout_1);
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinElement(final Point p, final FSM e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      String _plus = ((((("(" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within CommandList[") + Integer.valueOf(_x));
      String _plus_1 = (_plus + ",");
      int _y = l.getY();
      int _height = l.getHeight();
      int _minus = (_y - _height);
      String _plus_2 = (_plus_1 + Integer.valueOf(_minus));
      String _plus_3 = (_plus_2 + ",");
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus_4 = (_x_1 + _width);
      String _plus_5 = (_plus_3 + Integer.valueOf(_plus_4));
      String _plus_6 = (_plus_5 + ",");
      int _y_1 = l.getY();
      String _plus_7 = (_plus_6 + Integer.valueOf(_y_1));
      String _plus_8 = (_plus_7 + "]");
      InputOutput.<String>println(_plus_8);
      LayoutInfo _layout = e.getLayout();
      _xblockexpression = FSMZones.inRectangle(p.x, p.y, _layout);
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinElement(final Point p, final State e) {
    final LayoutInfo l = e.getLayout();
    final int radius = l.getWidth();
    int _x = l.getX();
    int _plus = (_x + radius);
    final int dx = (p.x - _plus);
    int _y = l.getY();
    int _plus_1 = (_y + radius);
    final int dy = (p.y - _plus_1);
    final double distance = Math.sqrt(((dx * dx) + (dy * dy)));
    int _x_1 = l.getX();
    int _plus_2 = (_x_1 + radius);
    String _plus_3 = ((((((("(" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") distant from ") + Double.valueOf(distance)) + " to circle[") + Integer.valueOf(_plus_2));
    String _plus_4 = (_plus_3 + ",");
    int _y_1 = l.getY();
    int _plus_5 = (_y_1 + radius);
    String _plus_6 = (_plus_4 + Integer.valueOf(_plus_5));
    String _plus_7 = (_plus_6 + ",");
    String _plus_8 = (_plus_7 + Integer.valueOf(radius));
    String _plus_9 = (_plus_8 + "]");
    InputOutput.<String>println(_plus_9);
    return (distance < radius);
  }
  
  protected boolean _isWithinElement(final Point p, final Transition e) {
    boolean _and = false;
    LayoutInfo _layout = e.getLayout();
    boolean _inRectangle = FSMZones.inRectangle(p.x, p.y, _layout);
    if (!_inRectangle) {
      _and = false;
    } else {
      State _dst = e.getDst();
      boolean _notEquals = (!Objects.equal(_dst, null));
      _and = _notEquals;
    }
    return _and;
  }
  
  protected boolean _isWithinElement(final Point p, final InputPort e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      String _plus = ((((("(" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within InPort[") + Integer.valueOf(_x));
      String _plus_1 = (_plus + ",");
      int _y = l.getY();
      String _plus_2 = (_plus_1 + Integer.valueOf(_y));
      String _plus_3 = (_plus_2 + ",");
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus_4 = (_x_1 + _width);
      String _plus_5 = (_plus_3 + Integer.valueOf(_plus_4));
      String _plus_6 = (_plus_5 + ",");
      int _y_1 = l.getY();
      int _height = l.getHeight();
      int _plus_7 = (_y_1 + _height);
      String _plus_8 = (_plus_6 + Integer.valueOf(_plus_7));
      String _plus_9 = (_plus_8 + "]");
      InputOutput.<String>println(_plus_9);
      LayoutInfo _layout = e.getLayout();
      _xblockexpression = FSMZones.inRectangle(p.x, p.y, _layout);
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinElement(final Point p, final OutputPort e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      String _plus = ((((("(" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within OutPort[") + Integer.valueOf(_x));
      String _plus_1 = (_plus + ",");
      int _y = l.getY();
      String _plus_2 = (_plus_1 + Integer.valueOf(_y));
      String _plus_3 = (_plus_2 + ",");
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus_4 = (_x_1 + _width);
      String _plus_5 = (_plus_3 + Integer.valueOf(_plus_4));
      String _plus_6 = (_plus_5 + ",");
      int _y_1 = l.getY();
      int _height = l.getHeight();
      int _plus_7 = (_y_1 + _height);
      String _plus_8 = (_plus_6 + Integer.valueOf(_plus_7));
      String _plus_9 = (_plus_8 + "]");
      InputOutput.<String>println(_plus_9);
      LayoutInfo _layout = e.getLayout();
      _xblockexpression = FSMZones.inRectangle(p.x, p.y, _layout);
    }
    return _xblockexpression;
  }
  
  public boolean isWithinElement(final Point p, final FSMElement e) {
    if (e instanceof InputPort) {
      return _isWithinElement(p, (InputPort)e);
    } else if (e instanceof OutputPort) {
      return _isWithinElement(p, (OutputPort)e);
    } else if (e instanceof CommandList) {
      return _isWithinElement(p, (CommandList)e);
    } else if (e instanceof FSM) {
      return _isWithinElement(p, (FSM)e);
    } else if (e instanceof State) {
      return _isWithinElement(p, (State)e);
    } else if (e instanceof Transition) {
      return _isWithinElement(p, (Transition)e);
    } else if (e != null) {
      return _isWithinElement(p, e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(p, e).toString());
    }
  }
}
