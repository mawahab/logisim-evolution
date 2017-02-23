package com.cburch.logisim.statemachine.editor.shapes;
// Rect.java

// Class for a rectangle.

// Written by Matthew McNierney for CS 5 Lab Assignment 3.
// Based on Rect.java by THC

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CommandShape extends Shape {
	public static final int CHAR_HEIGHT = 15;
	public int x; // Leftmost x-coord of rectangle
	public int y; // Leftmost y-coord of rectangle
	public int width; // Width of rectangle
	public int height; // Height of rectangle
	private String commands ="nop";
	private FSMStateShape state;

	/**
	 * Constructor. Calls the superclass's constructor to set the color. Sets x,
	 * y, width, and height based on the parameters.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param rectWidth
	 * @param rectHeight
	 */
	public CommandShape(int xPos, int yPos, int rectWidth, FSMStateShape state) {
		super();
		x = xPos;
		y = yPos-height;
		width = rectWidth;
		setCommands("nop");
		setState(state); 
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
		String[] parts = commands.split(",");
		int count = parts.length;
		height = count*CHAR_HEIGHT+5;
	}
	/**
	 * Draws the rectangle.
	 */
	public void drawShape(Graphics page) {
		if (page instanceof Graphics2D) {
			Graphics2D g = (Graphics2D) page;
			String[] parts = commands.split(",");
			width= 25;
			for(String part : parts) {
				width = Math.max(width, g.getFontMetrics().stringWidth(part));
			}
			width+=6;
			g.setColor(Color.white);
			g.fillRoundRect(x, y-height, width, height, 5, 5);
			g.setColor(Color.black);
			RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(x, y-height, width, height, 5, 5);
			g.draw(roundedRectangle);
			int line=1;
			for(String part : parts) {
				g.drawString(part, x+4, y-height+line*CHAR_HEIGHT+1);
				line++;
			}
		}
	}


	/**
	 * Returns the center point of the rectangle.
	 */
	public Point getCenter() {
		return new Point(x + width / 2, y - height / 2);
	}

	/**
	 * Moves the rectangle relative to deltaX and deltaY
	 */
	public void move(int deltaX, int deltaY) {
		x += deltaX;
		y += deltaY;
		if (distance(state)>4*FSMStateShape.RADIUS) {
			x -= deltaX;
			y -= deltaY;
		}
	}

	/**
	 * Returns whether a given point is within the rectangle
	 */
	public boolean containsPoint(Point p) {
		return p.x >= x && p.x <= x + width && p.y >= (y-height) && p.y <= y ;
	}

	public void setState(FSMStateShape fsmState) {
		state=fsmState;
		fsmState.setCommand(this);
	}

	public FSMStateShape getState() {
		return state;
	}
}
