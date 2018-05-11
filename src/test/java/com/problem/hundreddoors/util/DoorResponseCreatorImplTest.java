package com.problem.hundreddoors.util;

import org.junit.Before;
import org.junit.Test;

import com.problem.hundreddoors.config.TestContextConfiguration;
import com.problem.hundreddoors.model.DoorResponse;
import com.problem.hundreddoors.util.impl.DoorResponseCreatorImpl;

import junit.framework.Assert;

public class DoorResponseCreatorImplTest {

	private DoorResponseCreator doorResponseCreator;

	@Before
	public void before() {
		doorResponseCreator = new DoorResponseCreatorImpl();
	}
	
	@Test
	public void testDoorResponseCreator() {
		DoorResponse response = doorResponseCreator.createDoorResponse(TestContextConfiguration.dummyList(100));
		Assert.assertEquals((Integer) 100, response.getNumberOfClosedDoors());
		Assert.assertEquals((Integer) 0, response.getNumberOfOpenDoors());
		Assert.assertEquals(0, response.getOpenedDoors().size());
		Assert.assertEquals(100, response.getClosedDoors().size());
	}

}
