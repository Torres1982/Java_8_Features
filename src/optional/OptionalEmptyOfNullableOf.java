package optional;

import java.util.Optional;

import data.Student;
import data.StudentDb;

public class OptionalEmptyOfNullableOf {
	public static void main(String [] args) {
		if (getStudentName().isPresent()) {
			System.out.println(getStudentName().get() + "'s length is: " + getStudentName().get().length());
		} else {
			System.out.println("Could not find any name!");
		}		
	}

	// Retrieve the Student name
	public static Optional<String> getStudentName() {
		Optional<Student> student = Optional.ofNullable(null);
		//Optional<Student> student = Optional.ofNullable(StudentDb.getAllStudents().get(0));

		if (student.isPresent()) {
			return student.map(Student::getName);
		}
		
		return Optional.empty(); // Optional Object without the value
	}
}
