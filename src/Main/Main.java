package Main;

import Models.Admin;
//import Models.Events;
import Models.RegularUser;
//import Models.User;
//import Services.EventService;
import Services.UserService;

import Main.UserMain;
import Main.AdminMain;


import java.util.Scanner;

public class Main {
	
			 private static UserService userService = new UserService();
			 private static Scanner scanner = new Scanner(System.in);
			 
			 
	public static void main(String[] args) {
		
		MainMenu();
//		Admin admin = new Admin("Admin", "admin@email.com" , "password");
//		RegularUser user1 = new RegularUser("User1", "user1@email.com","password");
//		RegularUser user2 = new RegularUser("User2", "user2@email.com","password");
		
		
		
	}
	
	public static void MainMenu() {
		 while (true) {
	            System.out.println("Welcome:");
	            System.out.println("1. Enter as User");
	            System.out.println("2. Enter as Admin");
	            System.out.println("3. Exit");
	            System.out.print("- ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    RegularUser();
	                    break;
	                case 2:
	                    Admin();
	                    break;
	                case 3:
	                    System.out.println("Exiting. Goodbye!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	
	
	public static void RegularUser(){
		 System.out.print("Enter your name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter your email: ");
	        String email = scanner.nextLine();
	        System.out.print("Enter your password: ");
	        String password = scanner.nextLine();

	        RegularUser user = new RegularUser(name, email, password);
	        userService.addUser(user, user);
	        UserMain.RegularUserMenu(user);
		
	}
	
	
	
	public static void Admin() {
		String AdminName = "Admin" ;
		String AdminEmail = "Admin@mail.com";
		String AdminPassword ="password";
		
		Admin admin = new Admin(AdminName, AdminEmail, AdminPassword);
		
		
		AdminMain.AdminMenu(admin);	
	}
	
	
	
}
