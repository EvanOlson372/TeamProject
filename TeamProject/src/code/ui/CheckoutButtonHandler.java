package code.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.PosSystem;

public class CheckoutButtonHandler implements ActionListener {
	
	JPanel checkoutPanel;
	JPanel inputPanel;
	JTextField payment;
	JButton pay;
	PosSystem system;
	POSGUI ui;
	
	public CheckoutButtonHandler(PosSystem system, POSGUI ui){
		this.system = system;
		this.ui = ui;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		checkoutPanel = new JPanel();
		inputPanel = new JPanel();
		checkoutPanel.setPreferredSize(new Dimension(800, 180));
		checkoutPanel.setBackground(Color.GRAY);
		checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.Y_AXIS));
		inputPanel.setPreferredSize(new Dimension(800, 60));
		inputPanel.setBackground(Color.GRAY);
		inputPanel.setLayout(new FlowLayout());
		JLabel inputLabel = new JLabel("Payment: ");
		JLabel total = new JLabel("Total: $"+system.getWorkingOrder().getTotal());
		JLabel tax = new JLabel("Tax: $"+system.getWorkingOrder().processTax());
		JLabel totalWithTax = new JLabel("Ammount due: $"+(system.getWorkingOrder().getTotalwithTax()));
		total.setFont(new Font("Times",Font.BOLD,18));
		tax.setFont(new Font("Times",Font.BOLD,18));
		totalWithTax.setFont(new Font("Times",Font.BOLD,18));
		payment = new JTextField(15);
		pay = new JButton("Pay");
		pay.addActionListener(new PayButtonHandler(system, ui, payment));
		checkoutPanel.add(total);
		checkoutPanel.add(tax);
		checkoutPanel.add(totalWithTax);
		inputPanel.add(inputLabel);
		inputPanel.add(payment);
		inputPanel.add(pay);
		checkoutPanel.add(inputPanel);
		
		ui.changeDisplay(checkoutPanel);
		
		
		
		
		
	}

}
