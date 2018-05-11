package com.problem.hundreddoors.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.problem.hundreddoors.model.DoorResponse;

@RestController
public interface HundredDoorsController {

	/**
	 * Endpoint for getting the DoorResponse
	 * @param numberOfDoors
	 * @return the ResponseEntity with DoorResponse
	 */
	@RequestMapping(value = "/solveDoorsProblem", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<DoorResponse> solveDoorsProblem(@RequestParam("numberOfDoors") Integer numberOfDoors); 

}
