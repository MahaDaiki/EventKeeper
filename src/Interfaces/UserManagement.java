package Interfaces;

import Models.User;

public interface UserManagement {
	void AddUser(User user);
	void ModifyUser(User user);
	void DeleteUser(User user);
	void ShowUsers();
}
