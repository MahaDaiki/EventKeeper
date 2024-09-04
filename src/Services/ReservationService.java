package Services;

import Interfaces.ReservationManagement;
import Models.User;
import Models.Reservation;
import Models.Events;
import Models.Admin;

import java.util.ArrayList;
import java.util.List;

public class ReservationService implements ReservationManagement {
	

	private List<Reservation> reservations = new ArrayList<>();

	@Override
	public void AddReservation(int UserId, int EventId) {
		Reservation resevation = new Reservation(UserId, EventId);
		reservations.add(resevation);
		System.out.println("Reserved Successfully!!");
		
	}

	@Override
	public void CancelReservation(int ReservationId, User requester) {
		Reservation reservation = getReservationById(ReservationId);
		
		if(reservation == null) {
			throw new IllegalArgumentException("Rervation not found !") ;
		}
		
		 if (requester instanceof Admin || reservation.getUserId() == requester.getId()) {
	            reservations.remove(reservation);
	            System.out.println("Reservation cancelled!");
	        } else {
	            throw new SecurityException("You are not authorized to cancel this reservation.");
	        }
		
		
	}

	@Override
	public void ReservationByUser(int UserId) {
		for (int i = 0; i < reservations.size(); i++) {
	        Reservation currentReservation = reservations.get(i);
	        if (currentReservation.getUserId() == UserId) {
	            System.out.println("Reservation ID: " + currentReservation.getReservationId() + ", Event ID: " + currentReservation.getEventId());
	        }
	    }
	}

	@Override
	public void ReservationByEvent(int EventId) {
		for (int i = 0; i < reservations.size(); i++) {
	        Reservation currentReservation = reservations.get(i);
	        if (currentReservation.getEventId() == EventId) {
	            System.out.println("Reservation ID: " + currentReservation.getReservationId() + ", User ID: " + currentReservation.getUserId());
	        }
	    }
	}
	
   
	
	private Reservation getReservationById(int reservationId) {
		 for (int i = 0; i < reservations.size(); i++) {
             Reservation currentReservation = reservations.get(i);
             if (currentReservation.getReservationId() == reservationId) {
           
           return currentReservation;
       }
   }
   
      return null;
    }
	
	
}
