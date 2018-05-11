package com.problem.hundreddoors.util;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.model.DoorState;
import com.problem.hundreddoors.util.impl.AddDoorToListImpl;

import junit.framework.Assert;

public class AddDoorToListImplTest {

	private AddDoorToListHelper doorToListHelper;

	@Before
	public void before() {
		doorToListHelper = new AddDoorToListImpl();
	}

	@Test
	public void testHelper() {
		List<Door> doors = doorToListHelper.addDoorsToList(100);
		Assert.assertEquals(100, doors.size());
		Assert.assertEquals(100, doors.stream().filter(door->door.getState().equals(DoorState.CLOSED)).count());
	}
}
