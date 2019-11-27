package stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

import data.Student;
import data.StudentDb;

public class StreamCustomizedSort {
	private static Predicate<Student> genderFemalePredicate = (student -> student.getGender().equals("female"));
	
	public static void main(String[] args) {
		System.out.println("Sorted by Names: " + listOfStudentsSortedByName());
		System.out.println("Sorted by female GPA in reversed order: " + listOfStudentsSortedByGpa());
		System.out.println("Sorted Names (Strings): ");
		listOfStudentsSortedByName().forEach(System.out::println);
	}
	
	// Sort the names by student names
	public static List<String> listOfStudentsSortedByName() {
		List<String> sortedStudents = StudentDb.getAllStudents().stream()
				.sorted(Comparator.comparing(Student::getName))
				.map(Student::getName)
				.collect(toList());
		
		return sortedStudents;
	}
	
	// Sort the female names by GPA in reversed order
	public static List<String> listOfStudentsSortedByGpa() {
		List<String> sortedStudents = StudentDb.getAllStudents().stream()
				.filter(genderFemalePredicate)
				.sorted(Comparator.comparing(Student::getGpa).reversed())
				.map(Student::getName)
				.collect(toList());
		
		return sortedStudents;
	}
}
