package com.cburch.logisim.statemachine.editor.shapes;
// Segment.java

// Class for a line segment.

// Helper methods written by THC for CS 5 Lab Assignment 3.
// Written by Matthew McNierney for CS5 Lab Assignment #3

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;

import com.cburch.logisim.statemachine.fSMDSL.Transition;

public class TransitionShape extends Shape {

	Transition transition;
	int x;
	int y;
	int width;
	int height;
	private String condition;
	private FSMStateShape src, dst;

	/**
	 * Constructor. Calls the superclass's constructor to set the color. Sets
	 * x1, y1, x2, and y2 according to the parameters.
	 * 
	 * @param leftX
	 * @param leftY
	 * @param rightX
	 * @param rightY
	 * @param clr
	 */
	public TransitionShape(FSMStateShape src, FSMStateShape dst, int x, int y) {
		super();
		this.src = src;
		this.dst = dst;
		if (src != null)
			src.addIncomingTransition(this);
		if (dst != null)
			dst.addOutgoingTransition(this);
		this.x = x;
		this.y = y;
		condition = "1";
		
	}

	public FSMStateShape getSrc() {
		return src;
	}

	public void setSrc(FSMStateShape src) {
		this.src = src;
	}

	public FSMStateShape getDst() {
		return dst;
	}

	public void setDst(FSMStateShape dst) {
		this.dst = dst;
	}


	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	private static final int TOLERANCE = 3;


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Draw the line segment
	 */
	public void drawShape2(Graphics page) {
		if (page instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D) page;
			int x1; // Start point x-coord of segment
			int y1; // Start point y-coord of segment
			int x2; // End point x-coord of segment
			int y2; // End point y-coord of segment

			x1 = src.getCenter().x;// +(FSMState.RADIUS/2);
			y1 = src.getCenter().y;// +(FSMState.RADIUS/2);
			if (dst != null) {
				x2 = dst.getCenter().x;// -(FSMState.RADIUS/2);
				y2 = dst.getCenter().y;// -(FSMState.RADIUS/2);
				System.out.println("Pos="+x1+','+y1+'-'+x2+','+y2);  
				System.out.println("src="+src+",dst="+dst);  
				if (x2 != x1) {
					double slope = Math.atan((y2 - y1) / (x2 - x1));
					if (x2 > x1) {
						x1 += Math.cos(slope) * FSMStateShape.RADIUS;
						y1 += Math.sin(slope) * FSMStateShape.RADIUS;
						x2 -= Math.cos(slope) * FSMStateShape.RADIUS;
						y2 -= Math.sin(slope) * FSMStateShape.RADIUS;
					} else {
						x1 -= Math.cos(slope) * FSMStateShape.RADIUS;
						y1 -= Math.sin(slope) * FSMStateShape.RADIUS;
						x2 += Math.cos(slope) * FSMStateShape.RADIUS;
						y2 += Math.sin(slope) * FSMStateShape.RADIUS;
					}
				} else {
					if (y2 > y1) {
						y2 -= FSMStateShape.RADIUS;
						y1 += FSMStateShape.RADIUS;
					} else {
						y2 += FSMStateShape.RADIUS;
						y1 -= FSMStateShape.RADIUS;
					}
				}
				drawArrowLine(g2, x, y, x2, y2, 8, 16);
			}
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.drawString(condition, x + 2, y + CommandShape.CHAR_HEIGHT + 2);
			width = g2.getFontMetrics().stringWidth(condition) + 4;
			height = CommandShape.CHAR_HEIGHT + 4;
			g2.drawRect(x, y, width, height);
			g2.drawLine(x1, y1, x, y);
		}
	}

	/**
	 * Draw the line segment
	 */
	public void drawShape(Graphics page) {
		if (page instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D) page;
			int x1 = src.getCenter().x;// +(FSMState.RADIUS/2);
			int y1 = src.getCenter().y;// +(FSMState.RADIUS/2);
			g2.drawLine(x1, y1, x, y);
			if (dst!=null) {
				int x2 = dst.getCenter().x;// -(FSMState.RADIUS/2);
				int y2 = dst.getCenter().y;// -(FSMState.RADIUS/2);
				drawArrowLine(g2, x, y, x2, y2,8,8);
			}
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.drawString(condition, x + 2, y + CommandShape.CHAR_HEIGHT + 2);
			g2.drawRect(x, y, g2.getFontMetrics().stringWidth(condition) + 4, CommandShape.CHAR_HEIGHT + 4);

		}
	}
	/**
	 * Draw an arrow line betwwen two point
	 * 
	 * @param g
	 *            the graphic component
	 * @param x1
	 *            x-position of first point
	 * @param y1
	 *            y-position of first point
	 * @param x2
	 *            x-position of second point
	 * @param y2
	 *            y-position of second point
	 * @param d
	 *            the width of the arrow
	 * @param h
	 *            the height of the arrow
	 */
	private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx * dx + dy * dy);
		double xm = D - d, xn = xm, ym = h, yn = -h, x;
		double sin = dy / D, cos = dx / D;

		x = xm * cos - ym * sin + x1;
		ym = xm * sin + ym * cos + y1;
		xm = x;

		x = xn * cos - yn * sin + x1;
		yn = xn * sin + yn * cos + y1;
		xn = x;

		int[] xpoints = { x2, (int) xm, (int) xn };
		int[] ypoints = { y2, (int) ym, (int) yn };

		g.drawLine(x1, y1,  x2, y2);
		g.fillPolygon(xpoints, ypoints, 3);
	}

	/**
	 * Returns whether a given point is close within the segment's tolerance.
	 */
	public boolean containsPoint(Point p) {
		return (p.x>=x) && (p.x<=x+width) &&
				(p.y>=y) && (p.y<=y+width);
	}

	/**
	 * Moves a line relative to deltaX and deltaY
	 */
	public void move(int deltaX, int deltaY) {
	}

	/**
	 * Returns the center point of the line segment
	 */
	public Point getCenter() {
		int x1; // Start point x-coord of segment
		int y1; // Start point y-coord of segment
		int x2; // End point x-coord of segment
		int y2; // End point y-coord of segment
		x1 = src.getCenter().x;
		y1 = src.getCenter().y;
		x2 = dst.getCenter().x;
		y2 = dst.getCenter().y;
		return new Point((x1 + x2) / 2, (y1 + y2) / 2);
	}

	// Helper method that returns true if Point p is within a tolerance
	// of a given bounding box. Here, the bounding box is given by the
	// coordinates of its left, top, right, and bottom.
	private static boolean almostContainsPoint(Point p, int left, int top, int right, int bottom, double tolerance) {
		return p.x >= left - tolerance && p.y >= top - tolerance && p.x <= right + tolerance
				&& p.y <= bottom + tolerance;
	}

	// Helper method that returns the distance from Point p to the line
	// containing a line segment whose endpoints are given.
	private static double distanceToPoint(Point p, int x1, int y1, int x2, int y2) {
		if (x1 == x2) // vertical segment?
			return (double) (Math.abs(p.x - x1)); // yes, use horizontal
													// distance
		else if (y1 == y2) // horizontal segment?
			return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
		else {
			// Here, we know that the segment is neither vertical nor
			// horizontal. Compute m, the slope of the line containing the
			// segment.
			double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

			// Compute mperp, the slope of the line perpendicular to the
			// segment.
			double mperp = -1.0 / m;

			// Compute the (x, y) intersection of the line containing the
			// segment and the line that is perpendicular to the segment and
			// that contains Point p.
			double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x)) / (mperp - m);
			double y = m * (x - x1) + y1;

			// Return the distance between Point p and (x, y).
			return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
		}
	}

}
