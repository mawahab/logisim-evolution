package com.cburch.logisim.statemachine.editor.view

// Drawing.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds various methods for manipulating and storing the shapes in the drawing.

import com.cburch.logisim.statemachine.editor.shapes.CommandShape
import com.cburch.logisim.statemachine.editor.shapes.FSMInputShape
import com.cburch.logisim.statemachine.editor.shapes.FSMStateShape
import com.cburch.logisim.statemachine.editor.shapes.Shape
import com.cburch.logisim.statemachine.editor.shapes.TransitionShape
import com.cburch.logisim.statemachine.fSMDSL.FSM
import com.cburch.logisim.statemachine.fSMDSL.FSMElement
import com.cburch.logisim.statemachine.fSMDSL.InputPort
import com.cburch.logisim.statemachine.fSMDSL.Port
import com.cburch.logisim.statemachine.fSMDSL.State
import com.cburch.logisim.statemachine.fSMDSL.Transition
import java.awt.Graphics2D
import java.awt.Point
import java.util.ArrayList
import java.util.List
import javax.swing.JOptionPane
import org.eclipse.emf.ecore.EObject

class FSMView {
	ArrayList<Shape> shapes
	// ArrayList holding all of the shapes
	FSM fsm
	FSMDrawing drawing
	FSMZones zones
	FSMEdit edit
	FSMRemoveElement remover

	/** 
	 * Constructor. Initialize the color to the default color and create the
	 * ArrayList to hold the shapes.
	 * @param defaultColor
	 */
	new(FSM fsm) {
		shapes = new ArrayList<Shape>()
		this.fsm = fsm
		drawing = new FSMDrawing()
		zones = new FSMZones()
		edit = new FSMEdit()
		remover = new FSMRemoveElement(fsm)
	}

	def int getNbState() {
		return fsm.getStates().size()
	}

	def addNewState(int x, int y) {
		var String code = Integer.toBinaryString(fsm.states.size);

		
		val nb0 = Math.max(0,fsm.width-code.length())
		for(n:1..nb0) {
			code="0"+code
		}
		code= '"' + code+'"' ; 
		fsm.states.add(FSMCustomFactory.state("S"+fsm.states.size,code,x,y))
	}

	def addNewTransition(State src,int x, int y) {
		val t= FSMCustomFactory.transition(src,null,x,y)
		if(t.src==null && src!=null) {
			(t.src=src)
		}
		t
	}

	def addInputPort(InputPort ip) {
		fsm.in.add(ip)
	}

	def addNewInputPort(int x, int y) {
		fsm.in.add(FSMCustomFactory.inport("I"+fsm.in.size,1,x,y))
	}

	def addNewOutputPort(int x, int y) {
		fsm.out.add(FSMCustomFactory.outport("O"+fsm.out.size,1,x,y))
	}

	/** 
	 * Add a new shape to the ArrayList
	 * @param shape
	 */
	def void addShape(Shape shape) {
		shapes.add(shape)
	}

	/** 
	 * Draw all of the shapes.
	 * @param g
	 */
	def void draw(Graphics2D g) {
		drawing.drawElement(fsm,g)
	}

	/** 
	 * Get the front most shape at a given point. Creates a temp array with all
	 * of the shapes at a given point, and returns the last shape in the array.
	 * @param p
	 * @return frontmost shape
	 */

	def void detectElement(Point p, FSMElement o, List<FSMElement> l) {
		val isWithinElement = zones.isWithinElement(p, o)
		if (isWithinElement && o !== null && l !== null) {
			l.add(o)
		}

	}

	def List<FSMElement> getActiveElement(Point p) {
		var List<FSMElement> candidates = new ArrayList<FSMElement>()
		detectElement(p, fsm, candidates)
		for (Port ip : fsm.getIn()) {
			detectElement(p, ip, candidates)
		}
		for (Port op : fsm.getOut()) {
			detectElement(p, op, candidates)
		}
		for (State s : fsm.getStates()) {
			detectElement(p, s, candidates)
			detectElement(p, s.getCommandList(), candidates)
			for (Transition t : s.getTransition()) {
				detectElement(p, t, candidates)
			}

		}
		var int nbmatch = candidates.size()
		println(candidates)
		return candidates	
	}

	/** 
	 * Removes a shape from the drawing.
	 * @param shape
	 */
	def void deleteElement(EObject e) {
		remover.remove(e)
	}

	/** 
	 * Moves a shape to the front of the drawing.
	 * @param shape
	 */
	def void editElement(EObject e) {
		edit.edit(e)
	}

}
