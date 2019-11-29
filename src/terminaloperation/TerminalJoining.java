package terminaloperation;

import java.util.stream.Collectors;

import data.Student;
import data.StudentDb;

public class TerminalJoining {
	public static void main(String[] args) {
		System.out.println(joinStudentNames());
	}
	
	// Concatenate all Student names
	public static String joinStudentNames() {
		return StudentDb.getAllStudents().stream()
				.map(Student::getName)
				.collect(Collectors.joining(" - "));
	}
}
