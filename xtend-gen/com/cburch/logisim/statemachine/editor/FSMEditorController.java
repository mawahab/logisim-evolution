package com.cburch.logisim.statemachine.editor;

import com.cburch.logisim.statemachine.editor.FSMView;
import com.cburch.logisim.statemachine.editor.view.FSMCustomFactory;
import com.cburch.logisim.statemachine.editor.view.FSMDrawing;
import com.cburch.logisim.statemachine.editor.view.FSMEdit;
import com.cburch.logisim.statemachine.editor.view.FSMRemoveElement;
import com.cburch.logisim.statemachine.editor.view.FSMSelectionZone;
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
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class FSMEditorController {
  public enum CtrlState {
    IDLE,
    
    SELECT_ZONE,
    
    MOVE_ZONE,
    
    SELECT_ELT,
    
    MOVE_ELT,
    
    SELECT_DST,
    
    ERROR_STATE;
  }
  
  private FSM fsm;
  
  private FSMDrawing drawing;
  
  private FSMEdit edit;
  
  private FSMView view;
  
  private FSMRemoveElement remover;
  
  private List<FSMElement> activeSelection = new ArrayList<FSMElement>();
  
  private Transition newTransition;
  
  private List<FSMElement> clipboard = new ArrayList<FSMElement>();
  
  private Point zoneStart;
  
  private Point zoneEnd;
  
  private Point lastPos;
  
  private Zone selectionZone;
  
  public FSMEditorController.CtrlState state = FSMEditorController.CtrlState.IDLE;
  
  public final static boolean DEBUG = true;
  
  private Point copyStart;
  
  private Map<State, State> copyMap = new HashMap<State, State>();
  
  /**
   * Constructor. Initialize the color to the default color and create the
   * ArrayList to hold the shapes.
   * @param defaultColor
   */
  public FSMEditorController(final FSMView view, final FSM fsm) {
    this.fsm = fsm;
    this.view = view;
    FSMDrawing _fSMDrawing = new FSMDrawing();
    this.drawing = _fSMDrawing;
    FSMEdit _fSMEdit = new FSMEdit();
    this.edit = _fSMEdit;
    FSMRemoveElement _fSMRemoveElement = new FSMRemoveElement(fsm);
    this.remover = _fSMRemoveElement;
  }
  
  public int getNbState() {
    EList<State> _states = this.fsm.getStates();
    return _states.size();
  }
  
  public List<FSMElement> getActiveSelection() {
    return this.activeSelection;
  }
  
  public List<FSMElement> getClipboard() {
    return this.clipboard;
  }
  
  public String findUnassignedStateCode() {
    Object _xblockexpression = null;
    {
      HashMap<String, State> map = new HashMap<String, State>();
      EList<State> _states = this.fsm.getStates();
      for (final State s : _states) {
        String _code = s.getCode();
        map.put(_code, s);
      }
      int _width = this.fsm.getWidth();
      int _doubleLessThan = (1 << _width);
      final int ub = (_doubleLessThan - 1);
      IntegerRange _upTo = new IntegerRange(0, ub);
      for (final Integer n : _upTo) {
        {
          String code = Integer.toBinaryString((n).intValue());
          while ((code.length() < this.fsm.getWidth())) {
            code = ("0" + code);
          }
          code = (("\"" + code) + "\"");
          boolean _containsKey = map.containsKey(code);
          boolean _not = (!_containsKey);
          if (_not) {
            return code;
          }
        }
      }
      _xblockexpression = null;
    }
    return ((String)_xblockexpression);
  }
  
  public boolean addNewState(final int x, final int y) {
    boolean _xblockexpression = false;
    {
      final String code = this.findUnassignedStateCode();
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(code, null));
      if (_notEquals) {
        EList<State> _states = this.fsm.getStates();
        EList<State> _states_1 = this.fsm.getStates();
        int _size = _states_1.size();
        String _plus = ("S" + Integer.valueOf(_size));
        State _state = FSMCustomFactory.state(_plus, code, x, y);
        _xifexpression = _states.add(_state);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Transition addNewTransition(final State src, final int x, final int y) {
    Transition _xblockexpression = null;
    {
      final Transition t = FSMCustomFactory.transition(src, null, x, y);
      boolean _and = false;
      State _src = t.getSrc();
      boolean _equals = Objects.equal(_src, null);
      if (!_equals) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(src, null));
        _and = _notEquals;
      }
      if (_and) {
        t.setSrc(src);
      }
      _xblockexpression = t;
    }
    return _xblockexpression;
  }
  
  public boolean addInputPort(final InputPort ip) {
    EList<Port> _in = this.fsm.getIn();
    return _in.add(ip);
  }
  
  public boolean addNewInputPort(final int x, final int y) {
    EList<Port> _in = this.fsm.getIn();
    EList<Port> _in_1 = this.fsm.getIn();
    int _size = _in_1.size();
    String _plus = ("I" + Integer.valueOf(_size));
    InputPort _inport = FSMCustomFactory.inport(_plus, 1, x, y);
    return _in.add(_inport);
  }
  
  public boolean addNewOutputPort(final int x, final int y) {
    EList<Port> _out = this.fsm.getOut();
    EList<Port> _out_1 = this.fsm.getOut();
    int _size = _out_1.size();
    String _plus = ("O" + Integer.valueOf(_size));
    OutputPort _outport = FSMCustomFactory.outport(_plus, 1, x, y);
    return _out.add(_outport);
  }
  
  /**
   * Draw all of the shapes.
   * @param g
   */
  public void draw(final Graphics2D g) {
    this.drawing.drawElement(this.fsm, g, this.activeSelection);
    String _string = this.state.toString();
    g.drawString(_string, 20, 20);
    boolean _notEquals = (!Objects.equal(this.selectionZone, null));
    if (_notEquals) {
      final float[] f = { ((float) 3.0) };
      BasicStroke _basicStroke = new BasicStroke(((float) 0.3), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, f, 0);
      g.setStroke(_basicStroke);
      final Stroke old = g.getStroke();
      final Point p0 = this.selectionZone.getX0();
      final Point p1 = this.selectionZone.getX1();
      int _abs = Math.abs((p1.x - p0.x));
      int _abs_1 = Math.abs((p1.y - p0.y));
      g.drawRect(p0.x, p0.y, _abs, _abs_1);
      g.setStroke(old);
    }
  }
  
  /**
   * Get the front most shape at a given point. Creates a temp array with all
   * of the shapes at a given point, and returns the last shape in the array.
   * @param p
   * @return frontmost shape
   */
  private void setLayout(final int x, final int y, final FSMElement e) {
    LayoutInfo layout = e.getLayout();
    layout.setX(x);
    layout.setY(y);
  }
  
  public void _move(final int dx, final int dy, final FSMElement e) {
    LayoutInfo _layout = e.getLayout();
    int _x = _layout.getX();
    int _plus = (_x + dx);
    LayoutInfo _layout_1 = e.getLayout();
    int _y = _layout_1.getY();
    int _plus_1 = (_y + dy);
    this.setLayout(_plus, _plus_1, e);
  }
  
  public double distance(final int xa, final int ya, final int xb, final int yb) {
    double _xblockexpression = (double) 0;
    {
      final int dx = (xa - xb);
      final int dy = (ya - yb);
      _xblockexpression = Math.sqrt(((dx * dx) + (dy * dy)));
    }
    return _xblockexpression;
  }
  
  public void _move(final Point last, final Point current, final List<FSMElement> list) {
    final Consumer<FSMElement> _function = (FSMElement e) -> {
      this.move(Integer.valueOf((current.x - last.x)), Integer.valueOf((current.y - last.y)), e);
    };
    list.forEach(_function);
    this.view.repaint();
  }
  
  public void _move(final int dx, final int dy, final CommandList cl) {
    EObject _eContainer = cl.eContainer();
    final State state = ((State) _eContainer);
    final LayoutInfo layout = state.getLayout();
    LayoutInfo _layout = cl.getLayout();
    int _x = _layout.getX();
    int _plus = (_x + dx);
    LayoutInfo _layout_1 = cl.getLayout();
    int _y = _layout_1.getY();
    int _plus_1 = (_y + dy);
    final Point p = new Point(_plus, _plus_1);
    int _x_1 = layout.getX();
    int _y_1 = layout.getY();
    double _distance = this.distance(p.x, p.y, _x_1, _y_1);
    boolean _lessEqualsThan = (_distance <= 400);
    if (_lessEqualsThan) {
      this.setLayout(p.x, p.y, cl);
    } else {
      int _x_2 = layout.getX();
      int _plus_2 = (_x_2 + 45);
      int _y_2 = layout.getY();
      int _plus_3 = (_y_2 + 15);
      this.setLayout(_plus_2, _plus_3, cl);
    }
    this.view.repaint();
  }
  
  public void _move(final int dx, final int dy, final State s) {
    LayoutInfo _layout = s.getLayout();
    int _x = _layout.getX();
    int _plus = (_x + dx);
    LayoutInfo _layout_1 = s.getLayout();
    int _y = _layout_1.getY();
    int _plus_1 = (_y + dy);
    this.setLayout(_plus, _plus_1, s);
    LayoutInfo _layout_2 = s.getLayout();
    int _x_1 = _layout_2.getX();
    int _plus_2 = (_x_1 + 45);
    LayoutInfo _layout_3 = s.getLayout();
    int _y_1 = _layout_3.getY();
    int _plus_3 = (_y_1 + 15);
    CommandList _commandList = s.getCommandList();
    this.setLayout(_plus_2, _plus_3, _commandList);
    this.view.repaint();
  }
  
  public void executeEdit(final Point p) {
    final List<FSMElement> selection = this.view.getElementsAt();
    int _size = selection.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final FSMElement first = selection.get(0);
      this.edit.edit(first);
      this.view.repaint();
    }
  }
  
  public void executeDelete(final Point p) {
    final List<FSMElement> selection = this.view.getElementsAt();
    int _size = selection.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final FSMElement first = selection.get(0);
      this.remover.remove(first);
      this.view.repaint();
    }
  }
  
  public void executeCopy(final Point p) {
    this.copyStart = p;
    ArrayList<FSMElement> _arrayList = new ArrayList<FSMElement>();
    this.clipboard = _arrayList;
    this.copyMap.clear();
    for (final FSMElement e : this.activeSelection) {
      this.copyToClipboard(e);
    }
    for (final FSMElement e_1 : this.clipboard) {
      boolean _matched = false;
      if (!_matched) {
        if (e_1 instanceof State) {
          _matched=true;
          EList<Transition> _transition = ((State)e_1).getTransition();
          for (final Transition t : _transition) {
            State _dst = t.getDst();
            boolean _containsKey = this.copyMap.containsKey(_dst);
            if (_containsKey) {
              State _dst_1 = t.getDst();
              State _get = this.copyMap.get(_dst_1);
              t.setDst(_get);
            }
          }
        }
      }
      if (!_matched) {
        if (e_1 instanceof Transition) {
          _matched=true;
          State _dst = ((Transition)e_1).getDst();
          boolean _containsKey = this.copyMap.containsKey(_dst);
          if (_containsKey) {
            State _dst_1 = ((Transition)e_1).getDst();
            State _get = this.copyMap.get(_dst_1);
            ((Transition)e_1).setDst(_get);
          }
          State _src = ((Transition)e_1).getSrc();
          boolean _containsKey_1 = this.copyMap.containsKey(_src);
          if (_containsKey_1) {
            State _src_1 = ((Transition)e_1).getSrc();
            State _get_1 = this.copyMap.get(_src_1);
            ((Transition)e_1).setSrc(_get_1);
          }
        }
      }
    }
  }
  
  public Object execute(final List<FSMElement> l) {
    return null;
  }
  
  protected Boolean _copyToClipboard(final State e) {
    boolean _xblockexpression = false;
    {
      State _copy = EcoreUtil.<State>copy(e);
      final State cp = ((State) _copy);
      this.copyMap.put(e, cp);
      _xblockexpression = this.clipboard.add(cp);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  protected Boolean _copyToClipboard(final Port e) {
    Port _copy = EcoreUtil.<Port>copy(e);
    return Boolean.valueOf(this.clipboard.add(_copy));
  }
  
  protected Boolean _copyToClipboard(final FSMElement e) {
    return null;
  }
  
  public void executePaste(final Point p) {
    final int dx = (p.x - this.copyStart.x);
    final int dy = (p.y - this.copyStart.y);
    for (final FSMElement e : this.clipboard) {
      this.paste(e, dx, dy);
    }
    this.view.repaint();
  }
  
  protected Boolean _paste(final FSMElement e, final int x, final int y) {
    boolean _and = false;
    int _size = this.activeSelection.size();
    boolean _equals = (_size == 1);
    if (!_equals) {
      _and = false;
    } else {
      FSMElement _get = this.activeSelection.get(0);
      _and = (_get instanceof InputPort);
    }
    if (_and) {
      FSMElement _get_1 = this.activeSelection.get(0);
      final InputPort ip = ((InputPort) _get_1);
      EList<Port> _in = this.fsm.getIn();
      _in.add(ip);
      LayoutInfo _layout = ip.getLayout();
      _layout.setX(x);
      LayoutInfo _layout_1 = ip.getLayout();
      _layout_1.setY(y);
    } else {
      throw new RuntimeException(("Incompatible selection for paste " + this.activeSelection));
    }
    return null;
  }
  
  protected Boolean _paste(final InputPort e, final int dx, final int dy) {
    boolean _xblockexpression = false;
    {
      LayoutInfo _layout = e.getLayout();
      LayoutInfo _layout_1 = e.getLayout();
      int _y = _layout_1.getY();
      int _plus = (dy + _y);
      _layout.setY(_plus);
      String _name = e.getName();
      String _plus_1 = ("copy_of_" + _name);
      e.setName(_plus_1);
      EList<Port> _in = this.fsm.getIn();
      _xblockexpression = _in.add(e);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  protected Boolean _paste(final OutputPort e, final int dx, final int dy) {
    boolean _xblockexpression = false;
    {
      LayoutInfo _layout = e.getLayout();
      LayoutInfo _layout_1 = e.getLayout();
      int _y = _layout_1.getY();
      int _plus = (dy + _y);
      _layout.setY(_plus);
      String _name = e.getName();
      String _plus_1 = ("copy_of_" + _name);
      e.setName(_plus_1);
      EList<Port> _in = this.fsm.getIn();
      _xblockexpression = _in.add(e);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  protected Boolean _paste(final State e, final int dx, final int dy) {
    LayoutInfo _layout = e.getLayout();
    LayoutInfo _layout_1 = e.getLayout();
    int _x = _layout_1.getX();
    int _plus = (_x + dx);
    _layout.setX(_plus);
    LayoutInfo _layout_2 = e.getLayout();
    LayoutInfo _layout_3 = e.getLayout();
    int _y = _layout_3.getY();
    int _plus_1 = (_y + dy);
    _layout_2.setY(_plus_1);
    String _name = e.getName();
    String _plus_2 = ("copy_of_" + _name);
    e.setName(_plus_2);
    EList<State> _states = this.fsm.getStates();
    _states.add(e);
    EList<Transition> _transition = e.getTransition();
    for (final Transition t : _transition) {
      this.paste(t, dx, dy);
    }
    return null;
  }
  
  protected Boolean _paste(final Transition e, final int dx, final int dy) {
    LayoutInfo _layout = e.getLayout();
    LayoutInfo _layout_1 = e.getLayout();
    int _x = _layout_1.getX();
    int _plus = (_x + dx);
    _layout.setX(_plus);
    LayoutInfo _layout_2 = e.getLayout();
    LayoutInfo _layout_3 = e.getLayout();
    int _y = _layout_3.getY();
    int _plus_1 = (_y + dy);
    _layout_2.setY(_plus_1);
    return null;
  }
  
  public void executeCreate(final Point p, final FSMSelectionZone.AreaType type) {
    if (type != null) {
      switch (type) {
        case INPUT:
          this.addNewInputPort(p.x, p.y);
          break;
        case OUTPUT:
          this.addNewOutputPort(p.x, p.y);
          break;
        case STATE:
          this.addNewState(p.x, p.y);
          break;
        case TRANSITION:
          int _size = this.activeSelection.size();
          boolean _equals = (_size == 1);
          if (_equals) {
            this.state = FSMEditorController.CtrlState.SELECT_DST;
            FSMElement _get = this.activeSelection.get(0);
            final State state = ((State) _get);
            Transition _addNewTransition = this.addNewTransition(state, p.x, p.y);
            this.newTransition = _addNewTransition;
            String _name = state.getName();
            String _plus = ("Create Transition from " + _name);
            InputOutput.<String>println(_plus);
          } else {
            throw new RuntimeException("Unsupported case");
          }
          break;
        default:
          return;
      }
    } else {
      return;
    }
    this.view.repaint();
  }
  
  public FSMEditorController.CtrlState executeDoubleClick(final Point p) {
    FSMEditorController.CtrlState _switchResult = null;
    final FSMEditorController.CtrlState state = this.state;
    if (state != null) {
      switch (state) {
        case IDLE:
          this.executeEdit(p);
          break;
        default:
          FSMEditorController.CtrlState _xblockexpression = null;
          {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[RightClick] state " + this.state) + "-> ERROR !!!!"));
            }
            _xblockexpression = this.state = FSMEditorController.CtrlState.ERROR_STATE;
          }
          _switchResult = _xblockexpression;
          break;
      }
    } else {
      FSMEditorController.CtrlState _xblockexpression = null;
      {
        if (FSMEditorController.DEBUG) {
          InputOutput.<String>println((("[RightClick] state " + this.state) + "-> ERROR !!!!"));
        }
        _xblockexpression = this.state = FSMEditorController.CtrlState.ERROR_STATE;
      }
      _switchResult = _xblockexpression;
    }
    return _switchResult;
  }
  
  public void executeRightClick() {
    final FSMEditorController.CtrlState state = this.state;
    if (state != null) {
      switch (state) {
        case IDLE:
          if (FSMEditorController.DEBUG) {
            InputOutput.<String>println((("[RightClick] state " + this.state) + "-> ERROR !!!!"));
          }
          this.view.repaint();
          this.view.showContextMenu();
          break;
        default:
          {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println("[RightClick] going back to IDLE!!!!");
            }
            this.state = FSMEditorController.CtrlState.IDLE;
          }
          break;
      }
    } else {
      {
        if (FSMEditorController.DEBUG) {
          InputOutput.<String>println("[RightClick] going back to IDLE!!!!");
        }
        this.state = FSMEditorController.CtrlState.IDLE;
      }
    }
    this.view.repaint();
  }
  
  public void executePress(final Point p) {
    final List<FSMElement> localSelection = this.view.getElementsAt();
    final FSMEditorController.CtrlState state = this.state;
    if (state != null) {
      switch (state) {
        case IDLE:
          int _size = localSelection.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            FSMElement _get = localSelection.get(0);
            boolean _contains = this.activeSelection.contains(_get);
            boolean _not = (!_contains);
            if (_not) {
              this.activeSelection = localSelection;
            }
            this.state = FSMEditorController.CtrlState.MOVE_ELT;
            Point _point = new Point(p);
            this.zoneStart = _point;
            Point _point_1 = new Point(p);
            this.lastPos = _point_1;
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println(((((("[Press] state IDLE->" + this.state) + " selection =") + this.activeSelection) + ", zone=") + this.selectionZone));
            }
          } else {
            this.state = FSMEditorController.CtrlState.SELECT_ZONE;
            this.zoneStart = p;
            Zone _zone = new Zone(p, p);
            this.selectionZone = _zone;
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Press] state IDLE->" + this.state) + " no selection"));
            }
          }
          break;
        case SELECT_DST:
          if (FSMEditorController.DEBUG) {
            InputOutput.<String>println((((("[Press] state " + this.state) + "-> ") + this.state) + "!!!!"));
          }
          break;
        default:
          {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Press] state " + this.state) + "-> ERROR !!!!"));
            }
            this.state = FSMEditorController.CtrlState.ERROR_STATE;
          }
          break;
      }
    } else {
      {
        if (FSMEditorController.DEBUG) {
          InputOutput.<String>println((("[Press] state " + this.state) + "-> ERROR !!!!"));
        }
        this.state = FSMEditorController.CtrlState.ERROR_STATE;
      }
    }
    this.view.repaint();
  }
  
  public void executeDragged(final Point p) {
    final FSMEditorController.CtrlState state = this.state;
    if (state != null) {
      switch (state) {
        case MOVE_ELT:
          this.move(this.lastPos, p, this.activeSelection);
          this.lastPos = p;
          break;
        case SELECT_ZONE:
          this.zoneEnd = p;
          Zone _zone = new Zone(this.zoneStart, this.zoneEnd);
          this.selectionZone = _zone;
          if (FSMEditorController.DEBUG) {
            InputOutput.<String>println((("[Dragged] state SELECT_ZONE->" + this.state) + " : extending selection zone"));
          }
          break;
        default:
          {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Dragged] state " + this.state) + "-> ERROR !!!!"));
            }
            this.state = FSMEditorController.CtrlState.ERROR_STATE;
          }
          break;
      }
    } else {
      {
        if (FSMEditorController.DEBUG) {
          InputOutput.<String>println((("[Dragged] state " + this.state) + "-> ERROR !!!!"));
        }
        this.state = FSMEditorController.CtrlState.ERROR_STATE;
      }
    }
    this.view.repaint();
  }
  
  public void executeRelease(final Point p) {
    final FSMEditorController.CtrlState state = this.state;
    if (state != null) {
      switch (state) {
        case SELECT_DST:
          boolean _notEquals = (!Objects.equal(this.newTransition, null));
          if (_notEquals) {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Move] state " + this.state) + "-> choosing transition destination state"));
            }
            final List<FSMElement> selection = this.view.getElementsAt();
            int _size = selection.size();
            boolean _equals = (_size == 1);
            if (_equals) {
              final FSMElement first = selection.get(0);
              if ((first instanceof State)) {
                final LayoutInfo layout = this.newTransition.getLayout();
                State _src = this.newTransition.getSrc();
                final LayoutInfo srcLayout = _src.getLayout();
                int _x = srcLayout.getX();
                int _plus = (p.x + _x);
                int _divide = (_plus / 2);
                layout.setX(_divide);
                int _y = srcLayout.getY();
                int _plus_1 = (p.y + _y);
                int _divide_1 = (_plus_1 / 2);
                layout.setY(_divide_1);
                State _src_1 = this.newTransition.getSrc();
                boolean _notEquals_1 = (!Objects.equal(first, _src_1));
                if (_notEquals_1) {
                  this.newTransition.setDst(((State)first));
                } else {
                  this.deleteElement(this.newTransition);
                }
              } else {
                boolean _notEquals_2 = (!Objects.equal(this.newTransition, null));
                if (_notEquals_2) {
                  this.deleteElement(this.newTransition);
                }
              }
              this.newTransition = null;
            }
          }
          this.state = FSMEditorController.CtrlState.IDLE;
          break;
        case MOVE_ELT:
          this.state = FSMEditorController.CtrlState.IDLE;
          if (FSMEditorController.DEBUG) {
            InputOutput.<String>println((("[Release] state " + this.state) + "-> IDLE (end of move)"));
          }
          this.lastPos = null;
          break;
        case SELECT_ZONE:
          this.state = FSMEditorController.CtrlState.IDLE;
          if (FSMEditorController.DEBUG) {
            InputOutput.<String>println((("[Release] state " + this.state) + "-> IDLE (end of zone selection)"));
          }
          this.zoneStart = null;
          this.zoneEnd = null;
          List<FSMElement> _elementsWithin = this.view.getElementsWithin(this.selectionZone);
          this.activeSelection = _elementsWithin;
          this.selectionZone = null;
          break;
        default:
          {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Release] state " + this.state) + "-> ERROR !!!!"));
            }
            this.state = FSMEditorController.CtrlState.ERROR_STATE;
          }
          break;
      }
    } else {
      {
        if (FSMEditorController.DEBUG) {
          InputOutput.<String>println((("[Release] state " + this.state) + "-> ERROR !!!!"));
        }
        this.state = FSMEditorController.CtrlState.ERROR_STATE;
      }
    }
    this.view.repaint();
  }
  
  public void executeMove(final Point p) {
    final FSMEditorController.CtrlState state = this.state;
    if (state != null) {
      switch (state) {
        case SELECT_DST:
          boolean _notEquals = (!Objects.equal(this.newTransition, null));
          if (_notEquals) {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Move] state " + this.state) + "-> choosing transition destination state"));
            }
            final LayoutInfo layout = this.newTransition.getLayout();
            layout.setX(p.x);
            layout.setY(p.y);
          } else {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Release] state " + this.state) + "-> ERROR !!!!"));
            }
            this.state = FSMEditorController.CtrlState.ERROR_STATE;
          }
          break;
        case IDLE:
          if (FSMEditorController.DEBUG) {
            InputOutput.<String>println((("[Move] state " + this.state) + "-> IDLE"));
          }
          this.zoneEnd = p;
          break;
        default:
          {
            if (FSMEditorController.DEBUG) {
              InputOutput.<String>println((("[Release] state " + this.state) + "-> ERROR !!!!"));
            }
            this.state = FSMEditorController.CtrlState.ERROR_STATE;
          }
          break;
      }
    } else {
      {
        if (FSMEditorController.DEBUG) {
          InputOutput.<String>println((("[Release] state " + this.state) + "-> ERROR !!!!"));
        }
        this.state = FSMEditorController.CtrlState.ERROR_STATE;
      }
    }
    this.view.repaint();
  }
  
  public void executeLeftClick(final Point scaledP) {
    if (FSMEditorController.DEBUG) {
      InputOutput.<String>println(("[LeftClick] state " + this.state));
    }
    this.view.repaint();
  }
  
  /**
   * Removes a shape from the drawing.
   * @param shape
   */
  protected void _deleteElement(final FSM e) {
  }
  
  /**
   * Removes a shape from the drawing.
   * @param shape
   */
  protected void _deleteElement(final FSMElement e) {
    this.remover.remove(e);
    this.view.repaint();
  }
  
  /**
   * Moves a shape to the front of the drawing.
   * @param shape
   */
  public void editElement(final FSMElement e) {
    this.edit.edit(e);
  }
  
  public FSM getFSM() {
    return this.fsm;
  }
  
  public void move(final Serializable dx, final Serializable dy, final Object cl) {
    if (dx instanceof Integer
         && dy instanceof Integer
         && cl instanceof CommandList) {
      _move((Integer)dx, (Integer)dy, (CommandList)cl);
      return;
    } else if (dx instanceof Integer
         && dy instanceof Integer
         && cl instanceof State) {
      _move((Integer)dx, (Integer)dy, (State)cl);
      return;
    } else if (dx instanceof Integer
         && dy instanceof Integer
         && cl instanceof FSMElement) {
      _move((Integer)dx, (Integer)dy, (FSMElement)cl);
      return;
    } else if (dx instanceof Point
         && dy instanceof Point
         && cl instanceof List) {
      _move((Point)dx, (Point)dy, (List<FSMElement>)cl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dx, dy, cl).toString());
    }
  }
  
  public Boolean copyToClipboard(final FSMElement e) {
    if (e instanceof Port) {
      return _copyToClipboard((Port)e);
    } else if (e instanceof State) {
      return _copyToClipboard((State)e);
    } else if (e != null) {
      return _copyToClipboard(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public Boolean paste(final FSMElement e, final int dx, final int dy) {
    if (e instanceof InputPort) {
      return _paste((InputPort)e, dx, dy);
    } else if (e instanceof OutputPort) {
      return _paste((OutputPort)e, dx, dy);
    } else if (e instanceof State) {
      return _paste((State)e, dx, dy);
    } else if (e instanceof Transition) {
      return _paste((Transition)e, dx, dy);
    } else if (e != null) {
      return _paste(e, dx, dy);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e, dx, dy).toString());
    }
  }
  
  public void deleteElement(final FSMElement e) {
    if (e instanceof FSM) {
      _deleteElement((FSM)e);
      return;
    } else if (e != null) {
      _deleteElement(e);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
