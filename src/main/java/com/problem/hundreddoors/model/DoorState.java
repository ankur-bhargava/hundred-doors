package com.problem.hundreddoors.model;

import org.apache.log4j.Logger;

public enum DoorState {

	CLOSED, OPEN;

	private static final Logger LOG = Logger.getLogger(DoorState.class);
	
	/**
	 * @return DoorState if currentDoorState is CLOSED, returns OPEN; else returns
	 *         CLOSED
	 */
	public DoorState toggle() {
		LOG.info("DoorState.toggle() called");
		if (this.equals(CLOSED)) {
			return OPEN;
		} else {
			return CLOSED;
		}
	}

}
