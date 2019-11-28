package stream;

import java.util.Optional;
import java.util.function.Predicate;

import data.Student;
import data.StudentDb;

public class StreamFind {
	private static Predicate<Student> gpaPredicate = (student -> student.getGpa() >= 3.7);
	
	public static void main(String[] args) {
		Optional<Student> foundAnyStudent = getAnyStudentGpa();
		String anyStudentFound = foundAnyStudent.isPresent() ? "Found Any Student: " + getAnyStudentGpa().get() : "There is no any Student found!";
		
		System.out.println(anyStudentFound);
	}
	
	// Find any Student with a specific GPA (>= 3.7)
	public static Optional<Student> getAnyStudentGpa() {
		return StudentDb.getAllStudents().stream()
				.filter(gpaPredicate)
				.findAny();
				//.findFirst();
	}
}
