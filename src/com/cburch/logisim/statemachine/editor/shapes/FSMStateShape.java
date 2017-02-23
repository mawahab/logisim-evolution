package com.cburch.logisim.statemachine.editor.shapes;
// Ellipse.java

// Class for an ellipse.

// Helper methods written by THC for CS 5 Lab Assignment 3.
// Modified by Matthew McNierney for CS5 Lab Assignment #3

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class FSMStateShape extends Shape {
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLabel() {
		return label;
	}


	public ArrayList<TransitionShape> getOutgoingTransitions() {
		return outgoing;
	}


	public ArrayList<TransitionShape> getIncomingTransitions() {
		return incoming;
	}


	public static final int RADIUS = 30;
	private int x; // Leftmost x-coord of ellipse's bounding box
	private int y; // Leftmost y-coord of ellipse's bounding box
	private String label; // Height of bounding box

	private CommandShape command = null;
	private ArrayList<TransitionShape> outgoing = new ArrayList<TransitionShape>();
	private ArrayList<TransitionShape> incoming = new ArrayList<TransitionShape>();
	private String code = "0000";
	
	
	public void addOutgoingTransition(TransitionShape t) {
		this.outgoing.add(t);
		t.setDst(this);
	}

	public void addIncomingTransition(TransitionShape t) {
		this.incoming.add(t);
		t.setSrc(this);
	}

	public void removeTransition(TransitionShape t) {
		outgoing.remove(t);
	}
	
	/**
	 * Constructor. Calls the superclass shape's constructor to set the color.
	 * Initializes x, y, width, and height based on the parameters.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param boxWidth
	 * @param boxHeight
	 */
	public FSMStateShape(int xPos, int yPos, int boxWidth, String label, int code) {
		super();
		x = xPos;
		y = yPos;
		this.label = label;
		this.code = Integer.toBinaryString(code);
	}

	public CommandShape getCommand() {
		return command;
	}

	public void setCommand(CommandShape command) {
		this.command = command;
	}

	/**
	 * Draws the ellipse.
	 */
	public void drawShape(Graphics page) {
		if (page instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D) page;
			g2.setColor(Color.white);
			g2.fillOval(x, y, 2*RADIUS, 2*RADIUS);
			g2.setColor(Color.black);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int width = g2.getFontMetrics().stringWidth(label);
			g2.drawString(label, x+RADIUS-width/2, y+RADIUS-3);
			width = g2.getFontMetrics().stringWidth(code );
			g2.drawString(code, x+RADIUS-width/2, y+RADIUS+13);
			g2.drawOval(x, y, 2*RADIUS, 2*RADIUS);
		}
	}

	/**
	 * Tests whether a given point is within the ellipse.
	 */
	public boolean containsPoint(Point p) {
		double dx = Math.pow(x+RADIUS-p.x, 2.0);
		double dy = Math.pow(y+RADIUS-p.y, 2.0);
		double rad = Math.sqrt(dx+dy);
		//System.out.println("rad="+rad);
		if (rad<RADIUS) {
			//System.out.println(p+" in "+this);
			return true;
		} else {
			//System.out.println(p+" not in "+this);
			return false;
		}
	}

	@Override
	public String toString() {
		return "FSMState [label=" + label + ", code=" + code + ", x=" + x + ", y=" + y + ", command=" + command
				+ ", transitions=" + outgoing + "]";
	}

	/**
	 * Move the ellipse relative to deltaX and deltaY.
	 */
	public void move(int deltaX, int deltaY) {
		x += deltaX;
		y += deltaY;
		if (distance(command)>3*RADIUS) {
			command.move(deltaX,deltaY);
		}
	}

	/**
	 * Returns the center Point in the circle.
	 */
	public Point getCenter() {
		return new Point(x + RADIUS , y + RADIUS );
	}


	public void setLabel(String input) {
		label=input;
	}
}
