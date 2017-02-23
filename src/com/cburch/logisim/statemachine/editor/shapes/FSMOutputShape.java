package com.cburch.logisim.statemachine.editor.shapes;
// Ellipse.java

// Class for an ellipse.

// Helper methods written by THC for CS 5 Lab Assignment 3.
// Modified by Matthew McNierney for CS5 Lab Assignment #3

import java.awt.*;

public class FSMOutputShape extends Shape {
	private static final int WIDTH = 40;
	private static final int HEIGHT = 15;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static final int OFFSETX = 80;
	private int y; // Leftmost y-coord of ellipse's bounding box

	private String name;

	/**
	 * Constructor. Calls the superclass shape's constructor to set the color.
	 * Initializes x, y, width, and height based on the parameters.
	 * @param xPos
	 * @param yPos
	 * @param boxWidth
	 * @param boxHeight
	 * @param clr
	 */
	public FSMOutputShape(int yPos,String name) {
		super();
		y = yPos;
		this.name=name;
	}

	/**
	 * Draws the ellipse.
	 */
	public void drawShape(Graphics page) {
		page.setColor(Color.red);
		page.drawRect(OFFSETX, y, WIDTH,HEIGHT);
		page.drawString(name, OFFSETX+5, y+HEIGHT/2);
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
