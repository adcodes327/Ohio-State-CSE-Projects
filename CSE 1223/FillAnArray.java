/**
 * Program fills an array with the user's inputs
 */
import java.util.Scanner;

public class FillArray {
	public static void main(String[] args) {

		// Scanner and variable definition
		Scanner scnr = new Scanner(System.in);
		int userInt = 0;

		// Getting the number of values
		System.out.print("Please enter the number of values to be stored: ");
		int numVals = Integer.parseInt(scnr.nextLine());


		if (numVals < 0) { // if user enters a negative number
			System.out.println("ERROR! You must enter a non-negative number of digits!");
		}

		else if (numVals == 0) {  // if user enters 0
			System.out.println("No digits to store? Goodbye!");
		}

		else {  // if user enters a positive integer
			int userArray[] = new int[numVals];
			int i = 0;
			for (i = 0; i < numVals; i++) {
				System.out.print("Enter Integer " + i + ": ");
				userInt = Integer.parseInt(scnr.nextLine());
				userArray[i] = userInt;
				String userVals[] = new String[userInt];
			}

			// Summarizing the user's array
			System.out.println("The contents of your array: ");
			System.out.println("The number of digits in your array: " + i);

			System.out.print("Your array has the values: ");
			for (i = 0; i < numVals; i++) { // for loop is for printing out each individual values
				System.out.print(userArray[i] + " ");
			}
		}
	}
}
