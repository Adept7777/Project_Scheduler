import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Graphics;

public class MockupUI3 extends JFrame {

		public static void main(String[] args) {
		    new MockupUI3();
		}

		public MockupUI3() {
		    super("Class Paint");            
		    setSize(640, 480);    
		    setLayout(null);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setVisible(true);
		   /* JButton button = new JButton("Event 1");
		    add(button);
		    button.setLayout(null);
		    button.setLocation(92,80);
		    button.setSize(104,230);
		    
		    JButton button2 = new JButton("Event 2");
		    add(button2);
		    button2.setLayout(null);
		    button2.setLocation(92+208,120);
		    button2.setSize(104,100);*/
		}

		public void paint(Graphics g) {
		    super.paint(g);
		    g.drawRect(20, 40, 600, 420);
		    g.drawLine(100, 40, 100, 460);
		    g.drawLine(20,80,620,80);
		    for(int i=0;i<=5;i++)
		    {
		    	g.drawLine(100+104*i,40,100+104*i,460);
		    	g.drawLine(20,80+i*76,100,80+i*76);
		    }

		    g.drawString("Time", 45, 65);
		    g.drawString("Mon Sep 21", 120, 65);
		    g.drawString("Tue Sep 22", 224, 65);
		    g.drawString("Wed Sep 23", 328, 65);
		    g.drawString("Thu Sep 24", 432, 65);
		    g.drawString("Fri Sep 24", 536, 65);
		    g.drawString("9:00 AM", 40, 120);
		    g.drawString("10:00 AM", 35, 120+76*1);
		    g.drawString("11:00 AM", 35, 120+76*2);
		    g.drawString("12:00 PM", 35, 196+76*2);
		    g.drawString("1:00 PM", 35, 196+76*3);
		}

		}