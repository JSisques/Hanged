package program;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Program test = new Program();

		// The user puts a initial word to be guessed
		System.out.print("Insert your initial word: ");
		String userWord = scan.nextLine().toUpperCase();
		int userWordLength = userWord.length();

		// We create an array to get the singular characters
		String[] wordInArray = test.convertWordToArray(userWord);
		String[] userResult = test.convertWordToSharp(userWord);

		int lifes = 5;

		// To clean the console
		for (int i = 0; i < 1000; i++) {
			System.out.println();
		}
		
		System.out.println("This is the word:");
		for (int i = 0; i < userResult.length; i++) {
			System.out.print(userResult[i] + " ");
		}
		System.out.println("");

		int count = 0;
		boolean stop = false;
//		do {
//			if ((lifes == 0) || (count == userWordLength - 1)) {
//				stop = true;
//			}
//			System.out.print("Insert a letter: ");
//			String letter = scan.nextLine().toUpperCase();
//
//			if (userWord.contains(letter)) {
//				for (int i = 0; i < userResult.length; i++) {
//					if (letter.equalsIgnoreCase(wordInArray[i])) {
//						userResult[i] = letter;
//						count++;
//					}
//				}
//			} else {
//				lifes--;
//			}
//
//			for (int i = 0; i < userResult.length; i++) {
//				System.out.print(userResult[i] + " ");
//			}
//			System.out.println("");
//
//			System.out.printf("You have %d lifes\n", lifes);
//
//		} while (stop == false);

		while (stop == false) {
			System.out.printf("You have %d lifes\n", lifes);
			if ((lifes == 0) || (count == userWordLength - 1)) {
				stop = true;
			}
			System.out.print("Insert a letter: ");
			String letter = scan.nextLine().toUpperCase();

			if (userWord.contains(letter)) {
				for (int i = 0; i < userResult.length; i++) {
					if (letter.equalsIgnoreCase(wordInArray[i])) {
						userResult[i] = letter;
						count++;
					}
				}
			} else {
				lifes--;
			}

			for (int i = 0; i < userResult.length; i++) {
				System.out.print(userResult[i] + " ");
			}
			System.out.println("");
		}
		
		if (lifes < 0) {
			System.out.print("The word was: " + userWord);
		}

	}

	/**
	 * This method returns an array of the word that is given
	 * 
	 * @param word
	 * @return An array which in every position has a single character
	 */

	public String[] convertWordToArray(String word) {
		String[] wordInArray = new String[word.length()];
		for (int i = 0; i < word.length(); i++) {
			String letter = word.substring(i, i + 1);
			wordInArray[i] = letter;
		}
		return wordInArray;

	}

	/**
	 * 
	 * @param word
	 * @return An array that we have to replace
	 */

	public String[] convertWordToSharp(String word) {
		String[] wordInSharp = new String[word.length()];
		for (int i = 0; i < word.length(); i++) {
			wordInSharp[i] = "#";
		}
		return wordInSharp;

	}

}
