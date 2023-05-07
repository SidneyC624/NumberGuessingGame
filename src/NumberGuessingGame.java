import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	
	Random random;
	Scanner scanner;
	int guessRange;
	int randomNumber;
	int triesAllowed;
	int tryCount;
	
	NumberGuessingGame() {
		
		random = new Random();
		scanner = new Scanner(System.in);
		triesAllowed = 7;
		tryCount = 0;
		
		askRange();
		
	}
	
	public void askRange() {
		
		do {
			System.out.println("Enter the range of the random number (from 1 up to): ");
		}
		while(scanner.hasNextInt());
		
		guessRange = scanner.nextInt();
		getGuess();
		
	}
	
	public void getGuess() {
		
		do {
			System.out.println("Enter a guess between 1 and " + guessRange + " : ");
		}
		while(scanner.hasNextInt());
	}
	
}
