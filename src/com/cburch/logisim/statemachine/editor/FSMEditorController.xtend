package com.cburch.logisim.statemachine.editor

// Drawing.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds various methods for manipulating and storing the shapes in the drawing.

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
import com.cburch.logisim.statemachine.editor.FSMView
import java.awt.event.MouseEvent
import com.cburch.logisim.statemachine.editor.view.*
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo
import com.cburch.logisim.statemachine.fSMDSL.CommandList
import com.cburch.logisim.statemachine.editor.view.FSMZones.AreaType
import org.eclipse.emf.ecore.util.EcoreUtil
import com.cburch.logisim.statemachine.fSMDSL.OutputPort

class FSMEditorController {
	
	// ArrayList holding all of the shapes
	private FSM fsm
	private FSMDrawing drawing
	private FSMZones zones
	private FSMEdit edit
	private FSMView view;
	private FSMRemoveElement remover
	
	
	FSMElement currentSelection
	
	Transition newTransition
	
	FSMPopupMenu popupMenu
	
	FSMElement clipboard

	/** 
	 * Constructor. Initialize the color to the default color and create the
	 * ArrayList to hold the shapes.
	 * @param defaultColor
	 */
	new(FSMView view, FSM fsm ) {
		this.fsm = fsm
		this.view = view
		this.popupMenu = new FSMPopupMenu(view);
		drawing = new FSMDrawing()
		zones = new FSMZones(this)
		edit = new FSMEdit()
		remover = new FSMRemoveElement(fsm)
	}

	def int getNbState() {
		return fsm.getStates().size()
	}

	def FSMElement getCurrentSelection() {
		return currentSelection
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

	def pasteInputPort(int x, int y) {
		val ip = (currentSelection as InputPort)
		fsm.in.add(currentSelection as InputPort);
		ip.layout.x=x
		ip.layout.y=y
	}
	def pasteOutputPort(int x, int y) {
		val ip = (currentSelection as OutputPort)
		fsm.in.add(currentSelection as OutputPort);
		ip.layout.x=x
		ip.layout.y=y
	}
	def pasteState(int x, int y) {
		val ip = (currentSelection as State)
		fsm.states.add(currentSelection as State);
		ip.layout.x=x
		ip.layout.y=y
	} 
	
	def addNewInputPort(int x, int y) {
		fsm.in.add(FSMCustomFactory.inport("I"+fsm.in.size,1,x,y))
	}

	def addNewOutputPort(int x, int y) {
		fsm.out.add(FSMCustomFactory.outport("O"+fsm.out.size,1,x,y))
	}
	/** 
	 * Draw all of the shapes.
	 * @param g
	 */
	def void draw(Graphics2D g) {
		drawing.drawElement(fsm,g,currentSelection)
	}

	/** 
	 * Get the front most shape at a given point. Creates a temp array with all
	 * of the shapes at a given point, and returns the last shape in the array.
	 * @param p
	 * @return frontmost shape
	 */


	private def setLayout(int x, int y, FSMElement e) {
		var LayoutInfo layout = e.getLayout()
		layout.setX(x)
		layout.setY(y)
		
	} 
	public def dispatch move(Point p, FSMElement e) {
		setLayout(p.x,p.y,e)
	}

	def double distance(int xa,int ya,int xb,int yb) {
		val dx= xa-xb
		val dy = ya - yb
		Math.sqrt(dx*dx+dy*dy) 
	}
	

	public def dispatch move(Point p, CommandList cl) {
		val state = cl.eContainer as State
		val layout = state.layout
		if(distance(p.x,p.y,layout.x, layout.y)<=400) {
			setLayout(p.x,p.y,cl);
		} else {
			setLayout(layout.x+45,layout.y+15, cl);		
		}
		view.repaint
	}

	public def dispatch move(Point p, State s) {
		setLayout(p.x,p.y,s);
		setLayout(s.layout.x+45,s.layout.y+15, s.commandList);		
		view.repaint
	}

	
	def executeEdit(Point p) {
		val List<FSMElement> selection = zones.getActiveElement(p);
		if (selection.size()>0) {
			val first = selection.get(0)
			edit.edit(first);
			view.repaint
		}
	}

	def executeDelete(Point p) {
		val List<FSMElement> selection = zones.getActiveElement(p);
		if (selection.size()>0) {
			val first = selection.get(0)
			remover.remove(first);
			view.repaint
		}
	}

	def executeCopy(Point p, AreaType type) {
	
		switch(type) {
			case AreaType.INPUT :{
				clipboard=EcoreUtil.copy(currentSelection);
			}
			case AreaType.OUTPUT :{
				clipboard=EcoreUtil.copy(currentSelection);
			}
			case AreaType.STATE:{
				clipboard=EcoreUtil.copy(currentSelection);
			}
			default: {
				return
			}
		}
		view.repaint
	
	}  
	def executePaste(Point p, AreaType type) {
	
		switch(type) {
			case AreaType.INPUT :{
				pasteInputPort(p.x,p.y)
			}
			case AreaType.OUTPUT :{
				pasteOutputPort(p.x,p.y)
			}
			case AreaType.STATE:{
				pasteState(p.x,p.y)
			}
			default: {
				return
			}
		}
		view.repaint
	
	}  
	
	def executeCreate(Point p, AreaType type) {
		switch(type) {
			case AreaType.INPUT :{
				addNewInputPort(p.x,p.y);
			}
			case AreaType.OUTPUT :{
				addNewOutputPort(p.x,p.y);
			}
			case AreaType.STATE:{
				addNewState(p.x,p.y);
			}
			case AreaType.TRANSITION :{
				val state = currentSelection as State
				newTransition = addNewTransition(state,p.x,p.y); 
				println("Create Transition from "+state.name)
			}
			default: {
				return
			}
		}
		view.repaint
	
	}  
	
	
	def executeDoubleClick(Point p) {
		executeEdit(p)
	}
	
	
	def executeRightClick(Point scaled, Point unscaled) {
		val List<FSMElement> selection = zones.getActiveElement(scaled);
		if (selection.size()>0) {  
			currentSelection=selection.get(0)
			view.repaint
			popupMenu.showPopupMenu(unscaled,zones.getAreaType(scaled,fsm))
		} else { 
			currentSelection=null; 
			view.repaint
			popupMenu.showPopupMenu(unscaled,zones.getAreaType(scaled,fsm))
		}
		
	}
	
	def executePress(Point p) {
		val List<FSMElement> selection = zones.getActiveElement(p);
		currentSelection=null; 		
		if (selection.size()>0) {
			val first = selection.get(0)
			currentSelection = first;
		}
		view.repaint
	}
	
	def executeDragged(Point p) {
		if(currentSelection!=null) {
			move(p,currentSelection)
		}
		view.repaint
	}
	def executeMove(Point p) {
		if (newTransition != null) {
			println("Move transition")
			val layout = newTransition.getLayout();
			layout.setX(p.x);
			layout.setY(p.y);
		}
		view.repaint
	}
	
	def executeLeftClick(Point p) {
		val List<FSMElement> selection = zones.getActiveElement(p);
		currentSelection=null; 	
		if (selection.size()>0) {
			val first = selection.get(0)
			if(first instanceof State) {
				currentSelection=first; 		
				if(newTransition != null) {
					val LayoutInfo layout = newTransition.getLayout();
					val LayoutInfo srcLayout = newTransition.getSrc().getLayout();
					layout.setX((p.x+srcLayout.getX())/2);
					layout.setY((p.y+srcLayout.getY())/2);
					if(first!=newTransition.getSrc()) {
						newTransition.setDst(first);
					} else {
						deleteElement(newTransition);
					}
				}
			} else if(newTransition!=null) {
				deleteElement(newTransition);
			}
			newTransition=null;
		}
			view.repaint
	}
	
	def executeRelease(Point p) {

		//currentSelection =null;
		if(newTransition!=null) {
			
		}
		view.repaint
	}

	
	/** 
	 * Removes a shape from the drawing.
	 * @param shape
	 */
	def dispatch void deleteElement(FSM e) {
		// do not remove the FSM itself !
	}

	/** 
	 * Removes a shape from the drawing.
	 * @param shape
	 */
	def dispatch void deleteElement(FSMElement e) {
		remover.remove(e)
		view.repaint
		
	}

	/** 
	 * Moves a shape to the front of the drawing.
	 * @param shape
	 */
	def void editElement(FSMElement e) {
		edit.edit(e)
	}


	def getFSM() {
		fsm
	}
}
