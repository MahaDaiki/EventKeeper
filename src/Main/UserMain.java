package Main;

import Services.EventService;
//import Services.UserService;
import Services.ReservationService;
import Models.RegularUser;
import java.util.Scanner;

public class UserMain {

//    private static UserService userService = new UserService();
    private static EventService eventService = new EventService();
    private static ReservationService reservationService = new ReservationService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RegularUser user = new RegularUser("John Doe", "john@example.com", "password");
        RegularUserMenu(user);
    }

    public static void RegularUserMenu(RegularUser user) {
        while (true) {
            eventService.listEvents(null);
            
            System.out.println("Hello " + user.getName() + ", Welcome! ＼(ﾟｰﾟ＼)");
            System.out.println("1. Search Events");
            System.out.println("2. Register for an Event");
            System.out.println("3. View My Reservations");
            System.out.println("4. Logout");
            System.out.print("- ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    SearchForEvents();
                    break;
                case 2:
                    RegisterForEvent(user);
                    break;
                case 3:
                    ViewMyReservations(user);
                    break;
                case 4:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid Choice, Please choose again");
            }
        }
    }

    private static void RegisterForEvent(RegularUser user) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Search");
            System.out.println("3. <--- Go Back");
            System.out.print("- ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    eventService.listEvents(null);
                    System.out.print("Enter Event  To Register: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine();
                    reservationService.AddReservation(user.getId(), eventId);
                    System.out.println("Registered Successfully!");
                    break;
                case 2:
                    SearchForEvents();
                    System.out.print("Enter Event To Register: ");
                    int searchedEventId = scanner.nextInt();
                    scanner.nextLine();
                    reservationService.AddReservation(user.getId(), searchedEventId);
                    System.out.println("Registered successfully!");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static void SearchForEvents() {
        System.out.print("Search by Date, Place, or Type: ");
        String search = scanner.nextLine();
        var events = eventService.searchEvents(search, search, search);
        
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Search Results:");
            events.forEach(System.out::println);
        }
    }

    private static void ViewMyReservations(RegularUser user) {
        reservationService.ReservationByUser(user.getId());
    }
}
