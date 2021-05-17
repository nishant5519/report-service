package com.report.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.report.model.Project;
import com.report.service.Report;

public class ReportServiceTest {

	private static Report report;
	
	 @BeforeClass
	    public static void initCalculator() {
		 report = new Report(input());
	    }
	 
	@Test
	public void testNumberOfUniqueCustomerIDforEachContractID() {
		Function<Project, String> funcContractID = p -> p.getContractId();
		Function<Project, String> funcCustomerID = p -> p.getCustomerId();
		
		Map<String, Long> result = report.numberofUniqueAttribute1foreachAttribute2(funcCustomerID, funcContractID);

		assertNotNull(result);
		assertEquals(1, result.get("2347").longValue());
		assertEquals(2, result.get("2346").longValue());
		assertEquals(1, result.get("2345").longValue());
	}

	@Test
	public void testNumberOfUniqueCustomerIDforEachGeoZone() {
		Function<Project, String> funcGeoZone = p -> p.getGeozone();
		Function<Project, String> funcCustomerID = p -> p.getCustomerId();
		
		Map<String, Long> result = report.numberofUniqueAttribute1foreachAttribute2(funcCustomerID, funcGeoZone);

		assertNotNull(result);
		assertEquals(2, result.get("eu_west").longValue());
		assertEquals(1, result.get("eu_north").longValue());
		assertEquals(1, result.get("us_west").longValue());
	}

	@Test
	public void testAverageBuilddurationforEachGeozone() {
		Function<Project, String> funcGeoZone = p -> p.getGeozone();
		ToIntFunction<Project> mapper = p -> Integer.valueOf(p.getBuildduration());
		
		Map<String, Double> result = report.averagebuilddurationforeachAttribute(funcGeoZone, mapper);

		assertNotNull(result);
		assertEquals(4222.0, result.get("eu_west").doubleValue(), 0);
		assertEquals(4122.0, result.get("eu_north").doubleValue(), 0);
		assertEquals(2211.0, result.get("us_west").doubleValue(), 0);
	}

	@Test
	public void testListUniqueCustomerIdforeachGeozone() {
		Function<Project, String> funcGeoZone = p -> p.getGeozone();
		Function<Project, String> funcCustomerID = p -> p.getCustomerId();
		List<String> expected1 = Arrays.asList("3244332", "3244132");
		List<String> expected2 = Arrays.asList("3244133");
		List<String> expected3 = Arrays.asList("1223456");
		
		Map<String, List<String>> result = report.listofUniqueAttribute1foreachAttribute2(funcCustomerID, funcGeoZone);
		
		assertNotNull(result);
		assertThat(expected1, Matchers.containsInAnyOrder(result.get("eu_west").toArray()));
		assertThat(expected2, Matchers.containsInAnyOrder(result.get("eu_north").toArray()));
		assertThat(expected3, Matchers.containsInAnyOrder(result.get("us_west").toArray()));

	}

	public static List<Project> input() {
		Project project1 = new Project.ProjectBuilder("1223456", "2345", "us_west", "BlueTeam", "ProjectBanana", "2211")
				.build();
		Project project2 = new Project.ProjectBuilder("3244332", "2346", "eu_west", "YellowTeam3", "ProjectCarrot",
				"4322").build();
		Project project3 = new Project.ProjectBuilder("3244132", "2346", "eu_west", "YellowTeam3", "ProjectEgg", "4122")
				.build();
		Project project4 = new Project.ProjectBuilder("3244133", "2347", "eu_north", "YellowTeam3", "ProjectEgg",
				"4122").build();
		List<Project> input = new ArrayList<>();
		input.add(project1);
		input.add(project2);
		input.add(project3);
		input.add(project4);

		return input;
	}

}
