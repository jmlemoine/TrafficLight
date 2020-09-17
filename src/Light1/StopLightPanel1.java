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
	StopLightDrawing2 light2 = new StopLightDrawing2();
	StopLightDrawing3 light3 = new StopLightDrawing3();

	public Timer t;
	public int h, m, s, cs;
	public int h2, m2, s2, cs2;
	public int h3, m3, s3, cs3;
	
	JLabel label = new JLabel("00:00");
	JLabel label2 = new JLabel("00:00");
	JLabel label3 = new JLabel("00:00");
	JButton start = new JButton("Start");
	JButton pause = new JButton("Pause");
	JButton stop = new JButton("Stop");
	
	
		public StopLightPanel1() {
			
		t = new Timer(10, acciones);	
		
		JButton changeButton = new JButton("Switch");
		light.setPreferredSize(new Dimension(50, 130));
		light2.setPreferredSize(new Dimension(50, 130));
		light3.setPreferredSize(new Dimension(50, 130));
		
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
		add(label2);
		add(light2);
		add(label3);
		add(light3);
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
			cs2++;
			cs3++;
			if(cs==100)
			{
				cs = 0;
				++s;
			}
			if(cs2==100)
			{
				cs2 = 0;
				++s2;
			}
			if(cs3==100)
			{
				cs3 = 0;
				++s3;
			}
			if(light.activeLight.equals("red") && s==50)
			{
				s = 0;
				light.activeLight = "green";
				light.go = Color.green;
				light.stop = Color.gray;
			}
			if (light2.activeLight.equals("red") && s2==50)
			{
				s2 = 0;
				light2.activeLight = "green";
				light2.go = Color.green;
				light2.stop = Color.gray;
			}
			if (light3.activeLight.equals("red") && s3==50)
			{
				s3 = 0;
				light3.activeLight = "green";
				light3.go = Color.green;
				light3.stop = Color.gray;
			}
			if(light.activeLight.equals("green") && s==20)
			{
				s = 0;
				light.activeLight = "yellow";
				light.slow = Color.yellow;
				light.go = Color.gray;
			}
			if(light2.activeLight.equals("green") && s2==20) 
			{
				s2 = 0;
				light2.activeLight = "yellow";
				light2.slow = Color.yellow;
				light2.go = Color.gray;
			}
			if(light3.activeLight.equals("green") && s3==20) 
			{
				s3 = 0;
				light3.activeLight = "yellow";
				light3.slow = Color.yellow;
				light3.go = Color.gray;
			}
			if(light.activeLight.equals("yellow") && s==5)
			{
				s = 0;
				s2 = 0;
				light.activeLight = "red";
				light.stop = Color.red;
				light.slow = Color.gray;
				light2.activeLight = "green";
				light2.go = Color.green;
				light2.stop = Color.gray;
			}
			if(light2.activeLight.equals("yellow") && s2==5)
			{
				s2 = 0;
				light2.activeLight = "red";
				light2.stop = Color.red;
				light2.slow = Color.gray;
				light3.activeLight = "green";
				light3.go = Color.green;
				light3.stop = Color.gray;
			}
			if(light3.activeLight.equals("yellow") && s3==5)
			{
				s3 = 0;
				light3.activeLight = "red";
				light3.stop = Color.red;
				light3.slow = Color.gray;
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
		String tiempo1 = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
		String tiempo2 = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s2<=9?"0":"")+s2+":"+(cs2<=9?"0":"")+cs2;
		String tiempo3 = /*(h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+*/(s3<=9?"0":"")+s3+":"+(cs3<=9?"0":"")+cs3;
		label.setText(tiempo1);
		label2.setText(tiempo2);
		label3.setText(tiempo3);
		
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
			//light.changeColor();
			//light2.changeColor();
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
			h2=0; m2=0; s2=0; cs2=0;
			h3=0; m3=0; s3=0; cs3=0;
			actualizarLabel();
		}
	}
	
	
	
}
