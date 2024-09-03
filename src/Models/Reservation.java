package Models;

public class Reservation {
	private static int LastReservationId = 0 ;
	private int ReservationId ;
	private int UserId;
	private int EventId;
	
	public Reservation ( int UserId , int EventId ) {
		this.ReservationId = ++LastReservationId;
		this.UserId = UserId;
		this.EventId = EventId;
		
		
	}
	
	 public int getReservationId() {
	        return ReservationId;
	    }

	    public int getUserId() {
	        return UserId;
	    }

	    public int getEventId() {
	        return EventId;
	    }
}
