package code.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.PosSystem;

public class AddUserButtonHandler implements ActionListener {

	private PosSystem system;
	private JTextField inputBox;
	private POSGUI ui;
	
	public AddUserButtonHandler(PosSystem system, JTextField inputBox, POSGUI ui){
		this.system = system;
		this.inputBox = inputBox;
		this.ui = ui;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//add user
		system.addUser(inputBox.getText());
		//build new panel
		JPanel postUserAddPanel = new JPanel();
		Dimension d = new Dimension(790,230);
		postUserAddPanel.setPreferredSize(d);
		JLabel Output = new JLabel("User "+ inputBox.getText()+ " added with an ID of " +system.getlatestUserID());
		postUserAddPanel.add(Output);
		//push current to stack and set new current
		ui.getPanelStack().push(ui.getCurrentPanel());
		ui.setCurrentPanel(postUserAddPanel);
		//remove all and add
		ui.getMainPanel().removeAll();
		ui.getMainPanel().add(postUserAddPanel);
		ui.getMainPanel().revalidate();
		
	}

	
	
	
}
