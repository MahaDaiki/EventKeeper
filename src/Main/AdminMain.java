package Main;

import Models.Admin;
import Models.User;
import Services.UserService;

import Main.Main;

import java.util.Scanner;

public class AdminMain {
	
	private static UserService userservice = new UserService();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		 Admin admin = new Admin("Admin", "admin@mail.com", "password");
		AdminMenu(admin);
	}
	
	
	public static void AdminMenu(Admin admin) {
		while(true) {
			  System.out.println("Hello " + admin.getName() + ", Welcome Back!");
	            System.out.println("1. Manage Users");
	            System.out.println("2. Manage Events");
	            System.out.println("3. View Reports");
	            System.out.println("4. Logout");
	            System.out.print("- ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch (choice) {
	            case 1:
	            	ManageUsersMenu(admin);
	            	break;
	            case 2 :
	            	EventMain.ManageEventsMenu(admin);
	            	break;
	            case 3 :
	            	  ViewReports(admin);
	                    break;
	                case 4:
	                    System.out.println("GoodBye!!");
	                    return;
	                default:
	                    System.out.println("Invalid choice.");
	            }
		}
	
	}
	private static void ManageUsersMenu(Admin admin) {
        while (true) {
            System.out.println("Manage Users:");
            System.out.println("1. Add User");
            System.out.println("2. Modify User");
            System.out.println("3. Delete User");
            System.out.println("4. List All Users");
            System.out.println("5. <---- Back");
            System.out.print("- ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser(admin);
                    break;
                case 2:
                    modifyUser(admin);
                    break;
                case 3:
                    deleteUser(admin);
                    break;
                case 4:
                    listUsers(admin);
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
	 private static void addUser(Admin admin) {
	        System.out.print("Enter user name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter user email: ");
	        String email = scanner.nextLine();
	        System.out.print("Enter user password: ");
	        String password = scanner.nextLine();

	        User user = new User(name, email, password);
	        userservice.addUser(user, admin);
	    }

	    private static void modifyUser(Admin admin) {
	        System.out.print("Enter user ID to modify: ");
	        int userId = scanner.nextInt();
	        scanner.nextLine();
	        User user = userservice.getUserById(userId);
	        if (user != null) {
	            System.out.print("Enter new name: ");
	            user.setName(scanner.nextLine());
	            System.out.print("Enter new email: ");
	            user.setEmail(scanner.nextLine());
	            System.out.print("Enter new password: ");
	            user.setPassword(scanner.nextLine());

	            userservice.modifyUser(user, admin);
	        } else {
	            System.out.println("User not found.");
	        }
	    }

	    private static void deleteUser(Admin admin) {
	        System.out.print("Enter user ID to delete: ");
	        int userId = scanner.nextInt();
	        scanner.nextLine();
	        userservice.deleteUser(userId, admin);
	    }

	    private static void listUsers(Admin admin) {
	        userservice.listUsers(admin);
	    }
	
}
