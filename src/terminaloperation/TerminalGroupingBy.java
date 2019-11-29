package terminaloperation;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import data.Student;
import data.StudentDb;

public class TerminalGroupingBy {	
	public static void main(String[] args) {
		groupStudentsByGender();
		customiseGroupingStuddentsByGpa();
		complexGroupingByGradeLevelAndExamRepeats();
		complexGroupingByGradeLevelAndNames();
		groupByGradeAndGpaWithMaxBy();
		groupByGradeAnExamRepeatsWithMinBy();
	}
	
	// Group Students according to the Gender
	public static void groupStudentsByGender() {
		Map<String, List<Student>> mapOfStudents = StudentDb.getAllStudents().stream()
				.collect(groupingBy(Student::getGender));
		
		System.out.println("Grouping Students by Gender: " + mapOfStudents);
	}
	
	// Customised Grouping of Students by GPA
	public static void customiseGroupingStuddentsByGpa() {
		Map<String, List<Student>> mapOfStudents = StudentDb.getAllStudents().stream()
				.collect(groupingBy((student) -> student.getGpa() >= 3.25 ? "First Class Honours" : "Second Class Grade"));
		
		System.out.println("Grouping Students by GPA: " + mapOfStudents);
	}
	
	// Two conditions for Grouping by Students Levels
	public static void complexGroupingByGradeLevelAndExamRepeats() {
		Map<Integer, Integer> mapOfStudents = StudentDb.getAllStudents().stream()
				.collect(groupingBy(Student::getGradeLevel, summingInt(Student::getExamRepeat)));
		
		System.out.println("Grouping Students by Grade Level and Exam repeats: " + mapOfStudents);
	}
	
	// Grouping Students by Grade Level and their Names
	public static void complexGroupingByGradeLevelAndNames() {
		Map<Integer, List<String>> mapOfStudents = StudentDb.getAllStudents().stream()
				.collect(groupingBy(Student::getGradeLevel, mapping(Student::getName, toList())));
		
		System.out.println("Grouping Students by Grade Level and Exam repeats: " + mapOfStudents);
	}
	
	// Group Students by Grade Level and get The Highest GPA for each Grade Level
	public static void groupByGradeAndGpaWithMaxBy() {
		Map<Integer, Student> mapOfStudents = StudentDb.getAllStudents().stream()
				.collect(groupingBy(Student::getGradeLevel, collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		
		System.out.println("Group Students by Grade Level and get the Student with the Highest GPA for each Grade: " + mapOfStudents);
	}
	
	// Group Students by Grade Level and get the student with least Exam Repeats for each Grade Level
	public static void groupByGradeAnExamRepeatsWithMinBy() {
		Map<Integer, Student> mapOfStudents = StudentDb.getAllStudents().stream()
				.collect(groupingBy(Student::getGradeLevel, collectingAndThen(minBy(Comparator.comparing(Student::getExamRepeat)), Optional::get)));
		
		System.out.println("Group Students by Grade Level and get the Student with the Least number of Exam Repeats for each Grade: " + mapOfStudents);
	}
}
