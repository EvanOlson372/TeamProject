import java.util.ArrayList;

public class Order {
	
	private int orderNumber;
	private Customer customer;
	private ArrayList<Item> items;
	private double total;
	private int totalItems;
	
	public Order() {
		items = new ArrayList<Item>();
		totalItems = 0;
	}
	
	public void addItem(String name, double price){
		totalItems++;
		Item item = new Item(name,price);
		items.add(item);
		item.setNumber(totalItems);
	}
	public void setOrderNumber(int orderNumber){
		this.orderNumber = orderNumber;
	}
	
	public void showOrder(){
		for(int i = 0;i<items.size();i++){
			System.out.println("Item: " + items.get(i).getNumber() + ", " + items.get(i).getName() + ", Price: " + items.get(i).getPrice() );
			
		}
		
	}
	
}
