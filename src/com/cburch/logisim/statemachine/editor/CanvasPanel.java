package com.cburch.logisim.statemachine.editor;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

// CanvasPanel is the class upon which we actually draw. It listens
// for mouse events and calls the appropriate method of the current
// command.
public class CanvasPanel extends Panel implements MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private final IEditorDialog editor;
	private static final long serialVersionUID = 0;

	// Constructor just needs to set up the CanvasPanel as a listener.
	public CanvasPanel(IEditorDialog editorDialog) {
		super();
		this.editor = editorDialog;
		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics page) {
		super.paint(page); // execute the paint method of JPanel
		this.editor.getView().draw((Graphics2D)page); // draw all of the shapes
	}

	// When the mouse is clicked, call the executeClick method of the
	// current command.
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			this.editor.getCommand().executeDoubleClick(event.getPoint(), this.editor.getView());
			repaint();
		} else {
			this.editor.getCommand().executeClick(event.getPoint(), this.editor.getView());
		}
		repaint();
	}

	// When the mouse is pressed, call the executePress method of the
	// current command.
	public void mousePressed(MouseEvent event) {
		this.editor.getCommand().executePress(event.getPoint(), this.editor.getView());
		repaint();
	}

	// When the mouse is dragged, call the executeDrag method of the
	// current command.
	public void mouseDragged(MouseEvent event) {
		this.editor.getCommand().executeDrag(event.getPoint(), this.editor.getView());
		repaint();
	}

	// We don't care about the other mouse events.
	public void mouseReleased(MouseEvent event) {
		this.editor.getCommand().executeRelease(event.getPoint(), this.editor.getView());
		repaint();
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mouseMoved(MouseEvent event) {
		this.editor.getCommand().executeMove(event.getPoint(), this.editor.getView());
	}
}