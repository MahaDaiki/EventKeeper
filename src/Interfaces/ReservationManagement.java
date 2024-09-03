package Interfaces;

import Models.Reservation;
import Models.User;

public interface ReservationManagement {
	
	void AddReservation (int UserId, int EventId);
	void CancelReservation(int ReservationId, User requester);
	void ReservationByUser(int UserId);
	void ReservationByEvent(int EventId);

}
