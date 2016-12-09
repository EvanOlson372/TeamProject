package code.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.PosSystem;

public class AddCustomerMenuButtonHandler implements ActionListener {

	private static PosSystem system;
	private static POSGUI ui;
	private JTextField name, number;
	
	public AddCustomerMenuButtonHandler(PosSystem system, POSGUI ui){
		this.system = system;
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JPanel customerAddPanel = new JPanel();
		customerAddPanel.setLayout(new BoxLayout(customerAddPanel, BoxLayout.Y_AXIS));
		name = new JTextField(25);
		number = new JTextField(25);
		customerAddPanel.add(new JLabel("Please Enter the customers name: "));
		customerAddPanel.add(name);
		customerAddPanel.add(new JLabel("Please Enter the customers Phone Number: "));
		customerAddPanel.add(number);
		JButton addCustomer = new JButton("Add Customer");
		addCustomer.addActionListener(new AddCustomerButtonHandler(system, name, number, ui));
		customerAddPanel.add(addCustomer);
		Dimension d = new Dimension(790,120);
		customerAddPanel.setPreferredSize(d);

		customerAddPanel.setBackground(Color.GRAY);
		ui.changeDisplay(customerAddPanel);
		
	}
	
	
	
}
