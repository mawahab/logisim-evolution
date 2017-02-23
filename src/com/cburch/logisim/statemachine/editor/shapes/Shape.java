package com.cburch.logisim.statemachine.editor.shapes;
// Shape.java

// Abstract class for geometric shapes.
// Provides three non-abstract methods: setColor, draw, and setCenter.

// Written by THC for CS 5 Lab Assignment 3.

import java.awt.*;

public abstract class Shape {
	private Color color; // Shape's color

	public abstract void drawShape(Graphics page); // draw the Shape

	public abstract boolean containsPoint(Point p); // does the Shape contain
													// Point p?

	public abstract void move(int deltaX, int deltaY); // move the Shape

	public abstract Point getCenter(); // return the Shape's center

	// Create a Shape, setting its color.
	public Shape() {
	}


	// Draw the Shape.
	public void draw(Graphics page) {
		drawShape(page);
	}

	// Move the Shape to be a given center.
	public void setCenter(Point newCenter) {
		Point oldCenter = getCenter();
		move(newCenter.x - oldCenter.x, newCenter.y - oldCenter.y);
	}
	
	// Move the Shape to be a given center.
	public int distance(Shape shape) {
		Point center = getCenter();
		int cx = center.x;
		Point scenter = shape.getCenter();
		int scx = scenter.x;
		double dx= (cx-scx);
		double dy= (center.y-scenter.y);
		double distance = Math.sqrt(dx*dx+dy*dy);
		return (int) distance;
	}
	
	public void delete() {
		
	}
	
}
