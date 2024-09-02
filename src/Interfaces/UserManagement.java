package Interfaces;

import Models.User;

public interface UserManagement {
	
	    void addUser(User user, User requester);      
	    void modifyUser(User user, User requester);   
	    void deleteUser(int userId, User requester); 
	    void listUsers(User requester);              
	    User getUserById(int userId); 
	   
}
