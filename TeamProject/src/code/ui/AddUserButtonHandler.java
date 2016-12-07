package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import code.PosSystem;

public class AddUserButtonHandler implements ActionListener {

	private PosSystem system;
	private JTextField inputBox;
	
	public AddUserButtonHandler(PosSystem system, JTextField inputBox){
		this.system = system;
		this.inputBox = inputBox;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println();
		system.addUser(inputBox.getText());
	}

	
	
	
}
