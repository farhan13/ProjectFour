/*David Qiao - dqiao4
 * Farhan Ahmed - fahmed26
 * Tarush Vig - tvig2
 * 
 * CS 342 Fall 2017
 * Professor Troy
 * Project 4 - Battleship
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;


public class battleshipCLIENT extends JFrame implements ActionListener {
	JButton buttons[][];
	JButton LnumLine[], RnumLine[];
	Container grid;
	JPanel field, leftLine, rightLine;
	
	public battleshipCLIENT() {
		
		super ( "Battleship, The Game (Server)" );
		grid = getContentPane();
		grid.setLayout(new BorderLayout());
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		field = new JPanel(new GridLayout(11, 21));
		leftLine = new JPanel(new GridLayout(11,1));
		rightLine = new JPanel(new GridLayout(11,1));
		
		buttons = new JButton[11][21];
		LnumLine = new JButton[11];
		RnumLine = new JButton[11];
		
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 21; j++) {	
				JButton display = new JButton("" + i + "," + j);
				display.setBackground(Color.BLUE);
				field.add(display);
				
				buttons[i][j] = display;
			}
		}
		//top number line
		for(int j = 0; j < 11; j++) {
			int i = 0;
			buttons[i][j].setBackground(Color.white);
			buttons[i][j].setText("" + (j+1));
		}
		for(int j = 11; j < 21; j++) {
			int i = 0;
			buttons[i][j].setBackground(Color.white);
			buttons[i][j].setText("" + (j-10));
		}//end of top number line shenanigans
		
		//leftLine number line
		for(int i = 0; i < 11; i++) {
			JButton numLine1 = new JButton("");
			numLine1.setBackground(Color.WHITE);
//			numLine1.setBorder(Color.BLACK);
			JButton numLine2 = new JButton("");
			numLine2.setBackground(Color.WHITE);
			
			leftLine.add(numLine1);
			rightLine.add(numLine2);
			
			LnumLine[i] = numLine1;
			RnumLine[i] = numLine2;
		}
		
		LnumLine[1].setText("A");
		LnumLine[2].setText("B");
		LnumLine[3].setText("C");
		LnumLine[4].setText("D");
		LnumLine[5].setText("E");
		LnumLine[6].setText("F");
		LnumLine[7].setText("G");
		LnumLine[8].setText("H");
		LnumLine[9].setText("I");
		LnumLine[10].setText("J");
		
		RnumLine[1].setText("A");
		RnumLine[2].setText("B");
		RnumLine[3].setText("C");
		RnumLine[4].setText("D");
		RnumLine[5].setText("E");
		RnumLine[6].setText("F");
		RnumLine[7].setText("G");
		RnumLine[8].setText("H");
		RnumLine[9].setText("I");
		RnumLine[10].setText("J");
		
		//clears the unused number line sections
		LnumLine[0].setText("");
//		RnumLine[0].setText("");		
		
		//BORDER
		for(int i = 0; i < 11; i++) {	
			int j = 10;
			buttons[i][j].setBackground(Color.BLACK);
			buttons[i][j].setText("");
		}
		
		for(int i = 1; i < 11; i++) {
			for(int j = 11; j < 21; j++) {
				buttons[i][j].setBackground(Color.GREEN);
				buttons[i][j].setBorder(new LineBorder(Color.YELLOW));
				buttons[i][j].addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JButton temp = (JButton) e.getSource();
								for(int i = 1; i < 11; i++) {
									for(int j = 11; j < 21; j++) {
										if(temp.equals(buttons[i][j]))
											buttons[i][j].setText("Butts!");
									}
								}
							}
							
						}//end of actionListener
				);
			}
		}
		
		grid.add(field, BorderLayout.CENTER);
		grid.add(leftLine, BorderLayout.WEST);
		grid.add(rightLine, BorderLayout.EAST);
		JMenu Menu = new JMenu( "Menu" );
		Menu.setMnemonic( 'M' );

		JMenuItem connectItem = new JMenuItem( "Connect!" );
		connectItem.setMnemonic( 'C' );
		Menu.add( connectItem );
		connectItem.addActionListener(
				new ActionListener() {
					public void actionPerformed( ActionEvent e )
					{
						//CODE GOES HERE
						
						JOptionPane.showMessageDialog(
								battleshipCLIENT.this,
								"Establishing Connection...",
								"Connection", JOptionPane.PLAIN_MESSAGE );
						
						String ship11 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Aircraft Carrier's head : \nNOTE: ship is 5 units long");
						String ship12 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Aircraft Carrier's head : \nNOTE: ship is 5 units long");
						int ship1a = Integer.parseInt(ship11);
						int ship1b = String2Int(ship12);

						String ship13 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Aircraft Carrier's tail : \nNOTE: ship is 5 units long");
						String ship14 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Aircraft Carrier's tail : \nNOTE: ship is 5 units long");
						int ship1c = Integer.parseInt(ship13);
						int ship1d = String2Int(ship14);
						
						shipPlacement(ship1a, ship1b, ship1c, ship1d);
						
						String ship21 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Battleship's head : \nNOTE: ship is 4 units long");
						String ship22 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Battleship's head : \nNOTE: ship is 4 units long");
						int ship2a = Integer.parseInt(ship21);
						int ship2b = String2Int(ship22);

						String ship23 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Battleship's tail : \nNOTE: ship is 4 units long");
						String ship24 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Battleship's tail : \nNOTE: ship is 4 units long");
						int ship2c = Integer.parseInt(ship23);
						int ship2d = String2Int(ship24);
						
						shipPlacement(ship2a, ship2b, ship2c, ship2d);
						
						String ship31 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Destroyer's head : \nNOTE: ship is 3 units long");
						String ship32 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Destroyer's head : \nNOTE: ship is 3 units long");
						int ship3a = Integer.parseInt(ship31);
						int ship3b = String2Int(ship32);

						String ship33 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Destroyer's tail : \nNOTE: ship is 3 units long");
						String ship34 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Destroyer's tail : \nNOTE: ship is 3 units long");
						int ship3c = Integer.parseInt(ship33);
						int ship3d = String2Int(ship34);
						
						shipPlacement(ship3a, ship3b, ship3c, ship3d);
						
						String ship41 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Submarine's head : \nNOTE: ship is 3 units long");
						String ship42 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Submarine's head : \nNOTE: ship is 3 units long");
						int ship4a = Integer.parseInt(ship41);
						int ship4b = String2Int(ship42);

						String ship43 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Submarine's tail : \nNOTE: ship is 3 units long");
						String ship44 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Submarine's tail : \nNOTE: ship is 3 units long");
						int ship4c = Integer.parseInt(ship43);
						int ship4d = String2Int(ship44);
						
						shipPlacement(ship4a, ship4b, ship4c, ship4d);
						
						String ship51 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Patrol Boat's head : \nNOTE: ship is 2 units long");
						String ship52 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Patrol Boat's head : \nNOTE: ship is 2 units long");
						int ship5a = Integer.parseInt(ship51);
						int ship5b = String2Int(ship52);

						String ship53 = JOptionPane.showInputDialog("Enter in X coordinate (1-10) for Patrol Boat's tail : \nNOTE: ship is 2 units long");
						String ship54 = JOptionPane.showInputDialog("Enter in Y coordinate (A-J) for Patrol Boat's tail : \nNOTE: ship is 2 units long");
						int ship5c = Integer.parseInt(ship53);
						int ship5d = String2Int(ship54);
						
						shipPlacement(ship5a, ship5b, ship5c, ship5d);
//						JOptionPane.showMessageDialog(
//								battleshipCLIENT.this,
//								"ship's X = " + ship1a + "\nship's Y = " + ship1b,
//								"Wieners", JOptionPane.PLAIN_MESSAGE );
//						int ship21
//						int ship22
//						
//						int ship31
//						int ship32
//						
//						int ship41
//						int ship42
//						
//						int ship51
//						int ship52
					}
				}
		);
		
		JMenuItem aboutItem = new JMenuItem( "About" );
		aboutItem.setMnemonic( 'A' );
		Menu.add( aboutItem );
		aboutItem.addActionListener(
				new ActionListener() {
					public void actionPerformed( ActionEvent e )
					{
						JOptionPane.showMessageDialog(
						battleshipCLIENT.this,
						"This program was designed by:\nFarhan Ahmed - fahmed26\n"
						+ "David Qiao - dqiao4\nTarush Vig - tvig2\n",
						"About Us", JOptionPane.PLAIN_MESSAGE );
					}
				}//end of actionListener
	    );
		
		JMenuItem helpItem = new JMenuItem( "Help" );
		helpItem.setMnemonic( 'H' );
		Menu.add( helpItem );
		helpItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(
								battleshipCLIENT.this,
								"stuff goes here",
								"How to play", JOptionPane.PLAIN_MESSAGE );
						
						
					}
					
				}//end of actionListener
		);
		
		JMenuItem statsItem = new JMenuItem( "Statistics" );
		statsItem.setMnemonic( 'S' );
		Menu.add( statsItem );
		statsItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(
								battleshipCLIENT.this,
								"Accuracy - \nHits needed to win - \nUglyness - 100%",
								"Status of the Game", JOptionPane.PLAIN_MESSAGE );
						
					}
					
				}//end of actionListener
		);
		
		JMenuItem exitItem = new JMenuItem( "Exit" );
		exitItem.setMnemonic( 'x' );
		Menu.add( exitItem );
		exitItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit( 0 );
						
					}
					
				}//end of actionListener
		);
		
		JMenuBar bar = new JMenuBar();  
		setJMenuBar( bar );  
		bar.add( Menu );
		
		setSize(1600, 800);
		setVisible( true );
	}//end of displayGUI
	
	public static void main(String[] args) {
		battleshipCLIENT game = new battleshipCLIENT();
	}
	
	public int String2Int(String x) {
		if (x.equals("A"))
			return 1;
		else if(x.equals("B"))
			return 2;
		else if(x.equals("C"))
			return 3;
		else if(x.equals("D"))
			return 4;
		else if(x.equals("E"))
			return 5;
		else if(x.equals("F"))
			return 6;
		else if(x.equals("G"))
			return 7;
		else if(x.equals("H"))
			return 8;
		else if(x.equals("I"))
			return 9;
		else //(x == "J")
			return 10;
	}
	
	public void shipPlacement(int h2, int h1, int t2, int t1){
		buttons[h1][h2-1].setBackground(Color.GRAY);
		buttons[t1][t2-1].setBackground(Color.GRAY);
		int b;
		int temp;
		//HORIZONTAL ship
		if(h1 == t1) {
			b = Math.abs(h2 - t2);
			if(t2 < h2) {
				temp = h2 -1;
				for(int i = 0; i < b; i++) {
					buttons[h1][temp--].setBackground(Color.GRAY);
				}
			}
			else {
				for(int i = 0; i < b; i++) {
					buttons[h1][h2++].setBackground(Color.GRAY);
				}
			}
		}
		//VERTICAL ship	
		else {
			b = Math.abs(h1 - t1);
		
			if(t1 < h1) {
				for(int i = 0; i < b; i++) {
					buttons[h1--][h2-1].setBackground(Color.GRAY);
				}
			}
			else {
				for(int i = 0; i < b; i++) {
					buttons[h1++][h2-1].setBackground(Color.GRAY);
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}

