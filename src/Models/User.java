package Models;

public class User {
	private int Id;
	private String Name;
	private String Email;
	private String Password;
	private String Role;
	
	public User (int Id, String Name,String Email, String Password, String Role) {
		this.Id = Id;
		this.Name = Name;
		this.Email = Email;
		this.Password = Password;
		this.Role = Role;
	}
	 public int getId() {
	        return Id;
	    }

	    public void setId(int Id) {
	        this.Id = Id;
	    }

	    public String getName() {
	        return Name;
	    }

	    public void setName(String Name) {
	        this.Name = Name;
	    }

	    public String getEmail() {
	        return Email;
	    }

	    public void setEmail(String Email) {
	        this.Email = Email;
	    }

	    public String getPassword() {
	        return Password;
	    }

	    public void setPassword(String Password) {
	        this.Password = Password;
	    }

	    public String getRole() {
	        return Role;
	    }

	    public void setRole(String Role) {
	        this.Role = Role;
	    }
}
