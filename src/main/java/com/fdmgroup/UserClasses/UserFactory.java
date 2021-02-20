package com.fdmgroup.UserClasses;

/**
 * This class's purpose is to extend the User. It also offers an alternative way
 * to create a user.
 * 
 * @author Christian
 * @version Java Se 1.8.
 */
public class UserFactory {

	/**
	 * This methods create a userFactory constructor taking in no parameters.
	 * 
	 */
	public UserFactory() {

	}

	/**
	 * This methods creates a user but takes no parameters in.
	 * 
	 * @return user
	 */
	public User createUser() {

		User user = new User(null, null, null);
		return user;

	}

}
