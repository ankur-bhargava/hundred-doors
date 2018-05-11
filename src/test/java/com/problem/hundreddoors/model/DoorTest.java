package com.problem.hundreddoors.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.problem.hundreddoors.exception.InvalidDoorNumberException;

public class DoorTest {

	private Door door;

	@Before
	public void beforeTest() {
		door = new Door(10);
	}

	@Test
	public void testConstructor() {
		Door door = new Door(10);
		Assert.assertEquals(door.getDoorNumber(), (Integer) 10);
		Assert.assertEquals(door.getState(), DoorState.CLOSED);
	}

	@Test
	public void doorToggleTest() {
		door.toggleState();
		Assert.assertEquals(door.getState(), DoorState.OPEN);
	}

	@Test
	public void doorGetDoorNumber() {
		Assert.assertEquals(door.getDoorNumber(), (Integer) 10);
	}

	@Test
	public void doorGetState() {
		Assert.assertEquals(door.getState(), DoorState.CLOSED);
	}

	@Test(expected = InvalidDoorNumberException.class)
	public void doorToggleInvalidDoorNumber() {
		Door door = new Door(-10);
	}

}
