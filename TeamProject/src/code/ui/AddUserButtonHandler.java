package code.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import code.PosSystem;

public class AddUserButtonHandler implements ActionListener {
	
	private static PosSystem system;
	private static POSGUI ui;
	public AddUserButtonHandler(PosSystem system, POSGUI ui){
		this.system = system;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		buildUserAddPanel();
		
	}
	
	public void buildUserAddPanel(){
		JPanel userAddPanel = new JPanel();
		
		JTextField inputBox = new JTextField(25);
		userAddPanel.add(new JLabel("Please Enter a Username: "));
		
		Dimension d = new Dimension(790,230);
		userAddPanel.setPreferredSize(d);
		userAddPanel.add(inputBox);
		userAddPanel.setBackground(Color.GRAY);
		ui.getInfoPanel().add(userAddPanel);
		ui.getInfoPanel().revalidate();
	}

	
	
}
