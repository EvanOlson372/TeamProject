package code;

public class Item {

	private int itemNumber;
	private double price;
	private String name;
	
	public Item(String name, double price){
		this.name = name;
		this.price = price;
		
	}
	
	public void setNumber(int itemNumber){
		this.itemNumber = itemNumber;
	}
	
	public int getNumber(){
		return itemNumber;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
}
