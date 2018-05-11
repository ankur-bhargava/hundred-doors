package com.problem.hundreddoors.util;

import java.util.List;

import com.problem.hundreddoors.model.Door;

public interface AddDoorToListHelper {

	/**
	 * Helper method to create a list of @numDoors doors with initial state  
	 * @param numDoors
	 * @return
	 */
	public List<Door> addDoorsToList(int numDoors);
}
