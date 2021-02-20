package com.fdmgroup.WriteCommand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.UserClasses.User;
import com.fdmgroup.exceptions.NoEmptyFieldsException;

/**
 * This class implements the WriteCommand interface
 * 
 * @author Christian
 * @version Java Se 1.8.
 */
public class FileWriteCommand implements WriteCommand {
	Logger logger = LogManager.getLogger("myLogger");

	public FileWriteCommand(File file) {

	}

	/**
	 * Writes user to the file. If statement is triggered if any of the fields are
	 * blank.
	 * 
	 * @throws IOException           due to possible errors reading/writing to
	 *                               files.
	 * @throws NoEmptyFieldsException is able to identify if any of the fields are
	 *                               blank and breaks out of the test.
	 *
	 */
	public void writeUser(User user, File file) throws IOException, NoEmptyFieldsException {

		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		if (user.getUserName() == null | user.getPassword() == null | user.getRole() == null) {
			bufferedWriter.close();
			writer.close();
			logger.error("NoEmptyFieldsException triggered");
			throw new NoEmptyFieldsException("Please input a valid username password and role");
		}

		bufferedWriter.write(user.getUserName() + ", ");
		bufferedWriter.write(user.getPassword() + ", ");
		bufferedWriter.write(user.getRole() + ".");

		bufferedWriter.newLine();

		bufferedWriter.flush();
		bufferedWriter.close();

	}

}
