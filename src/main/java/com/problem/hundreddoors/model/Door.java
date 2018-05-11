package com.problem.hundreddoors.model;

import org.apache.log4j.Logger;

import com.problem.hundreddoors.exception.InvalidDoorNumberException;

public class Door {
	private static final Logger LOG = Logger.getLogger(Door.class);
	
	private DoorState state;
	private Integer doorNumber;

	/**
	 * Constructor for creating a door Object with doorNumber
	 * 
	 * @param doorNumber
	 */
	public Door(Integer doorNumber) throws InvalidDoorNumberException {
		LOG.info("Creating Door : " + doorNumber);
		validateDoorNumber(doorNumber);
		this.doorNumber = doorNumber;
		this.state = DoorState.CLOSED;
		LOG.info("Door created: " + doorNumber);
	}

	private void validateDoorNumber(Integer doorNumber) throws InvalidDoorNumberException {
		LOG.info("Validating Door Number: " + doorNumber);
		if (doorNumber < 0) {
			LOG.error("Invalid Door Number " + doorNumber);
			throw new InvalidDoorNumberException("Invalid doorNumber: " + doorNumber);
		}
		LOG.info("Door number " + doorNumber + " is valid");
	}

	/**
	 * @return the state of the Door(CLOSED/OPEN)
	 */
	public DoorState getState() {
		LOG.info("Door.getState() called");
		return this.state;
	}

	/**
	 * @return the doorNumber
	 */
	public Integer getDoorNumber() {
		LOG.info("Door.getDoorNumber() called");
		return this.doorNumber;
	}

	/**
	 * Toggles the state of the door
	 */
	public void toggleState() {
		LOG.info("Door.toggleState() called");
		state = state.toggle();
	}

}
