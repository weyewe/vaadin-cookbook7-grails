package app.chapter2.bean

public class Contact {
	String firstName
	String lastName
	String email
	
	public Contact(String firstName, String lastName, String email) {
		this.firstName = firstName
		this.lastName = lastName
		this.email = email 
	}
	
	public String getFullName() {
		return firstName + " " + lastName
	}
	
	

}
