package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceMinMax {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(17, 7, 5, 6, 8, 12, 3, 24, 9, 10);
		List<Integer> emptyList = new ArrayList<>(); 
		Optional<Integer> maxValue = getMaxValue(listOfIntegers);
		Optional<Integer> minValue = getMinValue(listOfIntegers);
		Optional<Integer> emptyListMinValue = getMinValue(emptyList);
		
		String maxValueFound = maxValue.isPresent() ? "Max Value is: " + maxValue.get() : "Cannot find the Maximum Value. The List is Empty!";
		String minValueFound = minValue.isPresent() ? "Min Value is: "+ minValue.get() : "Cannot find the Minimum Value. The List is Empty!";
		String emptyListMinValueFound = emptyListMinValue.isPresent() ? "Min Value is: "+ emptyListMinValue.get() : "Cannot find the Minimum Value. The List is Empty!";
		
		System.out.println(maxValueFound + "\n" + minValueFound + "\n" + emptyListMinValueFound);
	}
	
	// Find the Maximum integer in the List using Optionals
	public static Optional<Integer> getMaxValue(List<Integer> list) {
		return list.stream()
				.reduce((firstNumber, secondNumber) -> firstNumber > secondNumber ? firstNumber : secondNumber);
	}
	
	// Find the Minimum integer in the List using Optionals
	public static Optional<Integer> getMinValue(List<Integer> list) {		
		return list.stream()
				.reduce((firstNumber, secondNumber) -> firstNumber < secondNumber ? firstNumber : secondNumber);
	}
}
