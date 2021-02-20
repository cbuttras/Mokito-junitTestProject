package com.fdmgroup.UserClasses;

/**
 * 
 * @author Christian The User class is where the user object will gets its
 *         parameters from, such as name, password and role.
 * @version Java Se 1.8.
 */
public class User {
	private String userName;
	private String password;
	private String role;

	/**
	 * Constructor for User where the following parameters are passed through.
	 * 
	 * @param userName
	 * @param password
	 * @param role
	 */
	public User(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;

	}

	/**
	 * This method gets the Username from the user object and returns it.
	 * 
	 * @return userName
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * This method sets the Username in the user object.
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {

		this.userName = userName;

	}

	/**
	 * This method gets the password from the user object and returns it.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method sets the password in the user object.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {

		this.password = password;

	}

	/**
	 * This method gets the role from the user object and returns it.
	 * 
	 * @return role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * This method sets the role in the user object.
	 * 
	 * @param role
	 */
	public void setRole(String role) {

		this.role = role;
	}

}
