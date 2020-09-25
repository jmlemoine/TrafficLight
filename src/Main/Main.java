package Main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Light1.StopLightPanel1;
import Movement.Movement1;
import Movement.Movement2;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel1 = new StopLightPanel1();
		
		frame.add(panel1);
		frame.setSize(1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}
	
	

}
