package introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeclarativeProgramming {
	public static void main(String[] args) {
		// Declarative Programming Example using Stream
		int sum = IntStream.rangeClosed(0, 100)
				.sum();
		
		System.out.println("Sum of the integers between the range 0 and 100 is: " + sum);
		
		// Declarative way of listing unique integers
		List<Integer> list = Arrays.asList(1, 1, 2, 2, 2, 3, 4, 5, 6, 7, 7, 8);
		List<Integer> uniqueIntegers = list.stream()
				.distinct()
				//.limit(3)
				.collect(Collectors.toList());
		
		System.out.println("Unique integers of the list are: " + uniqueIntegers);
	}
}
