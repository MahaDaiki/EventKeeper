package Services;

import Interfaces.StatisticsManagement;
import Models.Events;
import Models.Reservation;
import Models.User;

import java.util.List;

public class AdminService implements StatisticsManagement {
	
	private List<User> users;
	private List<Events> events;
	private List<Reservation> reservations;
	
	public AdminService(List<User> users, List<Events> events, List<Reservation> reservations) {
		this.users = users;
		this.events = events;
		this.reservations = reservations;
	}

	@Override
	public int getTotalUsers() {
		return  users.size();
	}

	@Override
	public int getTotalEvents() {
		return events.size();
	}

	@Override
	public int getTotalReservations() {
		return reservations.size();
	}

}
