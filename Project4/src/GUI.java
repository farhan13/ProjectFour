import javax.swing.*;
import sun.applet.Main;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;


public class GUI extends JFrame implements ActionListener {

	private JButton buttons[][];
	private boolean toggle;
	private Container container;
	private GridLayout board;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public GUI() {
		
		board = new GridLayout(9, 10);
	}

	
	
	
	
	public static void main(String args[]) {
		GUI test = new GUI();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
