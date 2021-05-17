package com.report.driver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import com.report.model.Project;
import com.report.reader.Reader;
import com.report.reader.Textreader;
import com.report.service.Report;

public class GenerateReport {
	
	private static final String INPUT_FILE_LOCATION = "/Users/nissing3/Desktop/input.txt";

	public static void main(String[] args) throws FileNotFoundException {

		FileReader fileReader = new FileReader(INPUT_FILE_LOCATION);
		Reader reader = new Textreader();
		List<Project> data = reader.read(fileReader);
		
		Report report = new Report(data);
		
		Function<Project, String> funcContractID = p -> p.getContractId();
		Function<Project, String> funcCustomerID = p -> p.getCustomerId();
		Function<Project, String> funcGeoZone = p -> p.getGeozone();
		
		ToIntFunction<Project> mapper = p -> Integer.valueOf(p.getBuildduration());

		System.out.println("The number of unique customerId for each contractId");
		System.out.println(report.numberofUniqueAttribute1foreachAttribute2(funcCustomerID, funcContractID));
		
		System.out.println("==========================================");
		
		System.out.println("The number of unique customerId for each geozone");
		System.out.println(report.numberofUniqueAttribute1foreachAttribute2(funcCustomerID, funcGeoZone));
		
		System.out.println("==========================================");
		
		System.out.println("The average buildduration for each geozone");
		System.out.println(report.averagebuilddurationforeachAttribute(funcGeoZone,mapper));
		
		System.out.println("==========================================");
		
		System.out.println("The list of unique customerId for each geozone");
		System.out.println(report.listofUniqueAttribute1foreachAttribute2(funcCustomerID, funcGeoZone));
		
		

			
		

	}

}
