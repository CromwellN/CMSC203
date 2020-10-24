/*Class: CMSC203 CRN 22445
 Program: Assignment 4 Design
 Instructor: Dr.Grinberg
 Summary of Description: lets the user create a management company and add the properties managed by the company to its list.
 Due Date: 10/18/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Cromwell Nzouakeu
*/

public class Property {
	// Class Variables
	private String Name = "";
	private String City = "";
	private String Owner = "";
	private double RentAmount = 0;
	private Plot Plot;
	
	 // constructor
	public Property() {
		this.Plot = new Plot();
	}
	
	//Constructor with String name, String city, Double rent, String owner
	public Property(String name, String city, double rent, String owner) {
		this.Name = name;
		this.City = city;
		this.RentAmount = rent;
		this.Owner = owner;
		this.Plot = new Plot();
	}
	 //Constructor with String name, String city, Double rent, String owner, Int X, Int Y, Int Width, Int Depth
	public Property(String name, String city, double rent, String owner, int X, int Y, int Width, int Depth) {
		this.Name = name;
		this.City = city;
		this.RentAmount = rent;
		this.Owner = owner;
		this.Plot = new Plot(X, Y, Width, Depth);
	}
	 //Constructor to duplicate a property
	public Property(Property P) {
		this.Name = P.getPropertyName();
		this.City = P.getCity();
		this.RentAmount = P.getRentAmount();
		this.Owner = P.getOwner();
		this.Plot = P.getPlot();
	}
	 //Get property name
	public String getPropertyName() { 
		return this.Name; }
	
	 //Get property city
	public String getCity() { 
		return this.City; }
	
	 // Get property owner
	public String getOwner() { 
		return this.Owner; }
	
	 //Get property plot
	public Plot getPlot() { 
		return this.Plot; }
	
	 //Get property rent
	public double getRentAmount() { 
		return this.RentAmount; }
	
	//Set property city
	public void setCity(String city) { 
		this.City = city; }
	
	 //Set property owner
	public void setOwner(String owner) { 
		this.Owner = owner; }
	
	 //Set property rent amount
	public void setRentAmount(double rentAmount) { 
		this.RentAmount = rentAmount; }
	
	 // Set property name
	public void setPropertyName(String PropertyName) { 
		this.Name = PropertyName; }
	
	//Stringify Property
	public String toString() {
		// Variables
		String Return  = "";
		// Append
		Return  += "Property Name: " + this.getPropertyName();
		Return  += "\n" + "Located in " + this.getCity();
		Return  += "\n" + "Belonging to: " + this.getOwner();
		Return  += "\n" + "Rent Amount: " + this.getRentAmount();
		Return  += " ";
		// Return
		return Return;
	}
}