package com.problem.hundreddoors.config;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.problem.hundreddoors.controller.HundredDoorsController;
import com.problem.hundreddoors.controller.HundredDoorsControllerImpl;
import com.problem.hundreddoors.model.Door;
import com.problem.hundreddoors.model.DoorResponse;
import com.problem.hundreddoors.service.HundredDoorsService;
import com.problem.hundreddoors.util.AddDoorToListHelper;
import com.problem.hundreddoors.util.DoorResponseCreator;

@Profile("test")
@Configuration
public class TestContextConfiguration {

	@Bean
	@Primary
	public HundredDoorsService hundredDoorsService() {
		HundredDoorsService doorService = Mockito.mock(HundredDoorsService.class);
		Mockito.when(doorService.solve(Matchers.anyList())).then(invocation -> invocation.getArgument(0));
		return doorService;
	}

	@Bean
	@Primary
	public DoorResponseCreator doorResponseCreator() {
		DoorResponseCreator doorResponseCreator = Mockito.mock(DoorResponseCreator.class);
		Mockito.when(doorResponseCreator.createDoorResponse(Matchers.anyList()))
				.thenAnswer(invocation -> createDummyDoorResponse(invocation.getArgument(0)));
		return doorResponseCreator;
	}

	private DoorResponse createDummyDoorResponse(List<Door> doors) {
		DoorResponse response = new DoorResponse();
		doors.stream().forEach(door -> response.addDoor(door));
		return response;
	}

	@Bean
	@Primary
	public AddDoorToListHelper doorToListHelper() {
		AddDoorToListHelper doorListHelper = Mockito.mock(AddDoorToListHelper.class);
		Mockito.when(doorListHelper.addDoorsToList(Matchers.anyInt()))
				.thenAnswer(invocation -> dummyList(invocation.getArgument(0)));

		return doorListHelper;
	}

	@Bean
	@Primary
	public HundredDoorsController hundredDoorsController() {
		return new HundredDoorsControllerImpl();
	}

	public static List<Door> dummyList(int numDoors) {
		List<Door> dummyDoors = new ArrayList<Door>();
		for (int i = 1; i <= numDoors; i++)
			dummyDoors.add(new Door(i));
		return dummyDoors;
	}

}
