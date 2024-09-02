package Services;

import Models.Admin;
import Models.User;
import Models.RegularUser;
import Interfaces.UserManagement;
import java.util.ArrayList;
import java.util.List;

public  class UserService implements UserManagement {
    
    private List<User> users = new ArrayList<>();

	@Override
	public void addUser(User user, User requester) {
		  	if (requester instanceof Admin) {
	  		  users.add(user);
	  	        System.out.println("User added by Admin: " + user);
	  	}
	  	else if (requester instanceof RegularUser) {
	  		if( user instanceof RegularUser) {
	  			users.add(user);
	  			System.out.println("User Added:" + user);
	  		}else {
	              throw new SecurityException(" You are regular User !!");
	          }
	  	}
	  	else {
	  	throw new SecurityException ("Unknown Role!");
	  }
			
		}


	@Override
	public void modifyUser(User user, User requester) {
	 if(requester instanceof Admin || requester.equals(user)) {
		 
		  User existingUser = getUserById(user.getId());
		  if (existingUser != null) {
              existingUser.setName(user.getName());
              existingUser.setEmail(user.getEmail());
              existingUser.setPassword(user.getPassword());
              existingUser.setRole(user.getRole());
              System.out.println("User modified: " + existingUser);
          } else {
              throw new IllegalArgumentException("User not found.");
          }
      } else {
          throw new SecurityException("You are not authorized to modify this user.");
      }
	 
	 }



	public void deleteUser(int userId, User requester) {
		 User user = getUserById(userId);
	        if (user == null) {
	            throw new IllegalArgumentException("User not found.");
	        }
	        if (requester instanceof Admin || requester.equals(user)) {
	            users.remove(user);
	            System.out.println("User removed: " + user);
	        } else {
	            throw new SecurityException("You are not authorized to delete this user.");
	        }
	}


	@Override
	public void listUsers(User requester) {
		 if (requester instanceof Admin) {
	            if (users.isEmpty()) {
	                System.out.println("No users found.");
	            } else {
	                users.forEach(System.out::println);
	            }
	        } else {
	            throw new SecurityException("Only admins can list all users.");
	        }
		
	}
	


	@Override
	public User getUserById(int userId) {
		   return users.stream()
	                .filter(user -> user.getId() == userId)
	                .findFirst()
	                .orElse(null);
	}



}

		


