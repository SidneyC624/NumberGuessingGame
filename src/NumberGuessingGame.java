import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	
	Random random;
	Scanner scanner;
	int guessRange;
	int randomNumber;
	int guess;
	final int triesAllowed = 7;
	int tryCount;
	
	NumberGuessingGame() {
		
		random = new Random();
		scanner = new Scanner(System.in);
		tryCount = 0;
		
		askRange();
		
	}
	
	public void askRange() {
		
		System.out.println("Enter the range of random number (from 1 up to): ");
		guessRange = scanner.nextInt();
		randomNumber = (random.nextInt(guessRange)) + 1;
		
		getGuess();
		
	}
	
	public void getGuess() {
		
		while(tryCount < triesAllowed) {
			
			System.out.println("You have " + (triesAllowed-tryCount) + " tries left");
			System.out.println("Enter an integer guess (1-" + guessRange + "): ");
			guess = scanner.nextInt();
		
			if(guess == randomNumber) {
				System.out.println("Correct! You won");
				System.out.println("It took you " + tryCount + " tries");
				break;
			}
			else if(guess > randomNumber) {
				System.out.println("The number is less than " + guess);
			}
			else {
				System.out.println("The number is greater than " + guess);
			}
			
			tryCount++;
		}
		
		if(tryCount == triesAllowed) {
			System.out.println("Oops, You've used all your chances :(");
		}
		
	}
	
}
