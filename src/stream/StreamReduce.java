package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import data.Student;
import data.StudentDb;

public class StreamReduce {
	public static void main(String[] args) {
		// Use Optionals with an Identity
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 5, 6, 8, 12);
		System.out.println(multiplyIntegers(listOfIntegers));
		
		// Use an Optionals Without Identity
		Optional<Integer> optionalResult = multiplyIntegersWithoutIdentity(listOfIntegers);
		System.out.println(optionalResult);
		System.out.println("Is Result Present: " + optionalResult.isPresent());
		
		if (optionalResult.isPresent()) {
			System.out.println("Result: " + optionalResult.get());
		}
		
		
		// Use Optionals and an empty List
		List<Integer> emptyList = new ArrayList<>(); 
		Optional<Integer> optionalEmpty = multiplyIntegersWithoutIdentity(emptyList);
		System.out.println("Is Result Present: " + optionalEmpty.isPresent());
		
		if (optionalEmpty.isPresent()) {
			System.out.println("Result: " + optionalEmpty.get());
		}
		
		// Use Optional to get the Student with the highest GPA
		if (getStudentHighestGpa().isPresent()) {
			System.out.println("Student with the highest GPA is: " + getStudentHighestGpa().get());
		}
		
		// Get the Average students GPA
		System.out.println("Average of Students GPA is: " + getSumOfStudentsGpa());
	}
	
	// Multiply all values of the List using Stream and reduce operation
	// 1 in the reduce is an identity
	public static int multiplyIntegers(List<Integer> list) {
		return list.stream()
				.reduce(1, (a, b) -> a * b);
	}
	
	// Multiply all values of the List using reduce operation without identity
	public static Optional<Integer> multiplyIntegersWithoutIdentity(List<Integer> list) {
		return list.stream()
				.reduce((a, b) -> a * b);
	}
	
	// Get the Student with the highest GPA using Optional
	public static Optional<String> getStudentHighestGpa() {
		return StudentDb.getAllStudents().stream()
				.reduce((student1, student2) -> (student1.getGpa() > student2.getGpa()) ? student1 : student2)
				.map(Student::getName);
	}
	
	// Get the Sum of female Students GPA
	public static double getSumOfStudentsGpa() {
		double sumOfGpa = StudentDb.getAllStudents().stream()
				.filter(Student -> Student.getGender().equals("female"))
				.map(Student::getGpa)
				.reduce((double) 1, (firstGpa, secondGpa) -> firstGpa + secondGpa);
		
		return sumOfGpa;
	}
}






