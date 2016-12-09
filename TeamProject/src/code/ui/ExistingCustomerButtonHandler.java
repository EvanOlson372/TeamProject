package code.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import code.PosSystem;

public class ExistingCustomerButtonHandler implements ActionListener {

	private PosSystem system;
	private JTextField number;
	private POSGUI ui;
	
	public ExistingCustomerButtonHandler(PosSystem system, JTextField number, POSGUI ui) {
		this.system = system;
		this.number = number;
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//search Customer
		
		JLabel Output;
		if(system.lookupCustomer(number.getText()) != null){
			Output = new JLabel("Customer "+ system.lookupCustomer(number.getText()).getName()+ " was found with a phone number of " +number.getText());
			system.setWorkingCustomer(system.lookupCustomer(number.getText()));
		}
		else{
			Output = new JLabel("No customer was found with this number.");
		}
				
		//build new panel
		JPanel postCustomerAddPanel = new JPanel();
		Dimension d = new Dimension(790,480);
		postCustomerAddPanel.setPreferredSize(d);
		postCustomerAddPanel.setBackground(Color.GRAY);
		postCustomerAddPanel.add(Output);
		ui.changeDisplay(postCustomerAddPanel);
		
	}

}
