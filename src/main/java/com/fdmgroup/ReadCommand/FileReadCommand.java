package com.fdmgroup.ReadCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fdmgroup.UserClasses.User;

/**
 * 
 * @author Christian Allows to create an instance of Readcommand by implementing
 *         the interface.
 * @version Java Se 1.8.
 */
public class FileReadCommand implements ReadCommand {

	User user = new User(null, null, null);

	public FileReadCommand(File file) {

	}

	/**
	 * This method creates a User Object when a username and file is passed through
	 * the method. The user object is filled by reading the file. The while loop and
	 * If statement ensures the proper information is being set at the correct spot.
	 * 
	 * @throws IOException due to many possible errors occurring when
	 *                     writing/reading a file.
	 */
	public User readUser(String Username, File file) throws IOException {

		user = new User(Username, null, null);
		FileReader reader = new FileReader(file);

		BufferedReader bufferedReader = new BufferedReader(reader);

		String line = null;
		String[] newUser;
		while ((line = bufferedReader.readLine()) != null) {

			newUser = line.split(", ");
			if (Username.equals(newUser[0])) {

				user.setUserName(newUser[0]);
				user.setPassword(newUser[1]);
				user.setRole(newUser[2]);

			}

		}
		bufferedReader.close();
		return user;
	}

}
