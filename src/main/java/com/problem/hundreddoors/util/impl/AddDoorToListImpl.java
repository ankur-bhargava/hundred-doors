package com.problem.hundreddoors.util.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.util.AddDoorToListHelper;

@Component
public class AddDoorToListImpl implements AddDoorToListHelper{

	private static final Logger LOG = Logger.getLogger(AddDoorToListImpl.class);
	
	public List<Door> addDoorsToList(int numDoors) {
		LOG.info("AddDoorToListImpl.addDoorsToList() with numDoors = " + numDoors);
		List<Door> doors = new ArrayList<Door>();
		for (int i = 1; i <= numDoors; i++) {
			LOG.info("Adding Door Number " + i + " to the list");
			doors.add(new Door(i));
		}
		return doors;
	}
}
