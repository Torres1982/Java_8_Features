package data;

import java.util.Arrays;
import java.util.List;

public class StudentDb {
    public static List<Student> getAllStudents() {
        Student student1 = new Student("Mark", 2, 3.6, "male", Arrays.asList("tennis", "basketball", "volleyball"));
        Student student2 = new Student("Emma", 2, 2.4,"female", Arrays.asList("swimming", "cycling", "soccer"));
        Student student3 = new Student("Gemma", 3, 4.0, "female", Arrays.asList("swimming", "bowling", "aerobics"));
        Student student4 = new Student("Jerry", 3, 3.9, "male", Arrays.asList("swimming", "gymnastics", "soccer"));
        Student student5 = new Student("Sandra", 4, 2.7, "female", Arrays.asList("tennis", "dancing", "football"));
        Student student6 = new Student("Jim", 4, 3.9, "male", Arrays.asList("swimming", "basketball", "baseball", "football"));
        Student student7 = new Student("Joana", 3, 3.4,"female", Arrays.asList("swimming", "jogging", "dancing"));

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6, student7);
        return students;
    }
}
