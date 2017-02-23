package com.cburch.logisim.statemachine.editor.shapes;
// Ellipse.java
// Class for an ellipse.

// Helper methods written by THC for CS 5 Lab Assignment 3.
// Modified by Matthew McNierney for CS5 Lab Assignment #3

import java.awt.*;

import com.cburch.logisim.statemachine.fSMDSL.InputPort;

public class FSMInputShape extends Shape {
	
	private static final int WIDTH = 40;
	private static final int HEIGHT = 15;
	
	private InputPort input;
	
	public String getName() {
		return input.getName();
	}

	public void setName(String name) {
		input.setName(name);
	}

	private static final int OFFSETX = 80;
	private int y; // Leftmost y-coord of ellipse's bounding box


	/**
	 * Constructor. Calls the superclass shape's constructor to set the color.
	 * Initializes x, y, width, and height based on the parameters.
	 * @param xPos
	 * @param yPos
	 * @param boxWidth
	 * @param boxHeight
	 * @param clr
	 */
	public FSMInputShape(int yPos,String name) {
		super();
		y = yPos;
		this.setName(name);
	}

	/**
	 * Draws the ellipse.
	 */
	public void drawShape(Graphics page) {
		page.setColor(Color.blue);
		page.drawRect(OFFSETX, y, WIDTH,HEIGHT);
		page.drawString(getName(), OFFSETX+5, y+HEIGHT/2);
	}
	 
	/**
	 * Tests whether a given point is within the ellipse.
	 */
	public boolean containsPoint(Point p) {
		return p.x>=OFFSETX && p.x <=(OFFSETX+WIDTH) && p.y>=y && p.y <=(y+HEIGHT);
	}
	 
	/**
	 * Move the ellipse relative to deltaX and deltaY.
	 */
	public void move(int deltaX, int deltaY) {
		y += deltaY;
	}
	 
	/**
	 * Returns the center Point in the circle.
	 */
	public Point getCenter() {
		return new Point(OFFSETX/2,y+HEIGHT/2);
	}

}

