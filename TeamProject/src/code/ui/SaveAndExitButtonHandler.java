package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import code.PosSystem;

public class SaveAndExitButtonHandler implements ActionListener {
	
	private PosSystem system;
	
	public SaveAndExitButtonHandler(PosSystem system){
		this.system = system;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			system.saveState();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.exit(0);
		
	}
	
	

}
