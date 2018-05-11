package com.problem.hundreddoors.model;

import org.junit.Test;

public class DoorStateTest {

	@Test
	public void testDoorStateToggleClosedToOpen() {
		DoorState doorState = DoorState.CLOSED;
		doorState = doorState.toggle();
		assert(doorState.equals(DoorState.OPEN));
	}
	
	@Test
	public void testDoorStateToggleOpenToClosed() {
		DoorState doorState = DoorState.OPEN;
		doorState = doorState.toggle();
		assert(doorState.equals(DoorState.CLOSED));
	}
	
}
