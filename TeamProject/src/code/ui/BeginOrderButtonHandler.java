package code.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.Order;
import code.PosSystem;

public class BeginOrderButtonHandler implements ActionListener {

	JPanel mainOrderingPanel;
	JPanel itemListPanel;
	JPanel totalPanel;
	JPanel inputPanel;
	JPanel leftPanel;
	JPanel rightPanel;
	JPanel buttonPanel;
	JTextField item;
	JTextField price;
	PosSystem system;
	POSGUI ui;
	
	public BeginOrderButtonHandler(PosSystem system, POSGUI ui){
		this.system = system;
		this.ui = ui;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(system.getWorkingOrder() == null){
			system.setWorkingOrder((new Order()));
			system.addOrder(system.getWorkingOrder());
			System.out.println(system.getWorkingOrder());
			System.out.println(system.getWorkingCustomer());
		}
		
		
		
		
		
		//Main Panel
			mainOrderingPanel = new JPanel();
			mainOrderingPanel.setPreferredSize(new Dimension(850, 530));
		//Left and Right Panels
			leftPanel = new JPanel();
			rightPanel = new JPanel();
		//DisplayPanels
			itemListPanel = new JPanel();
			totalPanel = new JPanel();
			inputPanel = new JPanel();
		
		//Set Dimensions 	
			leftPanel.setPreferredSize(new Dimension(400,460));
			rightPanel.setPreferredSize(new Dimension(400,460));
			inputPanel.setPreferredSize(new Dimension(380,120));
			itemListPanel.setPreferredSize(new Dimension(400,470));
			itemListPanel.setLayout(new BoxLayout(itemListPanel, BoxLayout.Y_AXIS));
			totalPanel.setPreferredSize(new Dimension(400,280));
			totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.Y_AXIS));
		//Set Background colors
			inputPanel.setBackground(Color.GRAY);
			itemListPanel.setBackground(Color.GRAY);
			totalPanel.setBackground(Color.GRAY);
		//add main panels
			mainOrderingPanel.add(leftPanel);
			mainOrderingPanel.add(rightPanel);
		//add to right and left
			rightPanel.add(totalPanel, BorderLayout.NORTH);
			rightPanel.add(inputPanel, BorderLayout.SOUTH);
			leftPanel.add(itemListPanel);
		//Create Button Panel
			buttonPanel = new JPanel();
			buttonPanel.setPreferredSize(new Dimension(400,40));
			buttonPanel.setLayout(new BorderLayout());
		//Add input Boxes
			
			JLabel inputItem = new JLabel("Item: ");
			JTextField item = new JTextField(15);
			JLabel inputPrice = new JLabel("Price: ");
			JTextField price = new JTextField(15);
			JButton addItem = new JButton("Add Item");
			JButton checkout = new JButton("Checkout");
			checkout.addActionListener(new CheckoutButtonHandler(system, ui));
			addItem.addActionListener(new AddItem(system, itemListPanel, totalPanel, item, price));
			buttonPanel.add(addItem, BorderLayout.WEST);
			buttonPanel.add(checkout, BorderLayout.EAST);
			inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
			inputPanel.add(inputItem);
			inputPanel.add(item);
			inputPanel.add(inputPrice);
			inputPanel.add(price);
			inputPanel.add(buttonPanel);
			
			
			//inputPanel.add(checkout);
			//inputPanel.add(addItem);
			
			
			
			//change display
		ui.changeDisplay(mainOrderingPanel);
		
		
	}

}
