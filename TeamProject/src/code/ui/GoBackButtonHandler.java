package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoBackButtonHandler implements ActionListener {

	private POSGUI ui;
	
	public GoBackButtonHandler(POSGUI ui){
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent paramActionEvent) {
		System.out.println("Here");
		ui.setCurrentPanel(ui.getMainPanel());
		System.out.println("Here1");
		ui.getMainPanel().removeAll();
		System.out.println("Here2");
		ui.getMainPanel().add(ui.getMainPanel());
		System.out.println("Here3");
		ui.getMainPanel().revalidate();
		System.out.println("Here4");

	}

}
