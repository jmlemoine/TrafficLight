package Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Movement3 extends JPanel implements ActionListener {

	Timer t = new Timer(5, this);
	int x = 10, y = 10;
	int x1 = 10, y1 = 10, velx = 0, vely = 0;
	
	public Movement3()
	{
		t.start();
		//addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Graphics2D g2 = (Graphics2D) g;
		//g2.fill(new Ellipse2D.Double(x, y, 40, 40));*/
		
		g.setColor(Color.red);
		g.fillRect(x, y, 40, 80);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graphics g = null;
		if(/*x<0 || */x>200)
		{
			//velx = -velx;
			x = 0;
		}
		if(x<0)
		{
			x=200;
		}
		if(/*y<0 || */y>200)
		{
			//vely = -vely;
			y = 0;
		}
		if(y<0)
		{
			y=200;
		}
		x += /*Double.valueOf(*/velx;//velx;
		y += /*Double.valueOf(*/vely;//vely;
		repaint();
		/*x2 += velX2;
		y2 += velY2;
		x += velx;
		y += vely;*/
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
	
	/*@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP)
		{
			up();
		}
		if(code == KeyEvent.VK_DOWN)
		{
			down();
		}
		if(code == KeyEvent.VK_RIGHT)
		{
			right();
		}
		if(code == KeyEvent.VK_LEFT)
		{
			left();
		}
		if(code == KeyEvent.VK_SPACE)
		{
			stop();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}*/
	
}
