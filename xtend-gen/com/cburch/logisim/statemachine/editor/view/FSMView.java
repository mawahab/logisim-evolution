package com.cburch.logisim.statemachine.editor.view;

import com.cburch.logisim.statemachine.editor.shapes.Shape;
import com.cburch.logisim.statemachine.editor.view.FSMCustomFactory;
import com.cburch.logisim.statemachine.editor.view.FSMDrawing;
import com.cburch.logisim.statemachine.editor.view.FSMEdit;
import com.cburch.logisim.statemachine.editor.view.FSMRemoveElement;
import com.cburch.logisim.statemachine.editor.view.FSMZones;
import com.cburch.logisim.statemachine.fSMDSL.CommandList;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;
import com.google.common.base.Objects;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class FSMView {
  private ArrayList<Shape> shapes;
  
  private FSM fsm;
  
  private FSMDrawing drawing;
  
  private FSMZones zones;
  
  private FSMEdit edit;
  
  private FSMRemoveElement remover;
  
  /**
   * Constructor. Initialize the color to the default color and create the
   * ArrayList to hold the shapes.
   * @param defaultColor
   */
  public FSMView(final FSM fsm) {
    ArrayList<Shape> _arrayList = new ArrayList<Shape>();
    this.shapes = _arrayList;
    this.fsm = fsm;
    FSMDrawing _fSMDrawing = new FSMDrawing();
    this.drawing = _fSMDrawing;
    FSMZones _fSMZones = new FSMZones();
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
   * Add a new shape to the ArrayList
   * @param shape
   */
  public void addShape(final Shape shape) {
    this.shapes.add(shape);
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
  public void detectElement(final Point p, final FSMElement o, final List<FSMElement> l) {
    final boolean isWithinElement = this.zones.isWithinElement(p, o);
    if (((isWithinElement && (o != null)) && (l != null))) {
      l.add(o);
    }
  }
  
  public List<FSMElement> getActiveElement(final Point p) {
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
    int nbmatch = candidates.size();
    InputOutput.<List<FSMElement>>println(candidates);
    return candidates;
  }
  
  /**
   * Removes a shape from the drawing.
   * @param shape
   */
  public void deleteElement(final EObject e) {
    this.remover.remove(e);
  }
  
  /**
   * Moves a shape to the front of the drawing.
   * @param shape
   */
  public void editElement(final EObject e) {
    this.edit.edit(e);
  }
}
