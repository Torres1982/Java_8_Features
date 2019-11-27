package stream;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

import data.Student;
import data.StudentDb;

public class StreamFlatMap {
	private static Predicate<Student> swimmingActivityPredicate = (student -> student.getActivities().contains("swimming"));
	
	public static void main(String[] args) {
		System.out.println(listOfActivities());
		System.out.println(numberOfSwimmingActivities());
	}
	
	// Stream with the flat map operation for List
	public static List<String> listOfActivities() {
		List<String> activities = StudentDb.getAllStudents().stream()
				.map(Student::getActivities) 	// Generates a Stream<List<String>>
				.flatMap(List::stream)			// Generates a Stream<String>
				.distinct()
				.sorted()
				.collect(toList());
			
		return activities;
	}
	
	// Use count operation to display the number of activities
	public static Long numberOfSwimmingActivities() {
		Long numberOfSwimmers = StudentDb.getAllStudents().stream()
				.filter(swimmingActivityPredicate)
				.map(Student::getActivities)
				.flatMap(List::stream)
				.count();
		
		return numberOfSwimmers;
	}
}
