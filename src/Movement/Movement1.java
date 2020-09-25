package Movement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Movement1 extends JPanel implements ActionListener {

	Timer t = new Timer(5, this);
	double x = 0, y = 100, velX = 2, velY = 0;
	double x2 = 0, y2 = 100, velX2 = 0, velY2 = 2;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D g3 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
		Ellipse2D circle2 = new Ellipse2D.Double(x2, y2, 40, 40);
		g2.fill(circle);
		g2.fill(circle2);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(x<0 || x>200)
		{
			velX = -velX;
		}
		if(y2<0 || y2>200)
		{
			velY2 = -velY2;
		}
		x += velX;
		y += velY;
		x2 += velX2;
		y2 += velY2;
		repaint();
	}
	
	
	
}
