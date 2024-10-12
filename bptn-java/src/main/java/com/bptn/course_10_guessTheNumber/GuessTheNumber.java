package com.bptn.course_10_guessTheNumber;

import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {
		// Initialize a Scanner object to capture user input
		Scanner display = new Scanner(System.in);

		// printout the target number to display
		System.out.println("targetNumber: " + 23);

		// Ask the user to make a guess
		System.out.print("guess: ");

		// Capture the user's input as an integer
		int num = display.nextInt();

		// Check if user's guess is higher than the target number
		if (num > 23) {
			System.out.println("Too high! Try again.");
		}

		// Check if the user's guess is same as the target number
		else if (num == 23) {
			System.out.println("Congratulations! You guessed the number correctly!");
		}

		// If the guess is neither too high nor correct, it's lower
		else {
			System.out.println("Too low! Try again.");

		}
		// close scanner
		display.close();

	}
}
