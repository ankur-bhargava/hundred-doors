package com.problem.hundreddoors.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.problem.hundreddoors.config.TestContextConfiguration;
import com.problem.hundreddoors.controller.HundredDoorsController;
import com.problem.hundreddoors.model.DoorResponse;

import junit.framework.Assert;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContextConfiguration.class)
public class HundredDoorsControllerImplTest {

	@Autowired
	private HundredDoorsController testController;

	@Test
	public void testSolveProblem() {
		ResponseEntity<DoorResponse> response = testController.solveDoorsProblem(100);
		Assert.assertEquals(response.getStatusCodeValue(), 200);
		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testWrongNumberOfDoors() {
		ResponseEntity<DoorResponse> response = testController.solveDoorsProblem(-100);
		System.out.println(response.getStatusCodeValue());
		Assert.assertEquals(response.getStatusCodeValue(), 400);
	}
}
