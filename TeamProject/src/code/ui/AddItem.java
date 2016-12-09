package code.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.PosSystem;

public class AddItem implements ActionListener {
	
	private PosSystem system;
	private JPanel itemListPanel, totalPanel;
	private JTextField item, price;
	
	public AddItem(PosSystem system, JPanel itemListPanel, JPanel totalPanel, JTextField item, JTextField price){
		this.system = system;
		this.itemListPanel = itemListPanel;
		this.totalPanel = totalPanel;
		this.item = item;
		this.price = price;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double tmp = Double.parseDouble(price.getText());
		system.getWorkingOrder().addItem(item.getText(), tmp);
		JLabel output = new JLabel("Item: "+item.getText()+" Price: "+tmp);
		JLabel total = new JLabel("Total: $"+system.getWorkingOrder().getTotal());
		JLabel tax = new JLabel("Tax: $"+system.getWorkingOrder().processTax());
		JLabel totalWithTax = new JLabel("Total with Tax: $"+(system.getWorkingOrder().getTotalwithTax()));
		total.setFont(new Font("Times",Font.BOLD,18));
		tax.setFont(new Font("Times",Font.BOLD,18));
		totalWithTax.setFont(new Font("Times",Font.BOLD,18));
		price.setText("");
		item.setText("");
		totalPanel.removeAll();
		totalPanel.add(total, BorderLayout.CENTER);
		totalPanel.add(tax, BorderLayout.CENTER);
		totalPanel.add(totalWithTax, BorderLayout.CENTER);
		totalPanel.revalidate();
		totalPanel.repaint();
		itemListPanel.add(output);
		itemListPanel.revalidate();
		itemListPanel.repaint();
		
	}

}
