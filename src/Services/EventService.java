package Services;

import Interfaces.EventManagement;
import Models.Admin;
import Models.Events;
import Models.User;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
	    if (requester instanceof Admin) {
	        Events existingEvent = getEventById(event.getId()); 
        	System.out.println(event);

	        if (true) {
	          
	        	
	            existingEvent.setDate(event.getDate());
	            existingEvent.setPlace(event.getPlace());
	            existingEvent.setType(event.getType());
	            System.out.println(event);
	            System.out.println(");
	            System.out.println("Event Modified Successfully!");
	        }
//	        else {
//	        	System.out.println("dd");
//
//	            throw new IllegalArgumentException("Event Not Found");
//	        }
	    } else {
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
	    for (int i = 0; i < events.size(); i++) {
	        Events event = events.get(i);
	        if (event.getId() == eventId) {
	            return event;
	        }
	    }
	    return null;
	}


	@Override
	public List<Events> searchEvents(String date, String place, String type) {
		List<Events> matchedEvents = new ArrayList<>();
	    for (int i = 0; i < events.size(); i++) {
	        Events event = events.get(i);

	        boolean matchesDate = (date != null && event.getDate().equals(date));
	        boolean matchesPlace = (place != null && event.getPlace().equals(place));
	        boolean matchesType = (type != null && event.getType().equals(type));

	        if (matchesDate || matchesPlace || matchesType) {
	            matchedEvents.add(event);
	        }
	    }

	    return matchedEvents; 
	}
	


}
