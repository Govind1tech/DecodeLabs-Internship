import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Game!");

        while (playAgain) {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1; // Generates a number from 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + roundsPlayed + " ---");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Inner loop for guessing the number
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                
                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        // Calculate score based on remaining attempts
                        totalScore += (maxAttempts - attempts + 1); 
                        guessedCorrectly = true;
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); // Consume the invalid input to avoid an infinite loop
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score is: " + totalScore);

            // Ask if the user wants to play another round
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        // Final summary
        System.out.println("\n=== Game Over ===");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}