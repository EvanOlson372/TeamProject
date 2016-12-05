import java.util.ArrayList;

public class Customer {
	
	private ArrayList<Integer> orderNumbers;
	private String name;
	private int customerID;
	private String phoneNumber;

	public Customer(String name, String phoneNumber){
		orderNumbers = new ArrayList<Integer>();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void addOrder(int orderNumber){
		orderNumbers.add(orderNumber);
	}
	
	public void setID(int customerID){
		this.customerID = customerID;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCustomerID(){
		return customerID;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void showCustomer(){
		System.out.println("Customer: " + customerID + " " + name + " Phone Number: " + phoneNumber );
		
	}
	
}
