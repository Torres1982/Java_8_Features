package stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDb;

public class StreamExample {
	public static void main(String [] args) {
		Predicate<Student> gradeLevelPredicate = (student -> student.getGradeLevel() > 2);
		Predicate<Student> gpaPredicate = (student -> student.getGpa() > 2);
		Predicate<Student> namePredicate = (student -> student.getName().startsWith("J"));
		Predicate<Student> genderFemalePredicate = (student -> student.getGender().equals("female"));
		Predicate<Student> activityPredicate = (student -> student.getActivities().contains("swimming"));
		
		Map<String, List<String>> studentActivitiesMap = StudentDb.getAllStudents().stream()
				// Peak method used to debug the Stream
				.peek(student -> {
					System.out.println("\nFirst Filter:" + student);
				})
				.filter(gradeLevelPredicate)
				.filter(gpaPredicate)
				.filter(activityPredicate)
				.filter(namePredicate)
				.peek(student -> {
					System.out.println("\nName Predicate Filter:" + student);
				})
				.filter(genderFemalePredicate)
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		
		System.out.println("\n" + studentActivitiesMap);
	}
}
