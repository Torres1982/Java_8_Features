package functionalinterfaces;

import java.util.Comparator;

public abstract class ComparatorLambda implements Comparator<Integer> {
	public static void main(String[] args) {
		// Using Comparator before Java 8
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};		
		System.out.println("Comparison of two Integers: " + comparator.compare(23, 5));
		
		// Using Comparator with Lambda (Java 8+)
		Comparator<Integer> comparatorLambda = (number1, number2) -> number1.compareTo(number2);
		System.out.println("Comparison of two Integers: " + comparatorLambda.compare(3, 5));
	}
}
