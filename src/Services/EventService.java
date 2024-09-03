package Services;

import Interfaces.EventManagement;
import Models.Admin;
import Models.Events;
import Models.User;


import java.util.ArrayList;
import java.util.List;


public class EventService implements EventManagement {
	
	private List <Events> events = new ArrayList<>() ;

	@Override
	public void addEvent(Events event, User requester) {
		if(requester instanceof Admin ) {
			events.add(event);
			System.out.println("Event:" + event + "was added ");
		}
		else {
			throw new SecurityException("Unauthorized to add and event! ");
		}
		
	}

	@Override
	public void modifyEvent(Events event, User requester) {
		if ( requester instanceof Admin) {
			Events ExistingEvent = getEventById(event.getId());
			if ( ExistingEvent != null) {
				ExistingEvent.setDate(event.getDate());
				ExistingEvent.setPlace(event.getPlace());
				ExistingEvent.setType(event.getType());
				System.out.println("Event Modified Succefully!");
			}
			else {
				throw new IllegalArgumentException("Event Not Found");
			}
		}
		else {
			throw new SecurityException("Only admins can modify events!");
		}
		
	}

	@Override
	public void deleteEvent(int eventId, User requester) {
		if(requester instanceof Admin) {
			Events event = getEventById(eventId);
			if (event != null) {
				events.remove(event);
				System.out.println("Event deleted !");
			}
			else
				{
				throw new IllegalArgumentException("Event not found!");
				}
		}
		else {
			throw new SecurityException ("Unauthorized!");
		}
	}

	@Override
	public void listEvents(User requester) {
		if(events.isEmpty()) {
			System.out.println("No events Available!");
		}
		else {
			events.forEach(System.out::println);
		}
		
	}

	@Override
	public Events getEventById(int eventId) {
		return events.stream()
				.filter(event ->event.getId()== eventId)
				.findFirst()
				.orElse(null);
		
	}

}
