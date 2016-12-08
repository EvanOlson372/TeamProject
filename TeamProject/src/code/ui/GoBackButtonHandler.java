package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GoBackButtonHandler implements ActionListener {

	private POSGUI ui;
	
	public GoBackButtonHandler(POSGUI ui){
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent paramActionEvent) {
		
		if(ui.getPanelStack().size() > 1){
			JPanel temp = ui.getPanelStack().pop();
			ui.setCurrentPanel(temp);
			ui.getMainPanel().removeAll();
			ui.getMainPanel().add(ui.getCurrentPanel());
			ui.getMainPanel().revalidate();
			ui.getMainPanel().repaint();
		}
	}

}
