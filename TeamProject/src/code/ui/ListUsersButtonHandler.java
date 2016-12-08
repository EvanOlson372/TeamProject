package code.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.PosSystem;

public class ListUsersButtonHandler implements ActionListener {

	private PosSystem system;
	private POSGUI ui;
	private ArrayList<JLabel> jlabels;
	
	public ListUsersButtonHandler(PosSystem system, POSGUI ui){
		this.system = system;
		this.ui = ui;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel listUsersPanel = new JPanel();
		Dimension d = new Dimension(790,480);
		listUsersPanel.setLayout(new BoxLayout(listUsersPanel, BoxLayout.Y_AXIS));
		listUsersPanel.setPreferredSize(d);
		//create and add JLabels
		for(int i = 1; i<=system.getUserIDs();i++){
			listUsersPanel.add(new JLabel("User ID: "+i+" Username: "+system.getUsers().get(i).getUsername()));
		}
		ui.changeDisplay(listUsersPanel);
	}

}
