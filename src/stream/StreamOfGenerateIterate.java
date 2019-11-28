package stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterate {
	public static void main(String[] args) {
		getStreamOfStringClubs();
		getStreamIterateValues();
		getRandomIntegersGenerated();
	}
	
	// Example of Stream.of() Factory method
	public static void getStreamOfStringClubs() {
		Stream<String> clubsStream = Stream.of("Fc Barcelona", "Tottenham", "Liverpool", "PSG", "Bayern Munich");
		clubsStream.forEach(System.out::println);
	}
	
	// Example of Stream Iterator
	public static void getStreamIterateValues() {
		Stream.iterate(1, Number -> Number * 3)
			.limit(6)
			.forEach(System.out::println);
	}
	
	// Example of Stream Generate Factory method
	public static void getRandomIntegersGenerated() {
		Supplier<Integer> integSupplier = new Random()::nextInt;
		Stream.generate(integSupplier)
			.limit(5)
			.forEach(System.out::println);
	}
}
