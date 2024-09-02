package Models;

public class Admin extends User{
	public Admin ( String Name, String Email, String Password) {
		super( Name, Email, Password, "Admin");
	}	
}
