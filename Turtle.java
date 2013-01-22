/*
 *	===============================================================================
 *	Tutrle.java : The tutrle
 *  A turtle defines various properties, including current position, direction and penstate
 *	===============================================================================
 */

import java.awt.Graphics;
public class Turtle {
	private double	 px, py; 		//current x and y position
	private double direction;    	// current direction of turtle (in radian)
 	private Graphics g;				// the graphics control
	private boolean penDown = false; // the pen state

	/** Constructor to create a turtle.
	*/
	public Turtle( ) { this( 0, 0, 0 ); }

	/** Constructor to create a turtle.
	* @param x  the x coordinate position
	* @param y  the y coordinate position
	* @param d  the direction of a turtle
	*/
	public Turtle(int x, int y, double d) {
		px = x;
		py = y;
		direction = d;
	}

	/** Constructor to create a turtle.
	* @param g  the graphics control
	*/
	public Turtle( final Graphics g ) {
		this( 0, 0, 0 );
		this.g = g;
	}

	/** Set the graphics control of a turtle.
	* @param g 	the graphics control
	*/
	public void setGraphics( final Graphics g ) {
		this.g = g;
	}

	/** Set the initial position, graphics control, pen state of a turtle
	* @param x  the x coordinate position
	* @param y  the y coordinate position
	* @param g 	the graphics control
	* @param d  the direction of a turtle
	* @param p pen state: true for pen Down, false => pen Up
	*/
	public void set(final double x, final double y, final Graphics g, double d, boolean p ) {
		px = x;
		py = y;
		direction = d;
		this.g = g;
		penDown = p;
	}

	/** Rotate a turtle
	* @param d  the angle in radian, -ve => anticlockwise, +ve => clockwise direction
	*/
	public void rotate(double d) {
		direction += d;
	}

	/** Set the pen state
	* @param p pen state: true for pen Down, false => pen Up
	*/
	public void setPenDown(boolean p) {
		penDown = p;
	}

	/** get the pen state
	* @return p pen state: true for pen Down, false => pen Up
	*/
	public boolean isPenDown() {
		return penDown;
	}

	/**
	 * Return a string representation of the turtle, containing
	 * the String representation of each element.
	 */
	public String toString() {
		return "Turtle (" + px + "," + py + "," + direction + ")";
	}


	/**  changes the position by moving the turtle that distance in the direction of the heading
	* When the pen is down, the turtle draws while it moves.
	* When the pen is up, the turtle just moves.
	* @param d the distance to move
	*/
	public void forward(double d) {
		double dx = d * Math.cos( direction );
		double dy = d * Math.sin( direction );
		if (isPenDown())
			g.drawLine((int)px, (int)py, (int)(px + dx), (int)(py + dy));
		px += dx;
		py += dy;
	}
}