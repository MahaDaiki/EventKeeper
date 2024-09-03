package Interfaces;
import Models.User;
import Models.Events;

public interface EventManagement {
    void addEvent(Events event, User requester);
    void modifyEvent(Events event, User requester);
    void deleteEvent(int eventId, User requester);
    void listEvents(User requester);
    Events getEventById(int eventId);
	
}
