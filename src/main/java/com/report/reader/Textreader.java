package com.report.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.report.model.Project;

public class Textreader implements Reader {

	public static String COMMA_REGEX = ",";

	@Override
	public List<Project> read(FileReader file) {

		List<Project> data = new ArrayList<>();
		 Project project = null;

		try (BufferedReader in = new BufferedReader(file)) {
			String str;
			while ((str = in.readLine()) != null) {
				String[] tokens = str.split(COMMA_REGEX);

				 project = new Project.ProjectBuilder(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],
						tokens[5].substring(0, tokens[5].length() - 1)).build();
				data.add(project);
			}

		} catch (IOException e) {
			System.err.println("Error in reading text file");
		}
		return data;
	}
}
