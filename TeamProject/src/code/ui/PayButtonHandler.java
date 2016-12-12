package code.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.PosSystem;

public class PayButtonHandler implements ActionListener {
	
	POSGUI ui;
	PosSystem system;
	JTextField input;
	
	PayButtonHandler(PosSystem system, POSGUI ui, JTextField input){
		this.system = system;
		this.ui = ui;
		this.input = input;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(true){
			
			double tmp = Double.parseDouble(input.getText());
				
			if(tmp<(system.getWorkingOrder().getTotal()+system.getWorkingOrder().processTax())){
					JPanel lowPayment = new JPanel();
					lowPayment.setPreferredSize(new Dimension(800, 300));
					lowPayment.setBackground(Color.GRAY);
					lowPayment.setLayout(new BorderLayout());
					JLabel low = new JLabel("Payment is less than the Ammount Due.  Please try again.");
					JButton tryAgain = new JButton("Try Again");
					tryAgain.addActionListener(new GoBackButtonHandler(ui));
					lowPayment.add(low, BorderLayout.NORTH);
					lowPayment.add(tryAgain, BorderLayout.SOUTH);
					ui.changeDisplay(lowPayment);
					return;
				}
				else{
				
					JPanel goodPayment = new JPanel();
					goodPayment.setPreferredSize(new Dimension(800, 300));
					goodPayment.setBackground(Color.GRAY);
					goodPayment.setLayout(new BorderLayout());
					JLabel low = new JLabel("Payment has been processed.");
					JLabel change = new JLabel("Change due: "+system.getWorkingOrder().processPayment(tmp));
					goodPayment.add(low, BorderLayout.NORTH);
					goodPayment.add(change, BorderLayout.SOUTH);
					ui.changeDisplay(goodPayment);
					system.resetOrder();
					return;
				}
		}

	}

}
