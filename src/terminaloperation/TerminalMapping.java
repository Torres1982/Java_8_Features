package terminaloperation;

import static java.util.stream.Collectors.*;
import java.util.Set;
import java.util.List;

import data.Student;
import data.StudentDb;

public class TerminalMapping {
	public static void main(String[] args) {
		System.out.println("Mapping Names (Set): " + listOfNamesMapping());
		System.out.println("Map Names (List): " + listOfNamesMap());
	}
	
	// Use mapping() method to get the Set of Student names
	// Uses one operation less than when you use the map() method
	public static Set<String> listOfNamesMapping() {
		return StudentDb.getAllStudents().stream()
				.collect(mapping(Student::getName, toSet()));
	}
	
	// Use map() method to get the List of Student Names
	public static List<String> listOfNamesMap() {
		return StudentDb.getAllStudents().stream()
				.map(Student::getName)
				.collect(toList());
	}
}
