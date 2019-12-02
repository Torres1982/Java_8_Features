package optional;

import java.util.Optional;

import data.Student;
import data.StudentDb;

public class OptionalOrElseOrElseGetOrElseThrow {
	//private static Optional<Student> student = Optional.ofNullable(StudentDb.getAllStudents().get(0));
	private static Optional<Student> student = Optional.ofNullable(null);
	
	public static void main(String [] args) {
		System.out.println(getOptionalOrElse());
		System.out.println(getOptionalOrElseGet());
		System.out.println(getOptionalOrElseThrow());
	}
	
	// Example of OrElse() method (requires aString)
	public static String getOptionalOrElse() {
		return student.map(Student::getName).orElse("No Name Found, orElse!");
	}
	
	// Example of OrElseGet() method (requires a Supplier)
	public static String getOptionalOrElseGet() {
		return student.map(Student::getName).orElseGet(() -> "No Name Found, orElseGet!");
	}
	
	// Example of OrElseThrow() method (requires a Supplier)
	public static String getOptionalOrElseThrow() {
		return student.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data Found Exception, orElseThrow!"));
	}
}
