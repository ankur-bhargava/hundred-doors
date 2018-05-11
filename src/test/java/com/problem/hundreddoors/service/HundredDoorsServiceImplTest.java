package com.problem.hundreddoors.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.problem.hundreddoors.config.TestContextConfiguration;
import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.model.DoorState;
import com.problem.hundreddoors.service.impl.HundredDoorsServiceImpl;

import junit.framework.Assert;

public class HundredDoorsServiceImplTest {

	private final static Integer numDoors = 100;
	private HundredDoorsService hundredDoorsService;

	@Before
	public void before() {
		hundredDoorsService = new HundredDoorsServiceImpl();
	}

	@Test
	public void testService() {
		List<Door> doors = hundredDoorsService.solve(TestContextConfiguration.dummyList(numDoors));
		Assert.assertEquals(10, doors.stream().filter(door -> door.getState().equals(DoorState.OPEN)).count());
		Assert.assertEquals(90, doors.stream().filter(door -> door.getState().equals(DoorState.CLOSED)).count());
	}
}
