/*
 *	=============================================================
 *	Recursive Curves Application: contains a panel where
 *	geometric patterns are shown on the screen.
 *	==============================================================
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class A1 extends JApplet {
	JTextField dxTextField;
	JTextField dyTextField;
	A1Panel panel;

	/** the main method to create the frame
	 */
	public static void main(String[] args) {
		A1 applet = new A1();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		frame.setTitle("SnowFlake Recursion made by sOm2y");
		applet.init();
		frame.setSize(500, 500);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		frame.setLocation((d.width - frameSize.width) / 2, (d.height - frameSize.height) / 2);
		frame.setVisible(true);
		
	}

	/** the init method to initialise components
	 */
	public void init() {
		panel = new A1Panel();
		JPanel settingPanel = new JPanel();
		add(panel, BorderLayout.CENTER);
		add(settingPanel, BorderLayout.NORTH);

		// set up the level up JButton
		JButton levelUpButton = new JButton("Level Up");
		levelUpButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.levelUp();
			}
		});
		settingPanel.add( levelUpButton );

		// set up the level down JButton
		JButton levelDownButton = new JButton("Level Down");
		levelDownButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.levelDown();
			}
		});
		settingPanel.add( levelDownButton );

		// set up the translate Jbutton and the two JTextFields
		dxTextField = new JTextField("5", 3);
		dyTextField = new JTextField("10", 3);
		JButton translateButton = new JButton("Translate:");
		settingPanel.add( translateButton );
		settingPanel.add( new JLabel("("));
		settingPanel.add( dxTextField);
		settingPanel.add( new JLabel(","));
		settingPanel.add( dyTextField);
		settingPanel.add( new JLabel(")"));
		translateButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panel.translateAll();//Stage 3: Complete this method

			}
		});

	}
}

