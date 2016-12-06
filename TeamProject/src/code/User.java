package code;


public class User {

	private String username;
	private int userID;
	
	public User(String username, int userID){
		this.username = username;
		this.userID = userID;
	}
	
	public String getUsername(){
		return username;
	}
	public int getUserID(){
		return userID;
	}
	
	
}
