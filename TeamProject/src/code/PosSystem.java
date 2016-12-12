package code;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class PosSystem {

	private Hashtable<Integer, User> users;
	private Hashtable<Integer, Order> orders;
	private Hashtable<String, Customer> customers;
	private int totalOrders;
	private int customerIDs;
	private int userIDs;
	private Customer workingCustomer;
	private Order workingOrder;
	
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
	
	public int getUserIDs(){
		return userIDs;
	}
	
	public int getCustomerIDs(){
		return customerIDs;
	}
	
	public Hashtable<Integer, User> getUsers(){
		return users;
	}
	public void setWorkingCustomer(Customer workingCustomer){
		this.workingCustomer = workingCustomer;
	}
	public void setWorkingOrder(Order workingOrder){
		this.workingOrder = workingOrder;
	}
	
	public Customer getWorkingCustomer(){
		return workingCustomer;
	}
	
	public Order getWorkingOrder(){
		return workingOrder;
	}
	public void resetOrder(){
		workingOrder = null;
	}
	
	public void saveState() throws IOException{
		File file = new File("State.csv");
		
		if(file.exists()){
			System.out.println("File is here.  Removing and creating new.");
			file.createNewFile();
		}
	
		FileWriter writer = new FileWriter("State.csv");
		
		//Save customers
		
			Set<String> custKeys = customers.keySet();
			for(String key: custKeys){
				Customer tmpCustomer = customers.get(key);
				//writer.append("\n");
				writer.append(Integer.toString(tmpCustomer.getCustomerID()));
				writer.append(",");
				writer.append(tmpCustomer.getName());
				writer.append(",");
				writer.append(tmpCustomer.getPhoneNumber());
				writer.append("\n");
			}
				writer.append("\n\n");
			
			
		//Save Orders
			
			Set<Integer> orderKeys = orders.keySet();
			for(Integer key: orderKeys){
				Order tmpOrder = orders.get(key);
				writer.append(Integer.toString(key));
				writer.append(",");
				writer.append(Double.toString(tmpOrder.getTotal()));
				writer.append(",");
				
				for(int i = 0; i<tmpOrder.getItemList().size(); i++){
					writer.append(tmpOrder.getItemList().get(i).getName());
					writer.append(",");
					writer.append(Double.toString(tmpOrder.getItemList().get(i).getPrice()));
					writer.append(",");
				}
				writer.append("\n");
			}
			writer.append("\n");
		
		//Save User
			
			Set<Integer> userKeys = users.keySet();
			for(Integer key: userKeys){
				User tmpUser = users.get(key);
				
				writer.append(Integer.toString(key));
				writer.append(",");
				writer.append(tmpUser.getUsername());
				writer.append("\n\n");
			
			}
			
			
			
			writer.flush();
			writer.close();
		
		
	}
	
	public void loadState() throws IOException{
		
		File file = new File("State.csv");
		
		if(file.exists()){
			System.out.println("File is here.  Loading...");
			BufferedReader br = new BufferedReader(new FileReader("State.csv"));
			String line;
			String csvSplitBy = ",";
			
			//load Customers
			
			while((line = br.readLine()) != null){
				String[] customer = line.split(csvSplitBy);
				if(customer.length == 0)
					break;
				addCustomer(customer[1], customer[2]);
			}
			
			//Load Orders
			
			while((line = br.readLine()) != null){
				String[] order = line.split(csvSplitBy);
				
				if(order.length == 0)
					break;
				Order tmpOrder = new Order();
				tmpOrder.setOrderNumber(Integer.parseInt(order[0]));
				tmpOrder.loadTotal(order[1]);
				int i = 2;
				
				while(true){
					if(i>=order.length)
						break;
					tmpOrder.addItem(order[i], Double.parseDouble(order[i+1]));
					i+=2;
				}
				addOrder(tmpOrder);
			}
			
			//Load User
			
			while((line = br.readLine()) != null){
				String[] user = line.split(csvSplitBy);
				if(user.length == 0)
				break;
				addUser(user[1]);
			}
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
}
