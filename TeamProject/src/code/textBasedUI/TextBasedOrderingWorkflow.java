package code.textBasedUI;
import java.util.Scanner;

import code.Customer;
import code.Order;
import code.PosSystem;

public class TextBasedOrderingWorkflow {
	
	private PosSystem system;
	private Customer workingCustomer;
	private Order workingOrder;
	private Order returnOrder;
	
	public TextBasedOrderingWorkflow(PosSystem system){
		this.system = system;
		workingCustomer  = null;
		workingOrder = null;
		
	}
	
	public void selectCustomer(){
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("++++++++++++++++++++++++++++ Order Creation +++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++ MENU ++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\n                              (1) New Customer");
			System.out.println("\n                              (2) Existing Customer");
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

			System.out.print("Please enter your selection here:");
			String input = scanner.nextLine();
			
			switch (input) {
			
			case "1":
				System.out.print("Please enter the customers name:");
				String name  = scanner.nextLine();
				System.out.print("Please enter the customers phone number:");
				String number  = scanner.nextLine();
				system.addCustomer(name, number);
				workingCustomer = system.lookupCustomer(number);
				return;

			case "2":
				System.out.print("Please enter a phone number: ");
				String number1 = scanner.nextLine();
				if (system.lookupCustomer(number1) != null){
					Customer customer = system.lookupCustomer(number1);
					workingCustomer = customer;
					System.out.println("Customer Found!");
					customer.showCustomer();
					return;
				}
				else
					System.out.println("Customer not found...");
				break;
			
			default:
				System.out.println("Invalid Entry.");
				break;
			
			}
		}
		
	}
	
	
	public void buildOrder() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true){
			
			System.out.println("++++++++++++++++++++++++++++ Order Creation +++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++ MENU ++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\n                              (1) Add Item");
			System.out.println("\n                              (2) Remove Item");
			System.out.println("\n                              (3) Complete Order");
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			
			if(workingOrder != null){
				System.out.println("\n+++++++++++++++++++++++++++ Current Order +++++++++++++++++++++++++++++++++++++");
				workingOrder.showOrder();
			}
			
			System.out.print("Please enter your selection here:");
			String input = scanner.nextLine();
			
			switch (input) {
				
			case "1":
				
				if(workingOrder == null){
					workingOrder = new Order();
					system.addOrder(workingOrder);
				}
			
				System.out.print("Enter Item name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Item price: ");
				String price = scanner.nextLine();
				double tmp = Double.parseDouble(price);
				workingOrder.addItem(name, tmp);
				
				break;
				
			case "2":
				System.out.println("Not implemented...");
				break;
		
			case "3":
				if(workingOrder != null){
					return;
					//returnOrder = workingOrder;
					//workingOrder = null;
					//workingCustomer = null;
					//return returnOrder;
				}
				else{
					System.out.println("You have not created an order... Exiting");
				}
			default:
				System.out.println("Invalid Entry.");
			}
		
		}
		
	}
	
	
	public void orderOptions(){
		

		Scanner scanner = new Scanner(System.in);
		
		while (true){
			
			System.out.println("++++++++++++++++++++++++++++  Order Options +++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++ MENU ++++++++++++++++++++++++++++++++++++++++");
			System.out.println("\n                              (1) Save Order ");
			System.out.println("\n                              (2) Checkout");
			System.out.println("\n                              (3) Go back");
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			workingOrder.showOrder();
			
			System.out.print("Please enter your selection here:");
			String input = scanner.nextLine();
			
			switch (input) {
				
			case "1":
				return;
			
			case "2":
				while(true){
					System.out.print("Ammount due: "+ (workingOrder.getTotal()+workingOrder.processTax()));
					System.out.print("Enter payment:");
					String input1 = scanner.nextLine();
					double tmp = Double.parseDouble(input1);
						if(tmp<(workingOrder.getTotal()+workingOrder.processTax())){
							System.out.print("Payment is less than total, please enter a valit payment.");
						}
						else{
							workingOrder.processPayment(tmp);
							return;
						}
				}
				
			case "3":
				System.out.println("Backing up...");
				buildOrder();
			}
		
		}
	}
	
}
