package com.problem.hundreddoors.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.problem.hundreddoors.exception.InvalidDoorNumberException;
import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.model.DoorResponse;
import com.problem.hundreddoors.service.HundredDoorsService;
import com.problem.hundreddoors.util.AddDoorToListHelper;
import com.problem.hundreddoors.util.DoorResponseCreator;

@Component
public class HundredDoorsControllerImpl implements HundredDoorsController {

	@Autowired
	private HundredDoorsService hundredDoorsService;
	@Autowired
	private DoorResponseCreator doorResponseCreator;
	@Autowired
	private AddDoorToListHelper doorToListHelper;

	private static final Logger LOG = Logger.getLogger(HundredDoorsControllerImpl.class);

	public ResponseEntity<DoorResponse> solveDoorsProblem(@RequestParam("numberOfDoors") Integer numDoors) {
		LOG.info("HundredDoorsController.solveDoorsProblem(), numberOfDoors: " + numDoors);
		try {
			if (numDoors < 0) {
				LOG.error("Invalid Number of doors Specified: " + numDoors);
				return new ResponseEntity<DoorResponse>(HttpStatus.BAD_REQUEST);
			}
			List<Door> doors = doorToListHelper.addDoorsToList(numDoors);
			return ResponseEntity.ok(doorResponseCreator.createDoorResponse(hundredDoorsService.solve(doors)));
		} catch (InvalidDoorNumberException invalidDoorException) {
			LOG.error("Invalid Door Number: ", invalidDoorException);
			return new ResponseEntity<DoorResponse>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOG.error("Error getting response: ", e);
			return new ResponseEntity<DoorResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
