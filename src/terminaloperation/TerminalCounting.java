package terminaloperation;

import java.util.stream.Collectors;

import data.StudentDb;

public class TerminalCounting {
	public static void main(String[] args) {
		System.out.println("Number of Students with more than 1 Exam Repeat: " + countStudentsWithExamRepeatsGreaterrThanOne());
	}
	
	// Counting all Student names who has more than 1 exam to repeat
	public static long countStudentsWithExamRepeatsGreaterrThanOne() {
		return StudentDb.getAllStudents().stream()
				.filter((student) -> student.getExamRepeat() > 1)
				.collect(Collectors.counting());
	}
}
