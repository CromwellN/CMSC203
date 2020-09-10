/**
*Class: CMSC203 CRN 22445
*Program: Lab 2
*Instructor: Dr.Grinberg
Summary of Description: Purpose of the program can calculate the volume of a sphere
*Due Date: 09/13/2020
*Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
*/
import java.util.Scanner;

public class SphereVolume {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double diameter, volume, radius;
		
		//Print the purpose of the program 
		System.out.println("Purpose of the program can calculate the volume of a sphere.\n");
		
		// Print a prompt asking for the diameter of a sphere 
		System.out.println("Enter the diameter of your sphere: ");
		//Read the diameter 
		diameter = scanner.nextDouble();
		
		// Calculate the radius as diameter divided by 2 
		radius = ((diameter));
		
		// Calculate volume of the sphere using the 
		volume = (double)(4.0 / 3) * Math.PI * Math.pow(radius, 3);
		
		// Print the volume 
		System.out.println("The Volume is " + (volume));
	}
}