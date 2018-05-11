package com.problem.hundreddoors.util;

import java.util.List;

import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.model.DoorResponse;

public interface DoorResponseCreator{

	/**
	 * Creates Door Response for a list of doors with some state
	 * @param doors
	 * @return
	 */
	public DoorResponse createDoorResponse(List<Door> doors);
}
