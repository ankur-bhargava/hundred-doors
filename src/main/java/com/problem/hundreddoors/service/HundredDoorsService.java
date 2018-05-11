package com.problem.hundreddoors.service;

import java.util.List;

import com.problem.hundreddoors.model.Door;

public interface HundredDoorsService {

	/**
	 * The method to solve the hundred-doors problem based on a list of doors with some state for each door 
	 * @param doors
	 * @return
	 */
	public List<Door> solve(List<Door> doors);
	
}
