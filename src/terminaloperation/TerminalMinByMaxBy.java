package terminaloperation;

import static java.util.stream.Collectors.*;
import java.util.Comparator;
import java.util.Optional;

import data.Student;
import data.StudentDb;

public class TerminalMinByMaxBy {
	public static void main(String[] args) {
		System.out.println("Student with the smallest GPA is: " + getStudentWithSmallestGpa().get());
		System.out.println("Student with the highest GPA is: " + getStudentWithHighestGpa().get());
	}
	
	// Get the Student whose GPA is the smallest
	public static Optional<Student> getStudentWithSmallestGpa() {
		return StudentDb.getAllStudents().stream()
				.collect(minBy(Comparator.comparing(Student::getGpa)));
	}
	
	// Get the Student whose GPA is the highest
	public static Optional<Student> getStudentWithHighestGpa() {
		return StudentDb.getAllStudents().stream()
				.collect(maxBy(Comparator.comparing(Student::getGpa)));
	}
}
