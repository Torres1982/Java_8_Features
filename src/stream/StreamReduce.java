package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduce {
	public static void main(String[] args) {
		// Use Optionals with an Identity
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 5, 6, 8, 12);
		System.out.println(multiplyIntegers(listOfIntegers));
		
		// Use an Optionals Without Identity
		Optional<Integer> optionalResult = multiplyIntegersWithoutIdentity(listOfIntegers);
		System.out.println(optionalResult);
		System.out.println("Is Result Present: " + optionalResult.isPresent());
		
		if (optionalResult.isPresent()) {
			System.out.println("Result: " + optionalResult.get());
		}
		
		
		// Use Optionals and an empty List
		List<Integer> emptyList = new ArrayList<>(); 
		Optional<Integer> optionalEmpty = multiplyIntegersWithoutIdentity(emptyList);
		System.out.println("Is Result Present: " + optionalEmpty.isPresent());
		
		if (optionalEmpty.isPresent()) {
			System.out.println("Result: " + optionalEmpty.get());
		}
	}
	
	// Multiply all values of the List using Stream and reduce operation
	// 1 in the reduce is an identity
	public static int multiplyIntegers(List<Integer> list) {
		return list.stream()
				.reduce(1, (a, b) -> a * b);
	}
	
	// Multiply all values of the List using reduce operation without identity
	public static Optional<Integer> multiplyIntegersWithoutIdentity(List<Integer> list) {
		return list.stream()
				.reduce((a, b) -> a * b);
	}
}
