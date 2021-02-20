package com.fdmgroup.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class creates an exception that does not allow for empty fields to be
 * submitted in the file.
 * 
 * @author Christian
 * @version Java Se 1.8.
 */
public class NoEmptyFieldsException extends Exception {
	Logger logger = LogManager.getLogger("myLogger");
	private String message;

	/**
	 * Constructor for the exception which allows for a message to be outputted.
	 * 
	 * @param message
	 */
	public NoEmptyFieldsException(String message) {
		super();
		logger.error("you cannot input empty fields");
		this.message = message;

	}

}
