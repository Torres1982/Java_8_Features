package data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDb {
	public static Supplier<Student> getStudentSupplier = () -> {
		Student student = new Student("Jerry", 5, 3.4, "male", Arrays.asList("rugby", "table tennis"));
		return student;
	};
	
    public static List<Student> getAllStudents() {
        Student student1 = new Student("Mark", 2, 3.6, "male", Arrays.asList("tennis", "basketball", "volleyball"), 3);
        Student student2 = new Student("Emma", 2, 2.4,"female", Arrays.asList("swimming", "cycling", "soccer"), 2);
        Student student3 = new Student("Gemma", 3, 4.0, "female", Arrays.asList("swimming", "bowling", "aerobics"), 4);
        Student student4 = new Student("Jerry", 3, 3.9, "male", Arrays.asList("swimming", "gymnastics", "soccer"), 1);
        Student student5 = new Student("Sandra", 4, 2.7, "female", Arrays.asList("tennis", "dancing", "football"), 0);
        Student student6 = new Student("Jim", 4, 3.9, "male", Arrays.asList("swimming", "basketball", "baseball", "football"), 5);
        Student student7 = new Student("Joana", 4, 3.4,"female", Arrays.asList("swimming", "jogging", "dancing"), 2);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6, student7);
        return students;
    }
}
