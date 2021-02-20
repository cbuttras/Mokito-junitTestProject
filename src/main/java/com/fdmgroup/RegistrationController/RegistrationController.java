package com.fdmgroup.RegistrationController;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.ReadCommand.FileReadCommand;

import com.fdmgroup.UserClasses.*;
import com.fdmgroup.WriteCommand.FileWriteCommand;
import com.fdmgroup.exceptions.NoDuplicatesAllowedException;
import com.fdmgroup.exceptions.NoEmptyFieldsException;

/**
 * Controller that is able to put the whole project together into once class.
 * 
 * @author Christian
 * @version Java Se 1.8.
 */
public class RegistrationController {
	private FileReadCommand fileReadCommand;
	private FileWriteCommand fileWriteCommand;
	private UserFactory userFactory;
	private File file;
	Logger logger = LogManager.getLogger("myLogger");

	/**
	 * Constructor that accepts the different classes in and can perform their
	 * duties.
	 * 
	 * @param fileReadCommand
	 * @param fileWriteCommand
	 * @param userFactory
	 */
	public RegistrationController(FileReadCommand fileReadCommand, FileWriteCommand fileWriteCommand,
			UserFactory userFactory) {
		this.fileReadCommand = fileReadCommand;
		this.fileWriteCommand = fileWriteCommand;
		this.userFactory = userFactory;

	}

	/**
	 * Method that registers a new user using the parameters below and throws the
	 * Exceptions below. If(user1==null) is in place so that the following exception
	 * after that is triggered. This provides cover for duplicate usernames.
	 * 
	 * @param username
	 * @param password
	 * @param role
	 * @throws IOException
	 * @throws NoEmptyFieldsException
	 * @throws NoDuplicatesAllowedException
	 */
	public void registerNewUser(String username, String password, String role)
			throws IOException, NoEmptyFieldsException, NoDuplicatesAllowedException {

		file = new File("Demo.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		User user = userFactory.createUser();

		user.setUserName(username);
		user.setPassword(password);
		user.setRole(role);

		User user1 = fileReadCommand.readUser(username, file);

		if (user1 == null) {
			logger.error("NoDuplicatesAllowedException triggered");
			throw new NoDuplicatesAllowedException("No Duplicate Usernames allowed");
		} else {
			user1.setUserName(username);
			user1.setPassword(password);
			user1.setRole(role);
		}

		fileWriteCommand.writeUser(user, file);

	}

}
