import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.SpinnerModel;


public class MockupUI2 extends JFrame {
	
	private JFrame frame;
		
	private void frameSetUp()
	{
		frame = new JFrame("JSpinner");
		frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    //frame.pack();
	    
		JLabel label1 = new JLabel("Event 1");
		JLabel label2 = new JLabel("Time: ");
		JLabel label3 = new JLabel(":");
		SpinnerNumberModel hmodel = new SpinnerNumberModel(0, 0,23, 1);
		JSpinner hours = new JSpinner(hmodel);
		SpinnerNumberModel mmodel = new SpinnerNumberModel(00,00,59, 1);
		JSpinner mins = new JSpinner(mmodel);
		String.format("%02d", mins.getValue());

		
		frame.add(label1);
		label1.setBounds(170,10,50,30);
		frame.add(label2);
		label2.setBounds(10,45,50,30);
		frame.add(label3);
		label3.setBounds(90,45,20,25);
		frame.add(hours);
		frame.add(mins);
		hours.setBounds(50,40,35,30);
		mins.setBounds(100,40,35,30);
	    
		
		
		JButton confirm = new JButton("Update");
		JLabel reminder = new JLabel("Reminder:");
		frame.add(reminder);
		SpinnerNumberModel rmmodel = new SpinnerNumberModel(30,1,120, 1);
		JSpinner rmins = new JSpinner(rmmodel);
		reminder.setBounds(10,80,100,30);
		frame.add(rmins);
		rmins.setBounds(90,80,45,30);
		JLabel label4 = new JLabel("minutes before");
		frame.add(label4);
		label4.setBounds(140,85,100,30);
		frame.add(confirm);
		confirm.setBounds(20,120,90,25);
		JLabel label5 = new JLabel("A reminder notification will be given at 15:40");
		frame.add(label5);
		label5.setBounds(20,200,400,30);
		
		
	    frame.setSize(400, 300);
	    frame.setVisible(true);

	}
	
	  public static void main(String[] args) {
		   MockupUI2 aTester = new MockupUI2();
		   aTester.frameSetUp();
		  }
}
