/*
 *	======================================================================
 *	A1Panel.java : Geometric patterns are shown on the screen
 *	This program is made by sOm2y.
 *	UPI: yyin888
 *	======================================================================
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class A1Panel extends JComponent {
	private ArrayList<MySnowFlake> myShapes;// the array of snowflakes, Stage 1:
	//private MySnowFlake snow; // replace **
	// this with an ArrayList
	final int MAX = 50; // the maximum size of the array
	private int currentIndex = 0; // the current number of snowflakes stored

	int currentLevel = 1, currentLength = 100; // the initial properties of
												// snowflakes
	JPopupMenu popup; // the popup menu

	/**
	 * Constructor to create the drawing panel.
	 */
	public A1Panel() {
		//snow = new MySnowFlake(getX(), getY(), currentLevel, currentLength);
		myShapes = new ArrayList<MySnowFlake>(); // Stage 1: Replace this line
													// **

		popup = new JPopupMenu(); // create the popup menu
		makePopupMenu();
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				maybeShowPopup(e);
			}

			public void mouseReleased(MouseEvent e) {
				maybeShowPopup(e);
			}

			private void maybeShowPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			public void mouseClicked(MouseEvent e) { // Stage 1: Modify the **
														// following statements
				myShapes.add(new MySnowFlake(e.getX(), e.getY(), currentLevel,
						currentLength));
				currentIndex += 1;
				repaint();
			}
		});
	}

	public void translateAll() {
		try{
			for (int i = 0; i < myShapes.size(); i++) {
				MySnowFlake f = myShapes.get(i);
				f.translate(getX(), getY()); 						//*
				myShapes.set(i, f);
			}
		}catch(Exception e){
			System.out.print(e.toString());
		}

	}

	/**
	 * Complete this
	 */
	public void levelUp() {
		try {
			for (int i = 0; i < myShapes.size(); i++) {
				MySnowFlake f = myShapes.get(i);
				f.levelUp(currentLevel);
				//f = new MySnowFlake(getX(), getY(), snow.levelUp(currentLevel),
					//	currentLength);
				myShapes.set(i, f);

			}
		} catch (Exception e) {
			System.out.print(e.toString());

		}
		// Stage 2: complete this method and add a comment to this method *
	}

	/**
	 * Complete this
	 */
	public void levelDown() {
		try {
			for (int i = 0; i < myShapes.size(); i++) {
				MySnowFlake f = myShapes.get(i);
				f.levelDown(currentLevel);
				myShapes.set(i, f);

			}
		} catch (Exception e) {
			System.out.print(e.toString());

		}// Stage 2: complete this method and add a comment to this method *
	}

	/**
	 * remove all shapes
	 */
	public void clearAllShapes() {
		myShapes.clear();// Stage 1: complete this method **
	}

	/**
	 * move and paint all shapes
	 * 
	 * @param g
	 *            the Graphics control
	 */
	public void paintComponent(Graphics g) {

		// Stage 1: Modify the following statements **
		for (int i = 0; i < currentIndex; i++) {
			myShapes.get(i).paint(g);
		}
	}

	// you don't need to make any changes after this line
	// ________________________________

	/**
	 * update the painting area
	 * 
	 * @param g
	 *            the graphics control
	 */
	public void update(Graphics g) {
		paint(g);
	}

	/**
	 * create the popup menu for our animation program
	 */
	protected void makePopupMenu() {
		JMenuItem menuItem;
		// clear all
		menuItem = new JMenuItem("Clear All");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllShapes();
				repaint();
			}
		});
		popup.add(menuItem);
	}
}