package com.report.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import com.report.model.Project;

public class Report {

	List<Project> data;

	public Report(List<Project> input) {
		this.data = new ArrayList<Project>(input);
	}

	public Map<String, Long> numberofUniqueAttribute1foreachAttribute2(Function<Project, String> attr1,Function<Project, String> attr2) {
		
		Map<String, Long> postsPerType = data.stream().filter(distinctByKey(attr1))
				.collect(Collectors.groupingBy(attr2, Collectors.counting()));

		return postsPerType;
	}


	public Map<String, List<String>> listofUniqueAttribute1foreachAttribute2(Function<Project, String> attr1,Function<Project, String> attr2) {

		Map<String, List<String>> postsPerType = data.stream().filter(distinctByKey(attr1))
				.collect(Collectors.groupingBy(attr2,
						Collectors.mapping(attr1, Collectors.toList())));

		return postsPerType;
	}

	public Map<String, Double> averagebuilddurationforeachAttribute(Function<Project, String> attribute,ToIntFunction<Project> mapper) {
		
		Map<String, Double> average =	data
			        					.parallelStream()
			        					.collect(Collectors.groupingBy(attribute,                      
			        								Collectors.averagingInt(mapper)));
        
		return average;
	}

	public static  Predicate<Project> distinctByKey(Function<Project, String> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}


}
