package code.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.PosSystem;

public class POSGUI implements Runnable, Observer {

	private static PosSystem system;
	private static JFrame window;
	private static JPanel infoPanel;
	private static JPanel inputPanel;
	
	public POSGUI(){
		system = new PosSystem();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new POSGUI());
	}
	
	@Override
	public void run() {
		buildMainView();
	}

	@Override
	public void update(java.util.Observable o, Object window) {
	}
	
	public JMenuBar buildMenuBar(){
		
		JMenuBar menuBar = new JMenuBar();
			
		//Creating Menus 
			JMenu mainMenu, userMenu, orderingMenu, newOrderSubmenu;
			mainMenu = new JMenu("Main Menu");
			userMenu = new JMenu("User Options");
			orderingMenu = new JMenu("Ordering Options");
		
		//sub Menus
			newOrderSubmenu = new JMenu("New Order");
			
		//Creating Options
			JMenuItem exit = new JMenuItem("Exit");
			JMenuItem addUser = new JMenuItem("Add User");
			addUser.addActionListener(new AddUserButtonHandler(system, this));

			JMenuItem listUsers = new JMenuItem("List Users");
			JMenuItem existingCustomer = new JMenuItem("Existing Customer");
			JMenuItem newCustomer = new JMenuItem("New Customer");
		
		//Add Items to the menus
			
			mainMenu.add(exit);
			userMenu.add(addUser);
			userMenu.add(listUsers);
			orderingMenu.add(newOrderSubmenu);
			newOrderSubmenu.add(newCustomer);
			newOrderSubmenu.add(existingCustomer);
			
		//add menus to menuBar
			menuBar.add(mainMenu);
			menuBar.add(userMenu);
			menuBar.add(orderingMenu);
	
		
		return menuBar;
	}
	
	public void buildMainView(){
		window = new JFrame("POS System");
		window.setResizable(false);
		infoPanel = new JPanel();
		inputPanel = new JPanel();
		Dimension d = new Dimension(800,240);
		getInfoPanel().setPreferredSize(d);
		getInfoPanel().setBackground(Color.BLACK);
		inputPanel.setPreferredSize(d);
		inputPanel.setBackground(Color.GRAY);
		window.add(buildMenuBar(), BorderLayout.NORTH);
		window.add(getInfoPanel(), BorderLayout.CENTER);
		window.add(inputPanel, BorderLayout.SOUTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}

	public static JPanel getInfoPanel() {
		return infoPanel;
	}
		
}
