
//Promise Ekpe
//Assignment 2
import java.util.Scanner;

public class BookInventory {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		long isbn, nextDigits, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13;
		int numOfBooks = 0, booksReturned = 0, booksChecked = 0;

		System.out.println("*         Assignment 2 by Promise Ekpe         *");
		System.out.println();
		System.out.println("************************************************");
		System.out.println("* Welcome to the Daily Book Inventory Program! *");
		System.out.println("************************************************");

		// I made my whole program a Do-While loop
		do {
			System.out.println("Enter the first 12 digits " + "of an ISBN-13 as a string: ");
			isbn = input.nextLong();

			// This allows a user to exit the loop and end the program
			// Input Validation to make sure only 12 digits are entered by user
			if ((isbn >= 1E11) && (isbn <= 999999999999L)) {
				// I created a variable that holds the remaining digits
				// whenever I remove the first digit to get each individual digits
				d1 = (long) (isbn / 1E11);
				nextDigits = (long) (isbn % 1E11);
				d2 = (long) (nextDigits / 1E10);
				nextDigits = (long) (nextDigits % 1E10);
				d3 = (long) (nextDigits / 1E9);
				nextDigits = (long) (nextDigits % 1E9);
				d4 = (long) (nextDigits / 1E8);
				nextDigits = (long) (nextDigits % 1E8);
				d5 = (long) (nextDigits / 1E7);
				nextDigits = (long) (nextDigits % 1E7);
				d6 = (long) (nextDigits / 1E6);
				nextDigits = (long) (nextDigits % 1E6);
				d7 = (long) (nextDigits / 1E5);
				nextDigits = (long) (nextDigits % 1E5);
				d8 = (long) (nextDigits / 1E4);
				nextDigits = (long) (nextDigits % 1E4);
				d9 = (long) (nextDigits / 1E3);
				nextDigits = (long) (nextDigits % 1E3);
				d10 = (long) (nextDigits / 100);
				nextDigits = (long) (nextDigits % 100);
				d11 = (long) (nextDigits / 10);
				nextDigits = (long) (nextDigits % 10);
				d12 = nextDigits;

				// Formula I got from the textbook on page 203 to calculate the checksum d13
				// variable
				d13 = 10 - (d1 + (3 * d2) + d3 + (3 * d4) + d5 + (3 * d6) + d7 + (3 * d8) + d9 + (3 * d10) + d11
						+ (3 * d12)) % 10;

				// I wrote this section because I get 14 digits whenever i input 9780132130790
				// from the second example in the textbook
				if (d13 > 9) {
					d13 = 0;
				}
				;

				System.out.println(
						"THe ISBN-13 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10 + d11 + d12 + d13);

				System.out.println();
				System.out.println();
				// Get user input "R" or "C" on whether the book is getting returned or checked out
				System.out.print("Enter 'R' for return or 'C' for check out: ");
				Scanner text = new Scanner(System.in);
				String response = text.next();

				// Different response
				if (response.equals("R") || response.equals("r")) 
				{
					numOfBooks++; // increment number of books
					booksReturned++; // increment number of books returned

				} 
				else if (response.equals("C") || response.equals("c")) 
				{
					numOfBooks++; // increment number of books
					booksChecked++; // increment number of books checked out
				} 
					else 
				{
					// Loop until user inputs 'R' or 'C'
					while (!response.equals("R") || !response.equals("r") || !response.equals("C")
							|| !response.equals("c")) {
						System.out.print("Invalid input! Enter 'R' for return or 'C' for check out: ");
						response = text.next();

						if (response.equals("R") || response.equals("r")) 
						{
							numOfBooks++; // increment number of books
							booksReturned++; // increment number of books returned
							break;

						} else 
							if (response.equals("C") || response.equals("c")) 
						{
							numOfBooks++; // increment number of books
							booksChecked++; // increment number of books checked out
							break;
						}
					}
				};
				
				System.out.println("************************************************");
				System.out.println("*              Daily Book Inventory            *");
				System.out.println("************************************************");
				System.out.println("Number of books returned:      " + booksReturned);
				System.out.println("Number of books checked out:   " + booksChecked);
				System.out.println("The total of books processed:  " + numOfBooks);
				System.out.println("************************************************");

				//Get user input for "Y" or "N"
				System.out.print("Enter 'Y' to continue, 'N' to quit: ");
				response = text.next();

				if (response.equals("N") || response.equals("n")) 
				{
					System.out.println();
					System.out.println("************************************************");
					System.out.println("*              Daily Book Inventory            *");
					System.out.println("************************************************");
					System.out.println("Number of books returned:      " + booksReturned);
					System.out.println("Number of books checked out:   " + booksChecked);
					System.out.println("The total of books processed:  " + numOfBooks);
					System.out.println("************************************************");

					break;
				} else 
					if (response.equals("Y") || response.equals("y")) 
				{	
					System.out.println();
					continue;
				}
			} 
			else 
			{ // to check when an invalid input is entered

				System.out.println(isbn + " is an Invalid ISBN-13 number! Try again.");
			};

		} while (isbn != 0);

	
	}
}