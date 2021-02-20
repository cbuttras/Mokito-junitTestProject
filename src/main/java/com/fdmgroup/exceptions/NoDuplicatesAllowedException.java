package com.fdmgroup.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Exception class which does not allow for duplicate usernames to be outputted to the file.
 * @author Christian
 * @version Java Se 1.8
 *
 */
public class NoDuplicatesAllowedException extends Exception {
	Logger logger = LogManager.getLogger("myLogger");
	private String message;
    /**
     * If the exception is triggered, the following message is shown.
     * @param message
     */
	public NoDuplicatesAllowedException(String message) {
		super();
		logger.error("you cannot enter duplicate usernames, please try again");
		this.message = message;
	}

}
