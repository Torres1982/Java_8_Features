package terminaloperation;

import static java.util.stream.Collectors.*;

import data.Student;
import data.StudentDb;

public class TerminalSumAvg {
	public static void main(String[] args) {
		System.out.println("Sum of all Exam Repeats is: " + getSumOfExamRepeats());
		System.out.println("Average of all Exam Repeats is: " + getAverageOfExamRepeats());
	}
	
	// Summing all the Exam Repeats using summingInt() method
	public static int getSumOfExamRepeats() {
		return StudentDb.getAllStudents().stream()
				.collect(summingInt(Student::getExamRepeat));
	}
	
	// Get the Average all the Exam Repeats using averagingInt() method
	public static double getAverageOfExamRepeats() {
		return StudentDb.getAllStudents().stream()
				.collect(averagingInt(Student::getExamRepeat));
	}
}
