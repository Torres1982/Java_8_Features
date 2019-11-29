package functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import data.Student;
import data.StudentDb;

public class BiConsumerExample {
	public static void main(String[] args) {
		List<Student> listOfStudents = StudentDb.getAllStudents();
		getStudentNamesAndActivities(listOfStudents);
		
		getSumBiConsumerValues()
		.andThen(getSubtractionBiConsumerValues())
		.andThen(getMultiplicationOfBiConsumerValues())
		.andThen(getDivisionOfBiConsumerValues()).accept(15, 3);
		;
	}
	
	// Sum of BiConsumer Function Interface
	public static BiConsumer<Integer, Integer> getSumBiConsumerValues() {
		BiConsumer<Integer, Integer> sumOfConsumer = (firstNum, secondNum) -> {
			System.out.println("Sum of BiConsumer is: " + (firstNum + secondNum));
		};
		return sumOfConsumer;
	}
	
	// Subtraction of BiConsumer Function Interface
	public static BiConsumer<Integer, Integer> getSubtractionBiConsumerValues() {
		BiConsumer<Integer, Integer> subtractionOfConsumer = (firstNum, secondNum) -> {
			System.out.println("Subtraction of BiConsumer is: " + (firstNum - secondNum));
		};
		return subtractionOfConsumer;
	}
	
	// Multiplication of BiConsumer Function Interface
	public static BiConsumer<Integer, Integer> getMultiplicationOfBiConsumerValues() {
		BiConsumer<Integer, Integer> multiplicationOfBiConsumer = (firstNum, secondNum) -> {
			System.out.println("Multiplication of BiConsumer is: " + (firstNum * secondNum));
		};
		return multiplicationOfBiConsumer;
	}
	
	// Division of BiConsumer Function Interface
	public static BiConsumer<Integer, Integer> getDivisionOfBiConsumerValues() {
		BiConsumer<Integer, Integer> divisionOfBiConsumer = (firstNum, secondNum) -> {
			System.out.println("Division of BiConsumer is: " + (firstNum / secondNum));
		};
		return divisionOfBiConsumer;
	}
	
	// Student names and activities BiConsumer
	public static void getStudentNamesAndActivities(List<Student> list) {
		BiConsumer<String, List<String>> studentBiConsumer = (names, activities) -> System.out.println(names + " - " + activities);
		list.forEach(student -> studentBiConsumer.accept(student.getName(), student.getActivities()));
	}
}
