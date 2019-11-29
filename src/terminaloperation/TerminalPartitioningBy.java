package terminaloperation;

import java.util.function.Predicate;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import data.Student;
import data.StudentDb;

public class TerminalPartitioningBy {
	private static Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.25;
	
	public static void main(String[] args) {
		partitionStudentsByGpaPredicate();
	}
	
	// Partition Students whether they have GPA higher than 3.25 - true, or otherwise false
	public static void partitionStudentsByGpaPredicate() {
		Map<Boolean, Set<Student>> mapOfStudents = StudentDb.getAllStudents().stream()
				.collect(partitioningBy(gpaPredicate, toSet()));
		
		System.out.println("Does the Student have First Class Degree? " + mapOfStudents);
	} 
}
