package Light1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class StopLightDrawing1 extends JComponent {

	Color go = Color.gray;
	Color slow = Color.gray;
	Color stop = Color.red;
	
	String activeLight = "red";
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, 50, 130);
		
		g.setColor(stop);
		g.fillOval(10, 10, 25, 25);
		
		g.setColor(slow);
		g.fillOval(10, 50, 25, 25);
		
		g.setColor(go);
		g.fillOval(10, 90, 25, 25);
	}
	
	/*public void changeColor()
	{
		go = Color.gray;
		slow = Color.gray;
		stop = Color.gray;
		
		if(activeLight.equals("red"))
		{
			activeLight = "green";
			go = Color.green;
			//slp.actualizarLabel();
		}
		else if(activeLight.equals("green"))
		{
			activeLight = "yellow";
			slow = Color.yellow;
		}
		else if(activeLight.equals("yellow"))
		{
			activeLight = "red";
			stop = Color.red;
		}
		repaint();
	}*/
	
}
