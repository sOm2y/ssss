/*
 *	===============================================================================
 *	MySnowFlake.java : The MySnowFlake class
 *  A Snowflake is a nice example how to use recursion to create interesting graphics.
 *	=========================================t======================================
 */

import java.awt.*;

public class MySnowFlake {
	protected int level; // the recursion level
	protected Turtle turtle; // the turtle object
	protected double turn = Math.PI / 3; // the turning angle
	public int length; // the length of the snowflake
	public Point p; // the initial position

	/**
	 * Constructor to create a Snowflake and initialize all values
	 */
	public MySnowFlake(int x, int y, int level, int length) {
		this.level = level;
		this.length = length;
		p = new Point(x, y);
		turtle = new Turtle();
	}
	//stage 2//
	public void levelUp(int currentLevel){
		level+=1;
		
	}
	public void levelDown(int currentLevel){
		level-=1;
		
	}
	//stage 3//
	public void translate(int dx, int dy) {
		p.translate(dx, dy);
		
	}
	
	

	/**
	 * Recursive draw method
	 * 
	 * @param lev
	 *            - the level of the koch shape
	 * @param size
	 *            - the size of the koch shape
	 */
	public void draw(int lev, double size) {
		// 1) define the base case

		// 2) define the recursive case

	}

	/**
	 * Paint a snowflake
	 * 
	 * @param g
	 *            the graphics control
	 */

	public void paint(Graphics g) {
		double size = length;

		// replace this line with recursive calls
		g.drawRect(p.x, p.y, level * 5, level * 5);

		// 1) set up the turtle object first

		// 2) call the recursive draw method

	}
}
