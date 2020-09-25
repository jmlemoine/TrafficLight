package Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Movement2 extends JPanel implements ActionListener/*, KeyListener*/ {

	Timer t = new Timer(5, this);
	int x = 10, y = 10;
	int velx = 0, vely = 0;
	
	public Movement2()
	{
		t.start();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.red);
		g.fillRect(x, y, 40, 80);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graphics g = null;
		if(x<0 || x>200)
		{
			x = 0;
		}
		if(y<0 || y>200)
		{
			y = 0;
		}
		x += velx;
		y += vely;
		repaint();
		
	}
	
	public void up()
	{
		vely = -1;
		velx = 0;
	}
	
	public void down()
	{
		vely = 1;
		velx = 0;
	}
	
	public void left()
	{
		velx = -1;
		vely = 0;
	}
	
	public void right()
	{
		velx = 1;
		vely = 0;
	}
	
	public void stop()
	{
		velx = 0;
		vely = 0;
	}
	
}
