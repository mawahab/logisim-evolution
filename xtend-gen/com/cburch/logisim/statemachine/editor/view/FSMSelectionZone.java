package com.cburch.logisim.statemachine.editor.view;

import com.cburch.logisim.statemachine.editor.view.FSMDrawing;
import com.cburch.logisim.statemachine.editor.view.Zone;
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
public class FSMSelectionZone {
  public enum AreaType {
    INPUT,
    
    OUTPUT,
    
    STATE,
    
    TRANSITION,
    
    NONE;
  }
  
  private FSM fsm = null;
  
  public FSMSelectionZone(final FSM model) {
    this.fsm = model;
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
  
  private final static boolean VERBOSE = false;
  
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
    boolean _and = false;
    if (!((isWithinElement && (o != null)) && (l != null))) {
      _and = false;
    } else {
      int _size = l.size();
      boolean _equals = (_size == 0);
      _and = _equals;
    }
    if (_and) {
      l.add(o);
    }
  }
  
  public void detectElement(final Zone z, final FSMElement o, final List<FSMElement> l) {
    final boolean isWithinElement = this.isWithinZone(z, o);
    if (((isWithinElement && (o != null)) && (l != null))) {
      l.add(o);
    }
  }
  
  public List<FSMElement> getElementsInZone(final Zone z) {
    List<FSMElement> candidates = new ArrayList<FSMElement>();
    this.detectElement(z, this.fsm, candidates);
    EList<Port> _in = this.fsm.getIn();
    for (final Port ip : _in) {
      this.detectElement(z, ip, candidates);
    }
    EList<Port> _out = this.fsm.getOut();
    for (final Port op : _out) {
      this.detectElement(z, op, candidates);
    }
    EList<State> _states = this.fsm.getStates();
    for (final State s : _states) {
      {
        this.detectElement(z, s, candidates);
        CommandList _commandList = s.getCommandList();
        this.detectElement(z, _commandList, candidates);
        EList<Transition> _transition = s.getTransition();
        for (final Transition t : _transition) {
          this.detectElement(z, t, candidates);
        }
      }
    }
    InputOutput.<List<FSMElement>>println(candidates);
    return candidates;
  }
  
  public Object setSelectionZone(final Zone z) {
    return null;
  }
  
  public List<FSMElement> getSelectedElementsAt(final Point p) {
    return null;
  }
  
  public List<FSMElement> getSelectedElements(final Point p) {
    List<FSMElement> candidates = new ArrayList<FSMElement>();
    this.detectElement(p, this.fsm, candidates);
    EList<Port> _in = this.fsm.getIn();
    for (final Port ip : _in) {
      this.detectElement(p, ip, candidates);
    }
    EList<Port> _out = this.fsm.getOut();
    for (final Port op : _out) {
      this.detectElement(p, op, candidates);
    }
    EList<State> _states = this.fsm.getStates();
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
    InputOutput.<List<FSMElement>>println(candidates);
    return candidates;
  }
  
  public FSMSelectionZone.AreaType getAreaType(final Point p) {
    final List<FSMElement> selection = this.getSelectedElements(p);
    int _size = selection.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final FSMElement first = selection.get(0);
      if ((first instanceof State)) {
        return FSMSelectionZone.AreaType.TRANSITION;
      }
    }
    this.computeBoundingBox(this.fsm);
    if (((p.y > this.ymin) && (p.y < this.ymax))) {
      if ((p.x < this.xmin)) {
        return FSMSelectionZone.AreaType.INPUT;
      } else {
        if ((p.x > this.xmax)) {
          return FSMSelectionZone.AreaType.OUTPUT;
        } else {
          return FSMSelectionZone.AreaType.STATE;
        }
      }
    } else {
      return FSMSelectionZone.AreaType.NONE;
    }
  }
  
  protected boolean _isWithinElement(final Point p, final FSMElement e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      Class<? extends FSMElement> _class = e.getClass();
      String _plus = ((((("check if (" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within ") + _class);
      String _plus_1 = (_plus + " [");
      int _x = l.getX();
      String _plus_2 = (_plus_1 + Integer.valueOf(_x));
      String _plus_3 = (_plus_2 + ",");
      int _y = l.getY();
      String _plus_4 = (_plus_3 + Integer.valueOf(_y));
      String _plus_5 = (_plus_4 + ",");
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus_6 = (_x_1 + _width);
      String _plus_7 = (_plus_5 + Integer.valueOf(_plus_6));
      String _plus_8 = (_plus_7 + ",");
      int _y_1 = l.getY();
      int _height = l.getHeight();
      int _plus_9 = (_y_1 + _height);
      String _plus_10 = (_plus_8 + Integer.valueOf(_plus_9));
      String _plus_11 = (_plus_10 + "]");
      this.debug(_plus_11);
      LayoutInfo _layout = e.getLayout();
      boolean _inRectangle = FSMSelectionZone.inRectangle(p.x, p.y, _layout);
      if (_inRectangle) {
        InputOutput.<String>println("\tYES !");
        return true;
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public String debug(final String string) {
    String _xifexpression = null;
    if (FSMSelectionZone.VERBOSE) {
      _xifexpression = InputOutput.<String>println(string);
    }
    return _xifexpression;
  }
  
  public static boolean inRectangle(final int x, final int y, final LayoutInfo l) {
    int _height = l.getHeight();
    boolean _greaterThan = (_height > 0);
    if (_greaterThan) {
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
        int _height_1 = l.getHeight();
        int _plus_1 = (_y_1 + _height_1);
        boolean _lessEqualsThan_1 = (y <= _plus_1);
        _and = _lessEqualsThan_1;
      }
      return _and;
    } else {
      boolean _and_3 = false;
      boolean _and_4 = false;
      boolean _and_5 = false;
      int _x_2 = l.getX();
      boolean _greaterEqualsThan_2 = (x >= _x_2);
      if (!_greaterEqualsThan_2) {
        _and_5 = false;
      } else {
        int _x_3 = l.getX();
        int _width_1 = l.getWidth();
        int _plus_2 = (_x_3 + _width_1);
        boolean _lessEqualsThan_2 = (x <= _plus_2);
        _and_5 = _lessEqualsThan_2;
      }
      if (!_and_5) {
        _and_4 = false;
      } else {
        int _y_2 = l.getY();
        int _height_2 = l.getHeight();
        int _plus_3 = (_y_2 + _height_2);
        boolean _greaterEqualsThan_3 = (y >= _plus_3);
        _and_4 = _greaterEqualsThan_3;
      }
      if (!_and_4) {
        _and_3 = false;
      } else {
        int _y_3 = l.getY();
        boolean _lessEqualsThan_3 = (y <= _y_3);
        _and_3 = _lessEqualsThan_3;
      }
      return _and_3;
    }
  }
  
  protected boolean _isWithinElement(final Point p, final CommandList e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      String _plus = ((((("check if (" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within CommandList[") + Integer.valueOf(_x));
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
      this.debug(_plus_9);
      LayoutInfo _layout = e.getLayout();
      boolean _inRectangle = FSMSelectionZone.inRectangle(p.x, p.y, _layout);
      if (_inRectangle) {
        this.debug("\tYES !");
        return true;
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinElement(final Point p, final FSM e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      String _plus = ((((("check if (" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within FSM [") + Integer.valueOf(_x));
      String _plus_1 = (_plus + ",");
      int _y = l.getY();
      int _plus_2 = (_y + FSMDrawing.FSM_TITLE_HEIGHT);
      String _plus_3 = (_plus_1 + Integer.valueOf(_plus_2));
      String _plus_4 = (_plus_3 + ",");
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus_5 = (_x_1 + _width);
      String _plus_6 = (_plus_4 + Integer.valueOf(_plus_5));
      String _plus_7 = (_plus_6 + ",");
      int _y_1 = l.getY();
      int _plus_8 = (_y_1 + FSMDrawing.FSM_TITLE_HEIGHT);
      String _plus_9 = (_plus_7 + Integer.valueOf(_plus_8));
      String _plus_10 = (_plus_9 + "]");
      this.debug(_plus_10);
      boolean _and = false;
      int _x_2 = l.getX();
      boolean _greaterThan = (p.x > _x_2);
      if (!_greaterThan) {
        _and = false;
      } else {
        int _x_3 = l.getX();
        int _width_1 = l.getWidth();
        int _plus_11 = (_x_3 + _width_1);
        boolean _lessThan = (p.x < _plus_11);
        _and = _lessThan;
      }
      if (_and) {
        boolean _and_1 = false;
        int _y_2 = l.getY();
        boolean _greaterThan_1 = (p.y > _y_2);
        if (!_greaterThan_1) {
          _and_1 = false;
        } else {
          int _y_3 = l.getY();
          int _plus_12 = (_y_3 + FSMDrawing.FSM_TITLE_HEIGHT);
          boolean _lessThan_1 = (p.y < _plus_12);
          _and_1 = _lessThan_1;
        }
        if (_and_1) {
          this.debug("\tYES !");
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinElement(final Point p, final State e) {
    boolean _xblockexpression = false;
    {
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
      String _plus_3 = ((((("check if (" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within circle[") + Integer.valueOf(_plus_2));
      String _plus_4 = (_plus_3 + ",");
      int _y_1 = l.getY();
      int _plus_5 = (_y_1 + radius);
      String _plus_6 = (_plus_4 + Integer.valueOf(_plus_5));
      String _plus_7 = (_plus_6 + ",");
      String _plus_8 = (_plus_7 + Integer.valueOf(radius));
      String _plus_9 = (_plus_8 + "] -> distance = ");
      String _plus_10 = (_plus_9 + Double.valueOf(distance));
      String _plus_11 = (_plus_10 + "  ");
      this.debug(_plus_11);
      if ((distance < radius)) {
        this.debug("\tYES !");
        return true;
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinElement(final Point p, final Transition e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      String _plus = ((((("check if (" + Integer.valueOf(p.x)) + ",") + Integer.valueOf(p.y)) + ") within Transition[") + Integer.valueOf(_x));
      String _plus_1 = (_plus + ",");
      int _y = l.getY();
      String _plus_2 = (_plus_1 + Integer.valueOf(_y));
      String _plus_3 = (_plus_2 + ",");
      int _width = l.getWidth();
      String _plus_4 = (_plus_3 + Integer.valueOf(_width));
      String _plus_5 = (_plus_4 + ",");
      int _height = l.getHeight();
      String _plus_6 = (_plus_5 + Integer.valueOf(_height));
      String _plus_7 = (_plus_6 + ",]   ");
      this.debug(_plus_7);
      boolean _and = false;
      LayoutInfo _layout = e.getLayout();
      boolean _inRectangle = FSMSelectionZone.inRectangle(p.x, p.y, _layout);
      if (!_inRectangle) {
        _and = false;
      } else {
        State _dst = e.getDst();
        boolean _notEquals = (!Objects.equal(_dst, null));
        _and = _notEquals;
      }
      if (_and) {
        this.debug("\tYES !");
        return true;
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
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
      this.debug(_plus_9);
      LayoutInfo _layout = e.getLayout();
      boolean _inRectangle = FSMSelectionZone.inRectangle(p.x, p.y, _layout);
      if (_inRectangle) {
        this.debug("\tYES !");
        return true;
      }
      _xblockexpression = false;
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
      this.debug(_plus_9);
      LayoutInfo _layout = e.getLayout();
      boolean _inRectangle = FSMSelectionZone.inRectangle(p.x, p.y, _layout);
      if (_inRectangle) {
        this.debug("\tYES !");
        return true;
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinZone(final Zone p, final FSMElement e) {
    LayoutInfo _layout = e.getLayout();
    Zone _zone = new Zone(_layout);
    return p.contains(_zone);
  }
  
  protected boolean _isWithinZone(final Zone p, final FSM e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      int _y = l.getY();
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _plus = (_x_1 + _width);
      int _y_1 = l.getY();
      int _plus_1 = (_y_1 + FSMDrawing.FSM_TITLE_HEIGHT);
      Zone _zone = new Zone(_x, _y, _plus, _plus_1);
      _xblockexpression = p.contains(_zone);
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinZone(final Zone p, final State e) {
    boolean _xblockexpression = false;
    {
      final LayoutInfo l = e.getLayout();
      int _x = l.getX();
      int _y = l.getY();
      int _x_1 = l.getX();
      int _width = l.getWidth();
      int _multiply = (2 * _width);
      int _plus = (_x_1 + _multiply);
      int _y_1 = l.getY();
      int _width_1 = l.getWidth();
      int _multiply_1 = (2 * _width_1);
      int _plus_1 = (_y_1 + _multiply_1);
      Zone _zone = new Zone(_x, _y, _plus, _plus_1);
      _xblockexpression = p.contains(_zone);
    }
    return _xblockexpression;
  }
  
  protected boolean _isWithinZone(final Zone p, final Transition e) {
    boolean _and = false;
    LayoutInfo _layout = e.getLayout();
    Zone _zone = new Zone(_layout);
    boolean _contains = p.contains(_zone);
    if (!_contains) {
      _and = false;
    } else {
      State _dst = e.getDst();
      boolean _notEquals = (!Objects.equal(_dst, null));
      _and = _notEquals;
    }
    return _and;
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
  
  public boolean isWithinZone(final Zone p, final FSMElement e) {
    if (e instanceof FSM) {
      return _isWithinZone(p, (FSM)e);
    } else if (e instanceof State) {
      return _isWithinZone(p, (State)e);
    } else if (e instanceof Transition) {
      return _isWithinZone(p, (Transition)e);
    } else if (e != null) {
      return _isWithinZone(p, e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(p, e).toString());
    }
  }
}
