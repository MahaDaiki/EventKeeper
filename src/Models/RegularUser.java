package Models;

public class RegularUser extends User {
	public RegularUser (int Id, String Name, String Email, String Password) {
		super(Id, Name, Email, Password, "RegularUser");
	}
}
