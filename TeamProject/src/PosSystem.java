import java.util.ArrayList;
import java.util.Hashtable;

public class PosSystem {

	private Hashtable<Integer, User> users;
	private Hashtable<Integer, Order> orders;
	private int totalOrders;
	private int userIDs;
	
	public PosSystem(){
		users = new Hashtable<Integer, User>();
		orders = new Hashtable<Integer, Order>();
		totalOrders = 0;
		userIDs = 0;
	}
	
	public void addOrder(Order order){
		totalOrders++;
		orders.put(totalOrders, order);
	}
	
	public void addUser(String username){
		userIDs++;
		User user;
		user = new User(username, userIDs);
		users.put(userIDs, user);
		System.out.println("User "+users.get(userIDs).getUsername()+" has been created with and ID of: "+ userIDs);
	}
	
	public void showUsers(){
		System.out.println("+++++++++++++++++++++++++++++++User List ++++++++++++++++++++++++++++++++++++++");
		for(int i = 1; i<=userIDs;i++){
			System.out.println("UserID: "+ users.get(i).getUserID() + " Username: " + users.get(i).getUsername() );
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
}
