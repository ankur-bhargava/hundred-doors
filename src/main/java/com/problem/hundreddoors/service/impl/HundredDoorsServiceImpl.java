package com.problem.hundreddoors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.service.HundredDoorsService;

@Service
public class HundredDoorsServiceImpl implements HundredDoorsService {

	/**
	 * Accepting a list of doors, This method gives an optimal solution to the
	 * problem, by mathematical calculation, as the perfect squares will have odd
	 * number of unique factors, eg. 9 will have 1,3 and 9 So at the end only these
	 * doors will be open Will return DoorResponse which contain the number of open
	 * doors, number of closed doors and a list containing open and one containing
	 * the closed doors
	 * 
	 * @param doors
	 * @return
	 */
	public List<Door> solve(List<Door> doors) {
		int noOfDoors = doors.size();
		int sqrt = (int) Math.floor(Math.sqrt(noOfDoors));
		for (int i = 1; i <= sqrt; i++) {
			doors.get((i * i) - 1).toggleState();
		}
		return doors;
	}
}
