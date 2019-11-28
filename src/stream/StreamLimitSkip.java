package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkip {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(1, 4, 5, 6, 8, 12, 13, 24, 29, 30);
		Optional<Integer> sum = sumOfIntegersLimited(listOfIntegers);
		String sumOfThreeFirstValues = sum.isPresent() ? "The sum of three first values is: " + sum.get() : "The List is Empty!";
		
		System.out.println(sumOfThreeFirstValues);
	}
	
	// Limit the number of integers taken from the List
	public static Optional<Integer> sumOfIntegersLimited(List<Integer> list){
		return list.stream()
				.skip(2)
				.limit(3)
				.reduce((firstNum, secondNum) -> firstNum + secondNum);
	}
}
