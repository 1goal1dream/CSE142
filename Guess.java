
// Thomas You
// CSE 142
// 4/12/17
// creates a guessing game.

import java.util.Random;
import java.util.Scanner;

public class Guess {
	public static final int MAX_NUM = 100;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		int totalGames = 0;
		int totalGuesses = 0;
		int bestGame = 9999;
		int newGame = 0;
		String playAgain = "y";
		intro();
		while (playAgain.toLowerCase().startsWith("y")) { // new game
			newGame = game(console, rand);
			if (newGame < bestGame) {
				bestGame = newGame;
			}
			totalGuesses += newGame;
			totalGames++;
			playAgain = console.next();
			System.out.println();
		}
		results(totalGames, totalGuesses, bestGame);
	}

	// introduction to the guessing game.
	public static void intro() {
		System.out.println("This program allows you to play a guessing game.");
		System.out.println("I will think of a number between 1 and");
		System.out.println("100 and will allow you to guess until");
		System.out.println("you get it.  For each guess, I will tell you");
		System.out.println("whether the right answer is higher or lower");
		System.out.println("than your guess.\n");
	}

	// asks user for input to guess the unknown number. Gives hint on whether
	// the guess is higher or lower
	// than the actual number. Plays a single game.
	public static int game(Scanner console, Random rand) {
		System.out.println("I'm thinking of a number between 1 and 100...");
		int number = rand.nextInt(MAX_NUM) + 1;
		int guesses = 1;
		int guess = -1;
		while (guess != number) {
			System.out.print("Your guess? ");
			guess = console.nextInt();
			if (guess > number) {
				System.out.println("It's lower.");
				guesses++;
			} else if (guess < number) {
				System.out.println("It's higher.");
				guesses++;
			} else if (guess == number) {
				if (guesses == 1) {
					System.out.println("You got it right in 1 guess");
				} else {
					System.out.println("You got it right in " + guesses + " guesses");
				}
				System.out.print("Do you want to play again? ");
				;
				return guesses;
			}
		}
		return -1;
	}

	// reports the results of the guessing game involving the user's amount of
	// guesses, number of games played
	// and also the lowest number of guesses required to match the correct
	// number.
	public static void results(int totalGames, int totalGuesses, int bestGame) {
		double avgGuesses = Math.round(10.0 * totalGuesses / totalGames) / 10.0;
		System.out.println("Overall results: ");
		System.out.println("    total games   = " + totalGames);
		System.out.println("    total guesses = " + totalGuesses);
		System.out.println("    guesses/game  = " + avgGuesses);
		System.out.println("    best game     = " + bestGame);
	}
}
