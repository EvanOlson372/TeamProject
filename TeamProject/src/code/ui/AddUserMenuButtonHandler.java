package code.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import code.PosSystem;

public class AddUserMenuButtonHandler implements ActionListener {
	
	private static PosSystem system;
	private static POSGUI ui;
	private JTextField inputBox;
	
	public AddUserMenuButtonHandler(PosSystem system, POSGUI ui){
		this.system = system;
		this.ui = ui;
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
			buildUserAddPanel();
	
		
	}
	
	public void buildUserAddPanel() {
		JPanel userAddPanel = new JPanel();
		
		inputBox = new JTextField(25);
		userAddPanel.add(new JLabel("Please Enter a Username: "));
		JButton addUser = new JButton("Add User");
		addUser.addActionListener(new AddUserButtonHandler(system, inputBox));
		
		Dimension d = new Dimension(790,230);
		userAddPanel.setPreferredSize(d);
		userAddPanel.add(inputBox);
		userAddPanel.add(addUser);
		userAddPanel.setBackground(Color.GRAY);
		ui.getInfoPanel().add(userAddPanel);
		
		ui.getInfoPanel().revalidate();
	/*	System.out.println("Got Here");
		ui.getInfoPanel().removeAll();
		System.out.println("Removed Panels");
	*/	
	}
	
	public JTextField getInputBox(){
		return inputBox;
	}

	
	
}