package Light1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class StopLightDrawing4 extends JComponent {

	Color go = Color.gray;
	Color slow = Color.gray;
	Color stop = Color.red;
	
	String activeLight = "red";
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, 100, 260);
		
		g.setColor(stop);
		g.fillOval(10, 10, 25, 25);
		
		g.setColor(slow);
		g.fillOval(10, 50, 25, 25);
		
		g.setColor(go);
		g.fillOval(10, 90, 25, 25);
	}
	
}
