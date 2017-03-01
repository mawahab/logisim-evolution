package com.cburch.logisim.statemachine.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.time.ZonedDateTime;
import java.util.List;

import javax.swing.JPanel;


import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.std.fsm.IFSMEditor;

// CanvasPanel is the class upon which we actually draw. It listens
// for mouse events and calls the appropriate method of the current
// command.
public class FSMView extends Panel implements MouseListener, MouseMotionListener {
	
	

	/**
	 * 
	 */
	private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 500;
	private static final long serialVersionUID = 0;
	

	private FSMEditorController controller; // the drawing: shapes in order
	private Point currentPos = new Point(0,0);
	private final IFSMEditor editor;
	
	// Constructor just needs to set up the CanvasPanel as a listener.
	public FSMView(IFSMEditor parent) {
		super();
		
		editor = parent;
		controller = new FSMEditorController(this,editor.getContent().getFsm()); // make an empty drawing
		
		addMouseListener(this);
		addMouseMotionListener(this);

		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setBackground(Color.white);

	}

	public void paint(Graphics page) {
		super.paint(page); // execute the paint method of JPanel
		getController().draw((Graphics2D)page); // draw all of the shapes
	}

	
	private void updatePosition(MouseEvent e) {
		currentPos = new Point( e.getX(), e.getY());
	}
	
	// When the mouse is clicked, call the executeClick method of the
	// current command.
	
	public void mouseClicked(MouseEvent event) {
		updatePosition(event);
		FSMEditorController ctrl = this.getController();
		if(event.getButton()==MouseEvent.BUTTON1) {
			if (event.getClickCount() == 2) {
				ctrl.executeDoubleClick(currentPos);
			}  else {
				ctrl.executeLeftClick(currentPos);
			}
		} else {
			ctrl.executeRightClick(currentPos);
		}
		
	}

	public void mousePressed(MouseEvent event) {
		updatePosition(event);
		getController().executePress(currentPos);
		
	}

	public void mouseDragged(MouseEvent event) {
		updatePosition(event);
		getController().executeDragged(currentPos);
		
	}

	// We don't care about the other mouse events.
	public void mouseReleased(MouseEvent event) {
		updatePosition(event);
		repaint();
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mouseMoved(MouseEvent event) {
		updatePosition(event);
		getController().executeMove(currentPos);
	}
	
	public FSMEditorController getController() {
		return controller;
	}

	public void getAreaType(Point p) {
		
		
	}

}