package counter.logic.sjsu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AddEventDisplay {
	private JFrame frame;
	private JTabbedPane tabs;
	private int tabCounter = 2;
	private JButton addButton;
	
	private void frameSetUp() {
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.add(tabs);
	} 
	  
	private void tabSetUp() {
		tabs = new JTabbedPane();
		JComponent panel1 = makeTextPanel("Panel #1");
		tabs.addTab("Event 1", panel1);
		JComponent panel2 = makeTextPanel("Panel #2");
		tabs.addTab("Event 2", panel2);
		updateTabs();
	}
	  
	  
	public void updateTabs() {
		JPanel closePanel1 = new JPanel();
		JPanel closePanel = new JPanel();
		addButton = new JButton("+");
		closePanel.setOpaque(false);
		closePanel.add(addButton);
		ActionListener al;
		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				tabs.remove(tabCounter);
				JComponent panel1 = makeTextPanel("New Event");
				tabs.addTab("New Event", panel1);
				tabCounter++;
				updateTabs();
			}
		};
		addButton.addActionListener(al);
		tabs.add(closePanel1);
		tabs.setTabComponentAt(tabCounter,closePanel);
	}
	  
	protected JComponent makeTextPanel (String text) {
		JPanel panel = new JPanel(null);
		JLabel label1 = new JLabel("Name: ");
		JTextField name = new JTextField(text,15);
		JLabel label2 = new JLabel("Time: ");
		JTextField time = new JTextField("12:00 AM",15);
		JLabel label3 = new JLabel("Color");
		JTextField color = new JTextField("Red",15);
		JButton save = new JButton("Save");
		JButton delete = new JButton("Delete");
		ActionListener al1;
		al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Component selected = tabs.getSelectedComponent();
				tabs.remove(selected);
				tabCounter--;
				//updateTabs();
			}
		};
		delete.addActionListener(al1);

		panel.setPreferredSize(new Dimension(400,240));
		panel.add(label1);
		panel.add(name);
		panel.add(label2);
		panel.add(time);
		panel.add(save);
		panel.add(delete);
		panel.add(label3);
		panel.add(color);
		label1.setBounds(10,10,50,20);
		name.setBounds(50,10,80,20);
		label2.setBounds(10,50,50,20);
		time.setBounds(50,50,80,20);
		label3.setBounds(10,90,50,20);
		color.setBounds(50,90,80,20);
		save.setBounds(300,115,80,40);
		delete.setBounds(300,160,80,40);
		return panel;
	}
	  
	public static void main(String[] args) {
		AddEventDisplay aTester = new AddEventDisplay();
		aTester.tabSetUp();
		aTester.frameSetUp();
	}
}
