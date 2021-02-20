package com.fdmgroup.WriteCommand;

import java.io.File;

import java.io.IOException;

import com.fdmgroup.UserClasses.User;
import com.fdmgroup.exceptions.NoEmptyFieldsException;

/**
 * WriteCommand interface that allows the filewritecommand class to perform its
 * purpose.
 * 
 * @author Christian
 * @version Java Se 1.8.
 */
public interface WriteCommand {
	/**
	 * Method that is accessed by file writecommand class, takes in the parameters
	 * below. It also throws the exceptions outlined below.
	 * 
	 * @param user
	 * @param file
	 * @throws IOException
	 * @throws NoEmptyFieldsException
	 */
	public void writeUser(User user, File file) throws IOException, NoEmptyFieldsException;
}
