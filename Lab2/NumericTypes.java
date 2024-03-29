/**
*Class: CMSC203 CRN 22445
*Program: Lab 2
*Instructor: Dr.Grinberg
Summary of Description: Java Fundamentals demonstrates how numeric types and operators behave in Java
*Due Date: 09/13/2020
*Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
*/
import java.util.Scanner;
/**
   This program demonstrates how numeric types and operators behave in Java
*/
public class NumericTypes {
	public static void main (String [] args) {
		
		//TASK #2 Create a Scanner object here 
		Scanner scanner = new Scanner(System.in);
		
		//identifier declarations
		final int NUMBER = 2; // number of scores
		int score1 = 100; // first test score
		int score2 = 95; // second test score
		final int BOILING_IN_F = 212; // boiling temperature
		double fToC; // temperature in Celsius
		double average; // arithmetic average
		String output; // line of output to print out
		
		//Task #2 declare a variable to hold the user�s temperature
		int temperature;
		//Task #2 prompt user to input score1
		System.out.println("Enter Score 1: ");
		//Task #2 read score1 
		score1 = scanner.nextInt();
		//Task #2 prompt user to input score2
		System.out.println("Enter Score 2: ");
		//Task #2 read score2
		score2 = scanner.nextInt();

		// Find an arithmetic average
		average = ((double)score1 + score2) / NUMBER;
		output = score1 + " and " + score2 + " have an average of " + average;	
		System.out.println(output);
		
		// Convert Fahrenheit temperatures to Celsius
		fToC = ((double)5/9) * (BOILING_IN_F - 32);
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		
		//Task #2 prompt user to input another temperature
		System.out.println("Enter another temperature");
		//Task #2 read the user�s temperature in Fahrenheit
		temperature = scanner.nextInt();
		//Task #2 convert the user�s temperature to Celsius
		fToC = ((double)5/9) * (temperature- 32);
		output = ("Your temperature in celsius is ") + fToC;
		//Task #2 print the user�s temperature in Celsius
		System.out.println(output);
		
		System.out.println("Goodbye"); // to show that the program is ended	
	}
}