package code;
import java.util.ArrayList;

public class Order {
	
	private int orderNumber;
	private Customer customer;
	private ArrayList<Item> items;
	private double total;
	private double ammountPaid;
	private int totalItems;
	private boolean paid; 
	
	public Order() {
		items = new ArrayList<Item>();
		total = 0.0;
		totalItems = 0;
		paid = false;
	}
	
	public void addItem(String name, double price){
		totalItems++;
		Item item = new Item(name,price);
		items.add(item);
		item.setNumber(totalItems);
		total = total + price;
	}
	public void setOrderNumber(int orderNumber){
		this.orderNumber = orderNumber;
	}
	
	public void showOrder(){
		for(int i = 0;i<items.size();i++){
			System.out.println("Item: " + items.get(i).getNumber() + ", " + items.get(i).getName() + ":\t Price: $" + items.get(i).getPrice() );
		}
			System.out.println("\t\t\t Total: $"+total);
			System.out.println("\t\t   With Tax: $"+(total+processTax()));
	}
	
	public double getTotal(){
		return total;
	}
	
	public double processTax(){
		double tmp = total;
		tmp = tmp * .08;
		return tmp;
	}
	
	public double getTotalwithTax(){
		double tmp;
		tmp = (processTax() + getTotal());
		return tmp;
	}
	
	public double processPayment(double ammountPaid){
		this.ammountPaid = ammountPaid;
		total = total + processTax();
		double change = ammountPaid - total;
		return change;
	}
	
	public void loadTotal(String total){
		this.total = Double.parseDouble(total);
	}
	public void loadNumberOfItems(String totalItems){
		this.totalItems = Integer.parseInt(totalItems);
	}
	public ArrayList<Item> getItemList(){
		return items;
	}
		
	
}
