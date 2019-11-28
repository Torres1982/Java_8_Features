package stream;

import java.util.function.Predicate;

import data.Student;
import data.StudentDb;

/**
 * Use anyMatch(), allMatch(), and noneMatch() operations
 */
public class StreamMatch {
	private static String studentName = "Emma";
	private static Predicate<Student> examRepeatsPredicateLessThanSix = (student -> student.getExamRepeat() < 6);
	private static Predicate<Student> examRepeatsPredicateEqualsThree = (student -> student.getExamRepeat() == 3);
	private static Predicate<Student> namePredicate = (student -> student.getName().equals(studentName));
	
	public static void main(String[] args) {
		System.out.println("Do all Students have less than 6 exams to repeat? - " + isAllMatch());
		System.out.println("Are there any Students that have to repeat exactly 3 exams? - " + isAnyMatch());
		System.out.println("There are no any Students whose name is " + studentName + " - " + isNoneMatch());
	}
	
	// Test allMatch() Stream operation
	public static boolean isAllMatch() {
		return StudentDb.getAllStudents().stream()
				.allMatch(examRepeatsPredicateLessThanSix);
	}
	
	// Test anyMatch() Stream operation
	public static boolean isAnyMatch() {
		return StudentDb.getAllStudents().stream()
				.anyMatch(examRepeatsPredicateEqualsThree);
	}
	
	// Test noneMatch() Stream operation
	public static boolean isNoneMatch() {
		return StudentDb.getAllStudents().stream()
				.noneMatch(namePredicate);
	}
}
