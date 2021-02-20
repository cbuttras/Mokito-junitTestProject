package com.fdmgroup.ReadCommand;

import java.io.File;
import java.io.IOException;

import com.fdmgroup.UserClasses.User;

/**
 * Interface for Readcommand allowing filereadcommand to read from a file.
 * 
 * @author Christian
 * @version Java Se 1.8.
 */
public interface ReadCommand {
	/**
	 * Method that is accessed by FileReadCommandclass, takes in the parameters
	 * below. It also throws the exceptions outlined below.
	 * 
	 * @param userName
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public User readUser(String userName, File file) throws IOException;

}
