package com.cburch.logisim.statemachine.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import java.awt.event.MouseWheelEvent;
import java.time.ZonedDateTime;
import java.util.List;

import javax.swing.JPanel;

import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.std.fsm.IFSMEditor;

// CanvasPanel is the class upon which we actually draw. It listens
// for mouse events and calls the appropriate method of the current
// command.
public class FSMView extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0;

	private FSMEditorController controller; // the drawing: shapes in order
	private Point currentPos = new Point(0, 0);
	private final IFSMEditor editor;
	private double scale=1.0;

	private Point unscaledPos;

	// Constructor just needs to set up the CanvasPanel as a listener.
	public FSMView(IFSMEditor parent) {
		super();
		editor = parent;
		controller = new FSMEditorController(this, editor.getContent().getFsm()); // make
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(1000,1000));
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                double delta = 0.05f * e.getPreciseWheelRotation();
                scale += delta;
                System.out.println("Scale="+scale);
                revalidate();
                repaint();
            }
        });

		setBackground(Color.white);
	}

	public void paint(Graphics page) {
		super.paint(page); // execute the paint method of JPanel
		int w = (int) getWidth();
		int h = (int) getHeight();
		Graphics2D g = (Graphics2D) page;
		g.scale(scale, scale);
		getController().draw((Graphics2D) page); // draw all of the shapes
		//showMouseCursor(page, g);
	}

	private void showMouseCursor(Graphics page, Graphics2D g) {
		int x = (int)(currentPos.x);
		int y = (int)(currentPos.y);
		String label = "["+x+","+y+"]";
		int sw= page.getFontMetrics().stringWidth(label);
		g.setColor(Color.blue);
		g.drawString(label,x-sw/2, y);
		page.drawOval(x-10, y-10, 20, 20);
		g.setColor(Color.black);
	}

	

	private void updatePosition(MouseEvent e) {
		currentPos = new Point((int)(e.getX()/scale), (int)(e.getY()/scale));
		unscaledPos = new Point(e.getX(),e.getY());
	}

	// When the mouse is clicked, call the executeClick method of the
	// current command.

	public void mouseClicked(MouseEvent e) {
		updatePosition(e);
		FSMEditorController ctrl = this.getController();
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getClickCount() == 2) {
				ctrl.executeDoubleClick(currentPos);
			} else {
				ctrl.executeLeftClick(currentPos);
			}
		} else {
			// FIXME : hack to "unscale" position to properly show context menu
			ctrl.executeRightClick(currentPos, unscaledPos);
		}

	}

	public void mousePressed(MouseEvent event) {
		updatePosition(event);
		getController().executePress(currentPos);
		repaint();

	}

	public void mouseDragged(MouseEvent event) {
		updatePosition(event);
		getController().executeDragged(currentPos);
		repaint();

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

	public void setScale(double d) {
		scale=d;
		
	}

}