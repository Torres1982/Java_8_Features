package lambda;

import java.lang.Runnable;

public class Lambda {
	public static void main(String[] args) {
		// Imperative way of the Runnable interface
		Runnable runnable = new Runnable() {		
			@Override
			public void run() {
				System.out.println("Runnable is running!");
			}
		};
		
		new Thread(runnable).start();
		
		// Use the Lambda for Runnable
		Runnable lambdaRunnable = () -> {
			System.out.println("Lambda Runnable 1 Example is running!");
		};
		
		new Thread(lambdaRunnable).start();
		
		// More concise example of Lambda expression
		Runnable lambdaRunnableTwo = () -> System.out.println("Lambda Runnable 2 Example is running!");
		new Thread(lambdaRunnableTwo).start();
		
		// Even more concise example
		new Thread(() -> System.out.println("Lambda Runnable 3 Example is running!")).start();
	}
}
