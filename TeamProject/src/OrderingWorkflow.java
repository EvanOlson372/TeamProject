import java.util.Scanner;

public class OrderingWorkflow {
	
	private PosSystem system;
	private Customer workingCustomer;
	private Order workingOrder;
	private Order returnOrder;
	
	public OrderingWorkflow(PosSystem system){
		this.system = system;
		workingCustomer  = null;
		workingOrder = null;
		
	}
	
	public Order orderCreationMenu(){
		Scanner scanner = new Scanner(System.in);
		
		while (workingCustomer == null) {
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
				break;
			
			case "2":
				System.out.print("Please enter a phone number: ");
				String number1 = scanner.nextLine();
				if (system.lookupCustomer(number1) != null){
					Customer customer = system.lookupCustomer(number1);
					workingCustomer = customer;
					System.out.println("Customer Found!");
					customer.showCustomer();
				system.lookupCustomer(number1);
				}
				else
					System.out.println("Customer not found...");
				break;
			
			default:
				System.out.println("Invalid Entry.");
				break;
			
			}
		}
		
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
					returnOrder = workingOrder;
					workingOrder = null;
					workingCustomer = null;
					return returnOrder;
				}
				else
					System.out.println("You have not created an order...");
			default:
				System.out.println("Invalid Entry.");
			}
		
		}
	}
	
	
	
	
}
