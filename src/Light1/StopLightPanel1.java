package Light1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StopLightPanel1 extends JPanel {

	StopLightDrawing1 light = new StopLightDrawing1();

	public Timer t;
	public int h, m, s, cs;
	
	JLabel label = new JLabel("KLK");
	JButton start = new JButton("Start");
	JButton pause = new JButton("Pause");
	JButton stop = new JButton("Stop");
	
	
		public StopLightPanel1() {
		
		t = new Timer(10, acciones);	
			
		JButton changeButton = new JButton("Switch");
		light.setPreferredSize(new Dimension(50, 130));
		
		buttonListener l = new buttonListener();
		changeButton.addActionListener(l);
		
		buttonStart bs = new buttonStart();
		start.addActionListener(bs);
		
		buttonPause bst = new buttonPause();
		pause.addActionListener(bst);
		
		buttonStop bsp = new buttonStop();
		stop.addActionListener(bsp);
		
		add(label);
		add(light);
		add(changeButton);
		add(start);
		add(pause);
		add(stop);
		
	}
		
	
	private ActionListener acciones = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae)
		{
			
			cs++;
			if(cs==100)
			{
				cs = 0;
				++s;
			}
			if(s==60 && light.activeLight.equals("red"))
			{
				s = 0;
				/*if(light.activeLight.equals("red"))
				{*/
					light.activeLight = "green";
					light.go = Color.green;
					light.stop = Color.gray;
				//}
				
				/*light.activeLight = "green";
				light.go = Color.green;*/
				
				//++m;
			}
			if(light.activeLight.equals("green") && s==30)
			{
				s = 0;
				light.activeLight = "yellow";
				light.slow = Color.yellow;
				light.go = Color.gray;
			}
			if(light.activeLight.equals("yellow") && s==3)
			{
				s = 0;
				light.activeLight = "red";
				light.stop = Color.red;
				light.slow = Color.gray;
			}
			
			/*if(m==60)
			{
				m = 0;
				++h;
			}*/
			actualizarLabel();
			repaint();
		}
	};
	
	private void actualizarLabel()
	{
		String tiempo = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
		label.setText(tiempo);
	}
		
	private static void delaySegundo()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			
		}
	}
	
	class buttonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			light.changeColor();
		}
	}
	
	class buttonStart implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			t.start();
			start.setEnabled(false);
			pause.setEnabled(true);
			stop.setEnabled(true);
		}
	}
	
	class buttonPause implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			t.stop();
			pause.setEnabled(false);
			start.setEnabled(true);
			stop.setEnabled(true);
		}
	}
	
	class buttonStop implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			if(t.isRunning())
			{
				t.stop();
				start.setEnabled(true);
				
			}
			pause.setEnabled(false);
			stop.setEnabled(false);
			h=0; m=0; s=0; cs=0;
			actualizarLabel();
		}
	}
	
	
	
}
