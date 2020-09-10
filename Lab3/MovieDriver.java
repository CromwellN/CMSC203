/**
*Class: CMSC203 CRN 22445
*Program: Lab 3 
*Instructor: Dr.Grinberg
Summary of Description: Driver and Data Element Driver to test a class.
*Due Date: 09/13/2020
*Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
*/
import java.util.Scanner;
public class MovieDriver {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		Movie movie = new Movie();
		String name, rating, empty, anotherMovie;
		int tickets;
		boolean flag = true;
		do {
			System.out.println("Enter the name of a movie");
			name = input.nextLine();
			movie.setTitle(name);
			System.out.println("Enter the rating of a movie");
			rating = input.nextLine();
			movie.setRating(rating);
			System.out.println("Enter the number of tickets sold for the movie:");
			tickets = input.nextInt();
			movie.setSoldTickets(tickets);
			System.out.println(name +"(" + rating + "): Tickets Sold:" + tickets);
			empty = input.nextLine();
			System.out.println("\nDo you want to eneter another movie? (Y or N):");
			anotherMovie = input.nextLine();
			if (anotherMovie.equalsIgnoreCase("N")) {
				flag = false;
			}
			
		}while (flag ==true);
		System.out.println("\nGoodbye");
		input.close();
	}
}
