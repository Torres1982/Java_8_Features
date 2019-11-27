package stream;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;
import data.Student;
import data.StudentDb;

public class StreamMap {
	public static void main(String[] args) {
		System.out.println(listOfNames());
		System.out.println(setOfNames());
	}
	
	// Stream with the map operation for List
	public static List<String> listOfNames() {
		List<String> names = StudentDb.getAllStudents().stream()
				.map(Student::getName)
				.map(String::toLowerCase)
				.collect(toList());
		
		return names;
	}
	
	// Set does not have to keep the order of the list
	// Stream with the map operation for List
	public static Set<String> setOfNames() {
		Set<String> namesSet = StudentDb.getAllStudents().stream()
				.map(Student::getName)
				.map(String::toUpperCase)
				.collect(toSet());
		
		return namesSet;
	}
}
