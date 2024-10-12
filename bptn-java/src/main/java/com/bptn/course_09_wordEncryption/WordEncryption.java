package com.bptn.course_09_wordEncryption;

import java.util.Scanner;

public class WordEncryption {

	public static void main(String[] args) {

		// scanner (display) to read the user's input
		Scanner display = new Scanner(System.in);

		// ask the user to enter a word
		System.out.print("Enter a word: ");
		String word = display.nextLine();

		// Encrypt the input word using the shift logic
		String encryptedWord = encryptWord(word);

		// Display the encrypted word
		System.out.println("Encrypted word: " + encryptedWord);
	}

	// Method to encrypt the word by shifting each letter by one position
	public static String encryptWord(String word) {
		StringBuilder encrypted = new StringBuilder();

		// Iterate over every character in the word
		for (int i = 0; i < word.length(); i++) {
			char selectedChar = word.charAt(i);

			// to check if the character is a lowercase letter
			if (selectedChar >= 'a' && selectedChar <= 'z') {
				char shiftedChar = (char) (selectedChar + 1); // Casting
				if (shiftedChar > 'z') {
					shiftedChar = 'a';
				}
				encrypted.append(shiftedChar); // to concate strings
			}

			// to Check if the character is an uppercase letter
			else if (selectedChar >= 'A' && selectedChar <= 'Z') {
				// Shift the character by one
				char shiftedChar = (char) (selectedChar + 1);
				if (shiftedChar > 'Z') {
					shiftedChar = 'A'; // Wrap around to 'A'
				}
				encrypted.append(shiftedChar);
			}
			// Leave non-alphabetic characters unchanged
			else {
				encrypted.append(selectedChar);
			}
		}

		// Return the encrypted word as a string
		return encrypted.toString();
	}
}
