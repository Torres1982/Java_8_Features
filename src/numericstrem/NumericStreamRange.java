package numericstrem;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRange {
	public static void main(String[] args) {
		System.out.println(IntStream.range(1, 20).count());
		IntStream.range(1, 10).forEach(System.out::println);
		System.out.println(IntStream.rangeClosed(1, 20).count());
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		// Sum method
		System.out.println("Sum of the Range between 1 and 50 is: " + IntStream.rangeClosed(1, 30).sum());
		
		// Maximum method
		OptionalInt maxValue = IntStream.rangeClosed(1, 30).max();
		String isMaxFoundString = maxValue.isPresent() ? "The Max Value of the Range between 1 and 30 is: " + maxValue.getAsInt() : "The Range List is Empty!";
		System.out.println(isMaxFoundString);
		
		// Minimum method
		OptionalLong minValue = LongStream.rangeClosed(20,  75).min();
		String isMinFoundString = minValue.isPresent() ? "The Min Value of the Range between 20 and 75 is: " + minValue.getAsLong() : "The Range List is Empty!";
		System.out.println(isMinFoundString);
		
		// Average method
		OptionalDouble averageValue = IntStream.rangeClosed(20,  75).asDoubleStream().average();
		String isAverageFoundString = averageValue.isPresent() ? "The Average Value of the Range between 20 and 75 is: " + averageValue.getAsDouble() : "The Range List is Empty!";
		System.out.println(isAverageFoundString);
	}
}
