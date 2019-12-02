package optional;

import java.util.Optional;

import data.Student;
import data.StudentDb;

public class OptionalIfPresent {
	public static void main(String [] args) {
		getTheName();
	}
	
	// Example of ifPresent()
	public static void getTheName() {
		Optional<String> name = Optional.ofNullable(StudentDb.getAllStudents().get(0).getName());
		//Optional<Student> name = Optional.ofNullable(null);
		name.ifPresent(studentName -> System.out.println(studentName));
	}
}
