package counter.logic.sjsu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WeekDisplay extends JFrame {

	public static Controller control;
	public static AddEventDisplay display;
	public int interval = 1;
	public int lowestS = 18;
	public int highestE = 0;
	
	public static void main(String[] args) {
		JFrame frame = new WeekDisplay();
	}

	public WeekDisplay() {
		super("Project Scheduler");
		control = new Controller();
		display = new AddEventDisplay();
		setSize(900, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JButton button = new JButton("Add Events");
		add(button);
		button.setLayout(null);
		button.setLocation(700,515);
		button.setSize(120,30);
		ActionListener al1;
		al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				AddEventDisplay aTester = new AddEventDisplay();
				display.tabSetUp();
				display.frameSetUp();
			}
		};
		button.addActionListener(al1);
		
		JButton button1 = new JButton("Update");
		add(button1);
		button1.setLayout(null);
		button1.setLocation(550,515);
		button1.setSize(120,30);
		ActionListener al2;
		al2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				update();
			}
		};
		button1.addActionListener(al2);
		control.retrieveData();
		update();
	}
	
	public void update()
	{
		lowestS = 18;
		highestE = 0;
		for(int i = 0; i < control.events.size(); i++)
		{
			if(control.events.get(i).getStartHour() < lowestS)
			{
				lowestS = control.events.get(i).getStartHour();
			}
		}
		
		for(int h = 0; h < control.events.size(); h++)
		{
			if(control.events.get(h).getEndHour() > highestE)
			{
				highestE = control.events.get(h).getEndHour();
			}
		}
		
		if(highestE - lowestS <= 5) {
			interval = 1;
		}
		if(highestE - lowestS > 5 && highestE - lowestS <= 11 ) {
			interval = 2;
		}
		if(highestE - lowestS > 11 && highestE - lowestS <= 17 ) {
			interval = 3;
		}
		if(highestE - lowestS > 17 && highestE - lowestS <= 23 ) {
			interval = 4;
		}
		System.out.println(lowestS);
		System.out.println(highestE);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(20, 40, 808, 420+76);
		g.drawLine(100, 40, 100, 460);
		g.drawLine(20,80,828,80);

		for(int i=0;i<=5;i++) {
			g.drawLine(100+104*i,40,100+104*i,460+76);
			g.drawLine(20,80+i*76,100,80+i*76);
		}
		for(int h=6;h<=7;h++) {
			g.drawLine(100+104*h,40,100+104*h,460+76);
		}
		
		for(int i = 0; i < control.events.size(); i++)
		{
			g.setColor(control.events.get(i).getColor());
			if(control.events.get(i).getColor().equals(Color.BLACK))
			{
				g.fillRect(101+104*(control.events.get(i).getDay()),81+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval),103,((control.events.get(i).getEndHour()-control.events.get(i).getStartHour())*76/interval)+(((control.events.get(i).getEndMinute()*76)/60)/interval)-(((control.events.get(i).getStartMinute()*76)/60)/interval));			
				g.setColor(Color.WHITE);
				g.drawString(control.events.get(i).getName(),101+8+104*(control.events.get(i).getDay()), 101+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				//g.drawString(control.events.get(i).getDescription(),101+8+104*(control.events.get(i).getDay()), 120+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				if(control.events.get(i).getDescription().length() < 14)
				{
				g.drawString(control.events.get(i).getDescription(),101+8+104*(control.events.get(i).getDay()), 120+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				}
				if(control.events.get(i).getDescription().length() >= 14 && control.events.get(i).getDescription().length() < 27)
				{
				g.drawString(control.events.get(i).getDescription().substring(0,13),101+8+104*(control.events.get(i).getDay()), 120+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				g.drawString(control.events.get(i).getDescription().substring(13, control.events.get(i).getDescription().length()),101+8+104*(control.events.get(i).getDay()), 132+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				}
				if(control.events.get(i).getDescription().length() >= 27 && control.events.get(i).getDescription().length() < 40)
				{
				g.drawString(control.events.get(i).getDescription().substring(0,13),101+8+104*(control.events.get(i).getDay()), 120+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				g.drawString(control.events.get(i).getDescription().substring(13, 26),101+8+104*(control.events.get(i).getDay()), 132+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				g.drawString(control.events.get(i).getDescription().substring(26, control.events.get(i).getDescription().length()),101+8+104*(control.events.get(i).getDay()), 144+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				}
			}
			else
			{
				g.fillRect(101+104*(control.events.get(i).getDay()),81+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval),103,((control.events.get(i).getEndHour()-control.events.get(i).getStartHour())*76/interval)+(((control.events.get(i).getEndMinute()*76)/60)/interval)-(((control.events.get(i).getStartMinute()*76)/60)/interval));
				g.setColor(Color.BLACK);
				g.drawString(control.events.get(i).getName(),101+8+104*(control.events.get(i).getDay()), 101+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				if(control.events.get(i).getDescription().length() < 14)
				{
				g.drawString(control.events.get(i).getDescription(),101+8+104*(control.events.get(i).getDay()), 120+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				}
				if(control.events.get(i).getDescription().length() >= 14 && control.events.get(i).getDescription().length() < 27)
				{
				g.drawString(control.events.get(i).getDescription().substring(0,13),101+8+104*(control.events.get(i).getDay()), 120+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				g.drawString(control.events.get(i).getDescription().substring(13, control.events.get(i).getDescription().length()),101+8+104*(control.events.get(i).getDay()), 132+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				}
				if(control.events.get(i).getDescription().length() >= 27 && control.events.get(i).getDescription().length() < 40)
				{
				g.drawString(control.events.get(i).getDescription().substring(0,13),101+8+104*(control.events.get(i).getDay()), 120+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				g.drawString(control.events.get(i).getDescription().substring(13, 26),101+8+104*(control.events.get(i).getDay()), 132+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				g.drawString(control.events.get(i).getDescription().substring(26, control.events.get(i).getDescription().length()),101+8+104*(control.events.get(i).getDay()), 144+((control.events.get(i).getStartHour()-lowestS)*76/interval)+(((control.events.get(i).getStartMinute()*76)/60)/interval));
				}
			}
			g.setColor(Color.BLACK);
		}
		
		g.drawString("Time", 45, 65);
		g.drawString("Sun", 120+20, 65);
		g.drawString("Mon", 224+20, 65);
		g.drawString("Tue", 328+20, 65);
		g.drawString("Wed", 432+20, 65);
		g.drawString("Thur", 536+20, 65);
		g.drawString("Fri", 536+104+20, 65);
		g.drawString("Sat", 536+104*2+20, 65);
		g.drawString(lowestS+":00", 50, 120);
		g.drawString(lowestS+interval+":00", 50, 120+76*1);
		g.drawString(lowestS+2*interval+":00", 50, 120+76*2);
		g.drawString(lowestS+3*interval+":00", 50, 196+76*2);
		g.drawString(lowestS+4*interval+":00", 50, 196+76*3);
		g.drawString(lowestS+5*interval+":00", 50, 196+76*4);
	}
}
