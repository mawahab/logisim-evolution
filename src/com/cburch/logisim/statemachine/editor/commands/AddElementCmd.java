package com.cburch.logisim.statemachine.editor.commands;
// AddEllipse.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information on how to add a new ellipse to the drawing


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.eclipse.emf.ecore.EObject;

import com.cburch.logisim.statemachine.editor.EditorDialog.Mode;
import com.cburch.logisim.statemachine.editor.shapes.CommandShape;
import com.cburch.logisim.statemachine.editor.shapes.FSMInputShape;
import com.cburch.logisim.statemachine.editor.shapes.FSMStateShape;
import com.cburch.logisim.statemachine.editor.shapes.Shape;
import com.cburch.logisim.statemachine.editor.shapes.TransitionShape;
import com.cburch.logisim.statemachine.editor.view.FSMRemoveElement;
import com.cburch.logisim.statemachine.editor.view.FSMView;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;

public class AddElementCmd extends EditorCommand {
	
	Mode mode;

	private Transition newTransition;


	public AddElementCmd(Mode mode) {
		this.mode=mode;
	}
	

	
	/**
	 * On press, get the click point and reset numDrags
	 */
	public void executeClick(Point p, FSMView view) {
		List<FSMElement> selection = view.getActiveElement(p);
		if (selection.size()>0 && mode==Mode.DeleteMode) {
			view.deleteElement(selection.get(0));
		} else if (selection.size()==0) {
			switch(mode) {
				case StateMode: {
					view.addNewState(p.x,p.y);
					break;
				}
				case InputPortMode: {
					view.addNewInputPort(p.x,p.y);
					break;
				}
				case OutputPortMode: {
					view.addNewOutputPort(p.x,p.y);
					break;
				}
				default: {
					System.out.println("Selection="+selection);
				}
			}
		}

	}
	
	public void executeDoubleClick(Point p, FSMView view) {
		List<FSMElement> selection = view.getActiveElement(p);
		if (selection.size()>0 && mode!=Mode.DeleteMode) {
			view.editElement(selection.get(0));
		}
	}
	
	/**
	 * On press, get the frontmost shape, and calculate the offsets
	 */
	public void executePress(Point p, FSMView view) {
		List<FSMElement> selection = view.getActiveElement(p);
		if (selection.size()>0 && selection.get(0) instanceof State) {
			newTransition = view.addNewTransition((State)selection.get(0),p.x,p.y); 
		} else {
			newTransition =null;
		}
	}
	
	/**
	 * On drag, move the shape relative to the offsets
	 */
	public void executeDrag(Point p, FSMView dwg) {
		if (newTransition != null) {
			LayoutInfo layout = newTransition.getLayout();
			layout.setX(p.x);
			layout.setY(p.y);
		}
	}

	@Override
	public void executeRelease(Point p, FSMView view) {
		List<FSMElement>  selection = view.getActiveElement(p);
		if (selection.size()>0 &&  selection.get(0) instanceof State && newTransition != null) {
			LayoutInfo layout = newTransition.getLayout();
			LayoutInfo srcLayout = newTransition.getSrc().getLayout();
			
			layout.setX((p.x+srcLayout.getX())/2);
			layout.setY((p.y+srcLayout.getY())/2);
			State dst = (State) selection.get(0);
			if(dst!=newTransition.getSrc()) {
				newTransition.setDst(dst);
			} else {
				view.deleteElement(newTransition);
			}
		} else if(newTransition!=null) {
			view.deleteElement(newTransition);
		}
		newTransition=null;
	}

}