package com.cburch.logisim.statemachine.editor.commands;
// AddEllipse.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information on how to add a new ellipse to the drawing

import java.awt.*;
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
import com.cburch.logisim.statemachine.editor.view.FSMView;
import com.cburch.logisim.statemachine.editor.view.FSMZones;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;

public class MoveElementCmd extends EditorCommand {
	


	private FSMElement selection;
	private LayoutInfo fsmLayout;

	public MoveElementCmd(FSM fsm) {
		fsmLayout = fsm.getLayout();
	}
	

	
	
	public void executeDoubleClick(Point p, FSMView view) {
		List<FSMElement>  candidates = view.getActiveElement(p);
		if(candidates.size()>0) {
			view.editElement(candidates.get(0));
		}
	}
	
	/**
	 * On press, get the frontmost shape, and calculate the offsets
	 */
	public void executePress(Point p, FSMView view) {
		List<FSMElement>  candidates = view.getActiveElement(p);
		if(candidates.size()>0) {
			selection = candidates.get(0);
		}
		
	}
	
	/**
	 * On drag, move the shape relative to the offsets
	 */
	public void executeDrag(Point p, FSMView dwg) {
		if (selection != null) {
			LayoutInfo layout = selection.getLayout();
			layout.setX(p.x);
			layout.setY(p.y);
		}
	}

	/**
	 * On drag, move the shape relative to the offsets
	 */
	public void executeRelease(Point p, FSMView dwg) {
		selection = null;
	}

}