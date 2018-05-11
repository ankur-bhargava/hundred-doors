package com.problem.hundreddoors.model;

import java.util.HashSet;
import java.util.Set;

public class DoorResponse {

	private Integer numberOfOpenDoors;
	private Integer numberOfClosedDoors;
	private Set<Integer> openedDoors;
	private Set<Integer> closedDoors;

	/**
	 * Constructor for DoorResponse, set number of Open and Closed Doors to 0.
	 * Create a new HashSet for Set of opened and ClosedDoors
	 */
	public DoorResponse() {
		numberOfOpenDoors = 0;
		numberOfClosedDoors = 0;
		openedDoors = new HashSet<Integer>();
		closedDoors = new HashSet<Integer>();
	}

	/**
	 * @return Number of Open Doors
	 */
	public Integer getNumberOfOpenDoors() {
		return numberOfOpenDoors;
	}

	/**
	 * @return Number of Closed Doors
	 */
	public Integer getNumberOfClosedDoors() {
		return numberOfClosedDoors;
	}

	/**
	 * @return the unique list of opened doors
	 */
	public Set<Integer> getOpenedDoors() {
		return openedDoors;
	}

	/**
	 * @return the unique list of closed doors
	 */
	public Set<Integer> getClosedDoors() {
		return closedDoors;
	}

	/**
	 * @param door
	 * Adding door to the response, based on the state of the door
	 */
	public void addDoor(Door door) {
		if (door.getState().equals(DoorState.OPEN)) {
			this.openedDoors.add(door.getDoorNumber());
			this.numberOfOpenDoors++;
		} else {
			this.closedDoors.add(door.getDoorNumber());
			this.numberOfClosedDoors++;
		}
	}
}