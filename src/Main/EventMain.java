package Main;

import Models.Admin;
import Models.Events;
import Services.AdminService;
import Services.EventService;

import java.util.Scanner;

public class EventMain {

	 private static EventService eventService = new EventService();
	 private static Scanner scanner = new Scanner(System.in);
	 
	 public static void main(String[] args) {
		 eventService.addEvent(new Events( "2024-10-01", "Place A", "Type A"), new Admin("Admin", "admin@example.com", "password"));
	        eventService.addEvent(new Events( "2024-11-01", "Place B", "Type B"), new Admin("Admin", "admin@example.com", "password"));
	        Admin admin = new Admin("Admin", "admin@mail.com", "password");
	        manageEventsMenu(admin);
	    }

	    public static void manageEventsMenu(Admin admin) {
	        while (true) {
	            System.out.println("Event Manager:");
	            System.out.println("1. Add Event");
	            System.out.println("2. Modify Event");
	            System.out.println("3. Delete Event");
	            System.out.println("4. List All Events");
	            System.out.println("5. <---- Back");
	            System.out.print("- ");

	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    addEvent(admin);
	                    break;
	                case 2:
	                    modifyEvent(admin);
	                    break;
	                case 3:
	                    deleteEvent(admin);
	                    break;
	                case 4:
	                    eventService.listEvents(admin);
	                    break;
	                case 5:
	                    return; 
	                default:
	                    System.out.println("Invalid Choice, Please choose again");
	            }
	        }
	    }

	    private static void addEvent(Admin admin) {
	        System.out.print("Enter Event Date: ");
	        String date = scanner.nextLine();
	        System.out.print("Enter Event Place: ");
	        String place = scanner.nextLine();
	        System.out.print("Enter Event Type: ");
	        String type = scanner.nextLine();

	        Events event = new Events(date, place, type);
	        eventService.addEvent(event, admin);
	    }

	    private static void modifyEvent(Admin admin) {
	    	eventService.listEvents(admin);
	        System.out.print("Enter Event ID to Modify: ");
	        int eventId = scanner.nextInt();
	        scanner.nextLine();

	        Events existingEvent = eventService.getEventById(eventId);
	        if (existingEvent != null) {
	            System.out.print("Enter New Date: ");
	            String date = scanner.nextLine();
	            System.out.print("Enter New Place: ");
	            String place = scanner.nextLine();
	            System.out.print("Enter New Type: ");
	            String type = scanner.nextLine();

	            Events event = new Events(date, place, type);
	            eventService.modifyEvent(event, admin);
	        } else {
	            System.out.println("Event not found.");
	        }
	    }

	    private static void deleteEvent(Admin admin) {
	        System.out.print("Enter Event ID to Delete: ");
	        int eventId = scanner.nextInt();
	        scanner.nextLine();

	        eventService.deleteEvent(eventId, admin);
	    }
	    
}
