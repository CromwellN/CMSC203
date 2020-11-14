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
   private String city;
   private String owner;
   private String propertyName;
   private double rentAmount;
   private Plot plot;
   
   // constructor
   public Property(){
       this.city = "";
       this.owner = "";
       this.propertyName = "";
       this.rentAmount = 0;
       this.plot = new Plot();
   }
   
   // Constructor to duplicate a property
   public Property (Property p) {
       this.city = p.city;
       this.owner = p.owner;
   this.propertyName = p.propertyName;
   this.rentAmount = p.rentAmount;
   this.plot = new Plot(p.plot);
   }
   
   // Constructor with String name, String city, Double rent, String owner
   public Property(String propertyName, String city, double rentAmount, String owner) {
       this.propertyName = propertyName;
       this.city = city;
       this.owner = owner;
       this.rentAmount = rentAmount;
       this.plot = new Plot();
   }
   
   // Constructor with String name, String city, Double rent, String owner, 
   //Int X,Int Y, Int Width, Int Depth
   public Property(String propertyName, String city, double rentAmount, String owner,
           int x, int y, int width, int depth) {
       this.propertyName = propertyName;
       this.city = city;
       this.owner = owner;
       this.rentAmount = rentAmount;
       this.plot = new Plot(x, y, width, depth);
   }
   
    // Get property name and return propertyName
   public String getPropertyName(){
       return propertyName;
   }
   
   // Set property name
   public void setPropertyName(String propertyName){
       this.propertyName = propertyName;
   }
   
  // Get property plot and return city
   public String getCity(){
       return city;
   }
   
   // Set property city
   public void setCity(String city){
       this.city = city;
   }
   
  // Get property owner and return owner
   public String getOwner(){
       return owner;
   }
   // Set property owner
   public void setOwner(String owner){
       this.owner = owner;
   }
   
   // Get property rent and return rentAmount
   public double getRentAmount(){
       return rentAmount;
   }
   
   // Set property rent amount
   public void setRentAmount(double rentAmount){
       this.rentAmount = rentAmount;
   }
   
   // Get property plot and return plot
   public Plot getPlot(){
       return plot;
   }
   
   // Set plot values and return Plot(x, y, width, depth) 
   public Plot setPlot(int x, int y, int width, int depth){
       return new Plot(x, y, width, depth);
   }
   
   // Text Property and return string
   public String toString(){
       return "Property Name: " + propertyName + "\nLocated in city: " + city + "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount;
   }
}