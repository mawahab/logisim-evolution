package com.cburch.logisim.statemachine.editor;

import com.cburch.logisim.statemachine.editor.FSMPopupMenu;
import com.cburch.logisim.statemachine.editor.FSMView;
import com.cburch.logisim.statemachine.editor.view.FSMCustomFactory;
import com.cburch.logisim.statemachine.editor.view.FSMDrawing;
import com.cburch.logisim.statemachine.editor.view.FSMEdit;
import com.cburch.logisim.statemachine.editor.view.FSMRemoveElement;
import com.cburch.logisim.statemachine.editor.view.FSMZones;
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
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class FSMEditorController {
  private FSM fsm;
  
  private FSMDrawing drawing;
  
  private FSMZones zones;
  
  private FSMEdit edit;
  
  private FSMView view;
  
  private FSMRemoveElement remover;
  
  private FSMElement currentSelection;
  
  private Transition newTransition;
  
  private FSMPopupMenu popupMenu;
  
  /**
   * Constructor. Initialize the color to the default color and create the
   * ArrayList to hold the shapes.
   * @param defaultColor
   */
  public FSMEditorController(final FSMView view, final FSM fsm) {
    this.fsm = fsm;
    this.view = view;
    FSMPopupMenu _fSMPopupMenu = new FSMPopupMenu(view);
    this.popupMenu = _fSMPopupMenu;
    FSMDrawing _fSMDrawing = new FSMDrawing();
    this.drawing = _fSMDrawing;
    FSMZones _fSMZones = new FSMZones(this);
    this.zones = _fSMZones;
    FSMEdit _fSMEdit = new FSMEdit();
    this.edit = _fSMEdit;
    FSMRemoveElement _fSMRemoveElement = new FSMRemoveElement(fsm);
    this.remover = _fSMRemoveElement;
  }
  
  public int getNbState() {
    EList<State> _states = this.fsm.getStates();
    return _states.size();
  }
  
  public boolean addNewState(final int x, final int y) {
    boolean _xblockexpression = false;
    {
      EList<State> _states = this.fsm.getStates();
      int _size = _states.size();
      String code = Integer.toBinaryString(_size);
      int _width = this.fsm.getWidth();
      int _length = code.length();
      int _minus = (_width - _length);
      final int nb0 = Math.max(0, _minus);
      IntegerRange _upTo = new IntegerRange(1, nb0);
      for (final Integer n : _upTo) {
        code = ("0" + code);
      }
      code = (("\"" + code) + "\"");
      EList<State> _states_1 = this.fsm.getStates();
      EList<State> _states_2 = this.fsm.getStates();
      int _size_1 = _states_2.size();
      String _plus = ("S" + Integer.valueOf(_size_1));
      State _state = FSMCustomFactory.state(_plus, code, x, y);
      _xblockexpression = _states_1.add(_state);
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
    this.drawing.drawElement(this.fsm, g);
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
  
  public void _move(final Point p, final FSMElement e) {
    this.setLayout(p.x, p.y, e);
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
  
  public void _move(final Point p, final CommandList cl) {
    EObject _eContainer = cl.eContainer();
    final State state = ((State) _eContainer);
    final LayoutInfo layout = state.getLayout();
    int _x = layout.getX();
    int _y = layout.getY();
    double _distance = this.distance(p.x, p.y, _x, _y);
    boolean _lessEqualsThan = (_distance <= 400);
    if (_lessEqualsThan) {
      this.setLayout(p.x, p.y, cl);
    } else {
      int _x_1 = layout.getX();
      int _plus = (_x_1 + 45);
      int _y_1 = layout.getY();
      int _plus_1 = (_y_1 + 15);
      this.setLayout(_plus, _plus_1, cl);
    }
    this.view.repaint();
  }
  
  public void _move(final Point p, final State s) {
    this.setLayout(p.x, p.y, s);
    LayoutInfo _layout = s.getLayout();
    int _x = _layout.getX();
    int _plus = (_x + 45);
    LayoutInfo _layout_1 = s.getLayout();
    int _y = _layout_1.getY();
    int _plus_1 = (_y + 15);
    CommandList _commandList = s.getCommandList();
    this.setLayout(_plus, _plus_1, _commandList);
    this.view.repaint();
  }
  
  public void executeEdit(final Point p) {
    final List<FSMElement> selection = this.zones.getActiveElement(p);
    int _size = selection.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final FSMElement first = selection.get(0);
      this.edit.edit(first);
      this.view.repaint();
    }
  }
  
  public void executeDelete(final Point p) {
    final List<FSMElement> selection = this.zones.getActiveElement(p);
    int _size = selection.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final FSMElement first = selection.get(0);
      this.remover.remove(first);
      this.view.repaint();
    }
  }
  
  public void executeCreate(final Point p, final FSMZones.AreaType type) {
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
          final State state = ((State) this.currentSelection);
          Transition _addNewTransition = this.addNewTransition(state, p.x, p.y);
          this.newTransition = _addNewTransition;
          String _name = state.getName();
          String _plus = ("Create Transition from " + _name);
          InputOutput.<String>println(_plus);
          break;
        default:
          return;
      }
    } else {
      return;
    }
    this.view.repaint();
  }
  
  public void executeDoubleClick(final Point p) {
    this.executeEdit(p);
  }
  
  public void executeRightClick(final Point p) {
    final List<FSMElement> selection = this.zones.getActiveElement(p);
    int _size = selection.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      FSMElement _get = selection.get(0);
      this.currentSelection = _get;
      FSMZones.AreaType _areaType = this.zones.getAreaType(p, this.fsm);
      this.popupMenu.showPopupMenu(p, _areaType);
    } else {
      FSMZones.AreaType _areaType_1 = this.zones.getAreaType(p, this.fsm);
      this.popupMenu.showPopupMenu(p, _areaType_1);
    }
  }
  
  public FSMElement executePress(final Point p) {
    FSMElement _xblockexpression = null;
    {
      final List<FSMElement> selection = this.zones.getActiveElement(p);
      FSMElement _xifexpression = null;
      int _size = selection.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        FSMElement _xblockexpression_1 = null;
        {
          final FSMElement first = selection.get(0);
          _xblockexpression_1 = this.currentSelection = first;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void executeDragged(final Point p) {
    boolean _notEquals = (!Objects.equal(this.currentSelection, null));
    if (_notEquals) {
      this.move(p, this.currentSelection);
      this.view.repaint();
    }
  }
  
  public void executeMove(final Point p) {
    boolean _notEquals = (!Objects.equal(this.newTransition, null));
    if (_notEquals) {
      InputOutput.<String>println("Move transition");
      final LayoutInfo layout = this.newTransition.getLayout();
      layout.setX(p.x);
      layout.setY(p.y);
      this.view.repaint();
    }
  }
  
  public Transition executeLeftClick(final Point p) {
    Transition _xblockexpression = null;
    {
      final List<FSMElement> selection = this.zones.getActiveElement(p);
      Transition _xifexpression = null;
      int _size = selection.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        Transition _xblockexpression_1 = null;
        {
          final FSMElement first = selection.get(0);
          if ((first instanceof State)) {
            boolean _notEquals = (!Objects.equal(this.newTransition, null));
            if (_notEquals) {
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
            }
          } else {
            boolean _notEquals_2 = (!Objects.equal(this.newTransition, null));
            if (_notEquals_2) {
              this.deleteElement(this.newTransition);
            }
          }
          this.view.repaint();
          _xblockexpression_1 = this.newTransition = null;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Object executeRelease(final Point p) {
    Object _xblockexpression = null;
    {
      this.currentSelection = null;
      Object _xifexpression = null;
      boolean _notEquals = (!Objects.equal(this.newTransition, null));
      if (_notEquals) {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
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
  
  public void move(final Point p, final FSMElement cl) {
    if (cl instanceof CommandList) {
      _move(p, (CommandList)cl);
      return;
    } else if (cl instanceof State) {
      _move(p, (State)cl);
      return;
    } else if (cl != null) {
      _move(p, cl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(p, cl).toString());
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
