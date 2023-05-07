import java.util.InputMismatchException;
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
		guessRange = 0;
		tryCount = 0;
		
		askRange();
		
	}
	
	public void askRange() {
		do {
			try {
				System.out.println("Enter an integer greater than or equal to 10: ");
				guessRange = scanner.nextInt();
				randomNumber = (random.nextInt(guessRange)) + 1;
				
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input");
			}
			finally {
				scanner.nextLine();
			}
		}
		while(guessRange <= 1);
		
		getGuess();
		
	}
	
	public void getGuess() {
		
		while(tryCount < triesAllowed) {
			guess = 0;
			do {
				try {
					System.out.println("You have " + (triesAllowed-tryCount) + " tries left");
					System.out.println("Enter an integer guess (1-" + guessRange + "): ");
					guess = scanner.nextInt();
					
					break;
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid input");
				}
				finally {
					scanner.nextLine();
				}
			}
			while(!(guess >= 1 && guess <= guessRange));
			
		
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
