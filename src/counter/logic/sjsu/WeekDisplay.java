package counter.logic.sjsu;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class WeekDisplay extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new WeekDisplay();
	}

	public WeekDisplay() {
		setSize(900, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JButton button = new JButton("Event 1");
		add(button);
		button.setLayout(null);
		button.setLocation(92,80);
		button.setSize(104,230);
		
		
	/*	JButton button2 = new JButton("Event 2");
		add(button2);
		button2.setLayout(null);
		button2.setLocation(92+208,120);
		button2.setSize(104,100);*/
		JScrollPane scrollP = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setContentPane(scrollP);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(20, 40, 808, 420);
		g.drawLine(100, 40, 100, 460+1000);
		g.drawLine(20,80,828,80);

		for(int i=0;i<=5;i++) {
			g.drawLine(100+104*i,40,100+104*i,460);
			g.drawLine(20,80+i*76,100,80+i*76);
		}
		for(int h=6;h<=7;h++) {
			g.drawLine(100+104*h,40,100+104*h,460);
		}
		
		
		g.drawString("Time", 45, 65);
		g.drawString("Sat", 120+20, 65);
		g.drawString("Mon", 224+20, 65);
		g.drawString("Tue", 328+20, 65);
		g.drawString("Wed", 432+20, 65);
		g.drawString("Thur", 536+20, 65);
		g.drawString("Fri", 536+104+20, 65);
		g.drawString("Sun", 536+104*2+20, 65);
		g.drawString("9:00 AM", 40, 120);
		g.drawString("10:00 AM", 35, 120+76*1);
		g.drawString("11:00 AM", 35, 120+76*2);
		g.drawString("12:00 PM", 35, 196+76*2);
		g.drawString("1:00 PM", 35, 196+76*3);
	}
}
