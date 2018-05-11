package com.problem.hundreddoors.exception;

/**
 * This exception is thrown whenever an invalid doorNumber is entered
 *
 */
public class InvalidDoorNumberException extends RuntimeException {

	private static final long serialVersionUID = 7293636108955200139L;

	/**
	 *  Default Constructor for InvalidDoorNumberException
	 */
	public InvalidDoorNumberException() {
		super();
	}

	/**
	 * @param message
	 */
	public InvalidDoorNumberException(String message) {
		super(message);
	}

}
