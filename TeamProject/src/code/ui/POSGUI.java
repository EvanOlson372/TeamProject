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
import java.util.Stack;

import javax.swing.JButton;
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
	private static JPanel mainPanel;
	private static JPanel displayPanel;
	private JPanel currentPanel;
	private static Stack<JPanel> panelStack;
	
	
	public POSGUI(){
		system = new PosSystem();
		panelStack = new Stack<JPanel>();
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
			addUser.addActionListener(new AddUserMenuButtonHandler(system, this));

			JMenuItem listUsers = new JMenuItem("List Users");
			listUsers.addActionListener(new ListUsersButtonHandler(system,this));
			JMenuItem existingCustomer = new JMenuItem("Existing Customer");
			existingCustomer.addActionListener(new ExistingCustomerMenuButtonHandler(system,this));
			JMenuItem newCustomer = new JMenuItem("New Customer");
			newCustomer.addActionListener(new AddCustomerMenuButtonHandler(system, this));
		
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
			
			JButton backButton = new JButton("Back");
			backButton.addActionListener(new GoBackButtonHandler(this));
			menuBar.add(backButton);
		
		return menuBar;
	}
	
	public void buildMainView(){
		//Build main JFrame
			window = new JFrame("POS System");
			window.setResizable(false);
		//Build Main and display panel
			Dimension d = new Dimension(790,460);
			mainPanel = new JPanel();
			mainPanel.setPreferredSize(d);
			mainPanel.setBackground(Color.GRAY);
			displayPanel = new JPanel();
			displayPanel.setPreferredSize(d);
			displayPanel.setBackground(Color.GRAY);
		//Push Display Panel to stack
			panelStack.push(displayPanel);
			currentPanel = displayPanel;
		//Add Display Panel to the main panel
			mainPanel.add(displayPanel);
		//Add menu and main panel to the window
			window.add(buildMenuBar(), BorderLayout.NORTH);
			window.add(mainPanel, BorderLayout.CENTER);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.pack();
			window.setVisible(true);
	}

	public Stack<JPanel> getPanelStack(){
		return panelStack;
	}
	
	public void setCurrentPanel(JPanel currentPanel){
		this.currentPanel = currentPanel;
	}
	public JPanel getCurrentPanel(){
		return currentPanel;
	}
	
	public JPanel getMainPanel(){
		return mainPanel;
	}
	
	public void changeDisplay(JPanel panel){
		//push current to stack and set new current
			panelStack.push(currentPanel);
			setCurrentPanel(panel);
		//remove all and add
			mainPanel.removeAll();
			mainPanel.add(panel);
			mainPanel.revalidate();
			mainPanel.repaint();
	}
	

}
