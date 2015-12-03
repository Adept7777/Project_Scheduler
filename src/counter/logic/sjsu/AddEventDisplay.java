package counter.logic.sjsu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class AddEventDisplay {
	private JFrame frame;
	private JTabbedPane tabs;
	private int tabCounter = 0;
	private JButton addButton;
	
	public void frameSetUp() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setResizable(true);
		frame.pack();
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.add(tabs);
	}  
	  
	public void tabSetUp() {
		tabs = new JTabbedPane();
		tabCounter = 0;
		tabs.setPreferredSize(new Dimension(600,400));
		for(int i = 0; i < WeekDisplay.control.events.size(); i++)
		{
			Event e = WeekDisplay.control.events.get(i);
			JComponent npanel = makeTextPanel(e.getName(),e.getColor(),e.getStartHour(),e.getStartMinute(),e.getEndHour(),e.getEndMinute(),e.getDay(),e.getDescription());
			tabs.addTab(e.getName(),npanel);
			tabCounter++;
		}
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
				JComponent panel1 = makeTextPanel("New Event",Color.BLACK,0,0,1,0,0,"Fill here");
				tabs.addTab("New Event", panel1);
				Event nevent = new Event("New Event",Color.BLACK,0,1,0,0,0,"Description");
				WeekDisplay.control.addEvent(nevent);
				tabCounter++;
				updateTabs();
			}
		};
		addButton.addActionListener(al);
		tabs.add(closePanel1);
		tabs.setTabComponentAt(tabCounter,closePanel);
	}
	  
	protected JComponent makeTextPanel (String text,Color c1,int sh, int sm, int eh, int em, int d1, String d2) {
		JPanel panel = new JPanel(null);
		JLabel label1 = new JLabel("Name: ");
		JTextField name = new JTextField(text,20);
		JLabel label2 = new JLabel("Time: ");
		JLabel label3 = new JLabel("Color: ");
		JLabel label4 = new JLabel("Day: ");
		JLabel label5 = new JLabel("Description: ");
		JTextArea desc = new JTextArea(d2,5,90);
		desc.setLineWrap(true);
		desc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JButton save = new JButton("Save All");
		SpinnerNumberModel hmodel = new SpinnerNumberModel(sh, 0,23, 1);
		SpinnerNumberModel mmodel = new SpinnerNumberModel(sm,00,59, 1);
		SpinnerNumberModel ehmodel = new SpinnerNumberModel(eh, 0,23, 1);
		SpinnerNumberModel emmodel = new SpinnerNumberModel(em,00,59, 1);
		JSpinner shours = new JSpinner(hmodel);
		JSpinner smins = new JSpinner(mmodel);
		JSpinner ehours = new JSpinner(ehmodel);
		JSpinner emins = new JSpinner(emmodel);
		JLabel labeltime = new JLabel(":                to                :");
		String[] colorlist = {"Black","Blue","Green","Red","White"};
		JComboBox<String> colors = new JComboBox<String>(colorlist);
		String[] daylist = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		JComboBox<String> days = new JComboBox<String>(daylist);
		//Save Button
		ActionListener al2;
		al2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				WeekDisplay.control.storeData();
			}
		};
		save.addActionListener(al2);
		
		JButton update = new JButton("Update");
		
		
		//Update button
		ActionListener al3;
		al3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				Event tempE = WeekDisplay.control.events.get(tabs.getSelectedIndex());
				tempE.setName(name.getText());
				if(colors.getSelectedItem() == "Black")
				{
					tempE.setColor(Color.BLACK);
				}
				if(colors.getSelectedItem() == "Blue")
				{
					tempE.setColor(Color.BLUE);
				}
				if(colors.getSelectedItem() == "Green")
				{
					tempE.setColor(Color.GREEN);
				}
				if(colors.getSelectedItem() == "Red")
				{
					tempE.setColor(Color.RED);
				}
				if(colors.getSelectedItem() == "White")
				{
					tempE.setColor(Color.WHITE);
				}
				if(days.getSelectedItem() == "Sunday")
				{
					tempE.setDay(0);
				}
				if(days.getSelectedItem() == "Monday")
				{
					tempE.setDay(1);
				}
				if(days.getSelectedItem() == "Tuesday")
				{
					tempE.setDay(2);
				}
				if(days.getSelectedItem() == "Wednesday")
				{
					tempE.setDay(3);
				}
				if(days.getSelectedItem() == "Thursday")
				{
					tempE.setDay(4);
				}
				if(days.getSelectedItem() == "Friday")
				{
					tempE.setDay(5);
				}
				if(days.getSelectedItem() == "Saturday")
				{
					tempE.setDay(6);
				}
				tempE.setStartHour(hmodel.getNumber().intValue());
				tempE.setStartMinute(mmodel.getNumber().intValue());
				tempE.setEndHour(ehmodel.getNumber().intValue());
				tempE.setEndMinute(emmodel.getNumber().intValue());
				tempE.setDescription(desc.getText());
				WeekDisplay.control.events.set(tabs.getSelectedIndex(), tempE);
			}
		};
		update.addActionListener(al3);
		
		JButton delete = new JButton("Delete");
		
		//Remove Button - Removes event, tab, and then saves document
		ActionListener al1;
		al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Component selected = tabs.getSelectedComponent();
				tabs.remove(selected);
				WeekDisplay.control.removeEvent(tabs.getSelectedIndex());
				System.out.println(tabs.getSelectedIndex());
				WeekDisplay.control.storeData();
				tabCounter--;
			}
		};
		delete.addActionListener(al1);

		panel.setPreferredSize(new Dimension(600,400));
		panel.add(label1);
		panel.add(name);
		panel.add(label2);
		panel.add(shours);
		panel.add(smins);
		panel.add(ehours);
		panel.add(emins);
		panel.add(save);
		panel.add(delete);
		panel.add(label3);
		panel.add(labeltime);
		panel.add(colors);
		panel.add(update);
		panel.add(label4);
		panel.add(days);
		panel.add(label5);
		panel.add(desc);
		label1.setBounds(10,10,50,20);
		name.setBounds(50,10,80,20);
		label2.setBounds(10,50,50,20);
		shours.setBounds(50,50,35,30);
		smins.setBounds(100,50,35,30);
		ehours.setBounds(160,50,35,30);
		emins.setBounds(210,50,35,30);
		labeltime.setBounds(90,55,200,25);
		label3.setBounds(10,90,50,20);
		colors.setBounds(50,90,80,20);
		update.setBounds(500,235,80,40);
		save.setBounds(500,10,80,40);
		delete.setBounds(500,280,80,40);
		label4.setBounds(10,130,50,20);
		days.setBounds(50,130,80,20);
		label5.setBounds(10,170,80,20);
		desc.setBounds(90,170,200,80);
		if(c1.equals(Color.BLACK))
		{
			colors.setSelectedIndex(0);
		}
		if(c1.equals(Color.BLUE))
		{
			colors.setSelectedIndex(1);
		}
		if(c1.equals(Color.GREEN))
		{
			colors.setSelectedIndex(2);
		}
		if(c1.equals(Color.RED))
		{
			colors.setSelectedIndex(3);
		}
		if(c1.equals(Color.WHITE))
		{
			colors.setSelectedIndex(4);
		}
		days.setSelectedIndex(d1);
		return panel;
	}
	  
//	public static void main(String[] args) {
//		AddEventDisplay aTester = new AddEventDisplay();
//		aTester.tabSetUp();
//		aTester.frameSetUp();
//	}
}
