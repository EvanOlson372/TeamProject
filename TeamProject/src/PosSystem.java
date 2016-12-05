import java.util.ArrayList;
import java.util.Hashtable;

public class PosSystem {

	private Hashtable<Integer, User> users;
	private Hashtable<Integer, Order> orders;
	private Hashtable<String, Customer> customers;
	private int totalOrders;
	private int customerIDs;
	private int userIDs;
	
	public PosSystem(){
		users = new Hashtable<Integer, User>();
		orders = new Hashtable<Integer, Order>();
		customers = new Hashtable<String, Customer>();
		customerIDs = 0;
		totalOrders = 0;
		userIDs = 0;
	}
	
	public void addOrder(Order order){
		totalOrders++;
		order.setOrderNumber(totalOrders);
		orders.put(totalOrders, order);
	}
	
	public void addUser(String username){
		userIDs++;
		User user = new User(username, userIDs);
		users.put(userIDs, user);
		System.out.println("User "+users.get(userIDs).getUsername()+" has been created with and ID of: "+ userIDs);
	}
	
	public void addCustomer(String customerName, String number){
		customerIDs++;
		Customer customer = new Customer(customerName, number);
		customer.setID(customerIDs);
		customers.put(number, customer);
		System.out.println("Customer: "+ customers.get(number).getName() + " has been created with an ID of " + customerIDs);
	}
	
	public Customer lookupCustomer(String number){
		return customers.get(number);
	}
	
	public void showUsers(){
		System.out.println("+++++++++++++++++++++++++++++++User List ++++++++++++++++++++++++++++++++++++++");
		for(int i = 1; i<=userIDs;i++){
			System.out.println("UserID: "+ users.get(i).getUserID() + " Username: " + users.get(i).getUsername() );
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
}
