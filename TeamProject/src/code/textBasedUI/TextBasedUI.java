package code.textBasedUI;
import java.util.Scanner;

import code.PosSystem;
import code.User;


public class TextBasedUI implements Runnable {

	private static User currentUser = null;
	private static PosSystem system;
	private static TextBasedOrderingWorkflow ordering;
	
	public TextBasedUI() {
		system = new PosSystem();
		ordering = new TextBasedOrderingWorkflow(system);
	}
	

	public void run(){
		Scanner scanner = new Scanner(System.in);
		if(currentUser == null){
			System.out.println("+++++++++++++++++++++++++++++++++ POS +++++++++++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++ Initial Launch +++++++++++++++++++++++++++++++++++");
			System.out.print("\nPlease add the first User:");
			String input = scanner.nextLine();
			system.addUser(input);
		}
		
		while (true) {
			System.out.println("+++++++++++++++++++++++++++++++++ POS +++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++ MENU ++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\n                              (1) Add User");
			System.out.println("\n                              (2) User List");
			System.out.println("\n                              (3) New Order");
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

			System.out.print("Please enter your selection here:");
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				System.out.print("Please enter a username: ");
				String username = scanner.nextLine();
				system.addUser(username);
				break;
			case "2":
				system.showUsers();
				break;
			case "3":
				ordering.selectCustomer();
				ordering.buildOrder();
				ordering.orderOptions();
				break;
			default:
				System.out.println("Invalid Entry.");
				break;
			
			}
			
			
		}

	}

}

