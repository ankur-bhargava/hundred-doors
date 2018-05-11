package com.problem.hundreddoors.util.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.model.DoorResponse;
import com.problem.hundreddoors.util.DoorResponseCreator;

@Component
public class DoorResponseCreatorImpl implements DoorResponseCreator {

	private static final Logger LOG = Logger.getLogger(DoorResponseCreatorImpl.class);

	@Override
	public DoorResponse createDoorResponse(List<Door> doors) {
		LOG.info("DoorResponseCreatorImpl.createDoorResponse()");
		DoorResponse doorResponse = new DoorResponse();
		doors.stream().forEach(door -> doorResponse.addDoor(door));
		return doorResponse;
	}
}
