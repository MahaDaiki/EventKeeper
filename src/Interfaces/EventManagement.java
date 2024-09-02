package Interfaces;

import Models.Events;

public interface EventManagement {
	void AddEvent(Events event);
	void ModifyEvent(Events event);
	void DeleteEvent(Events event);
	void ShowEvents();
	
}
