package code.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import code.PosSystem;

public class AddCustomerButtonHandler implements ActionListener {

	private PosSystem system;
	private JTextField name, number;
	private POSGUI ui;
	
	public AddCustomerButtonHandler(PosSystem system, JTextField name, JTextField number, POSGUI ui) {
		this.system = system;
		this.name = name;
		this.number = number;
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//add Customer
		system.addCustomer(name.getText(), number.getText());;
		//build new panel
		JPanel postCustomerAddPanel = new JPanel();
		Dimension d = new Dimension(790,480);
		postCustomerAddPanel.setPreferredSize(d);
		postCustomerAddPanel.setBackground(Color.GRAY);
		JLabel Output = new JLabel("Customer "+ name.getText()+ " added with an phone number of: " +number.getText());
		postCustomerAddPanel.add(Output);
		ui.changeDisplay(postCustomerAddPanel);
		
	}

}
