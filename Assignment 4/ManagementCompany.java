/*Class: CMSC203 CRN 22445
 Program: Assignment 4 Design
 Instructor: Dr.Grinberg
 Summary of Description: lets the user create a management company and add the properties managed by the company to its list.
 Due Date: 10/18/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Cromwell Nzouakeu
*/

public class ManagementCompany {
	// Class Configuration
   private int MAX_PROPERTY = 5;
   private int MGMT_WIDTH = 10;
   private int MGMT_DEPTH = 10; 
  
   // Class Variables
   private double mgmFeePer;
   private String name;
   private Property[] properties;
   private String taxID;
   private Plot plot;
   
   // Returns the management company name
   public String getName(){
       return name;
   }
   /**
   * Set name
   * @param name
   */
   public void setName(String name)
   {
       this.name = name;
   }
   /**
   * Get mgmFeePer
   * @return mgmFeePer
   */
   public double getMgmFeePer()
   {
       return mgmFeePer;
   }
   /**
   * Set mgmFeePer
   * @param mgmFeePer
   */
   public void setMgmFeePer(double mgmFeePer){
       this.mgmFeePer = mgmFeePer;
   }
  
   // Get taxID
   public String getTaxID(){
       return taxID;
   }
   
   //Set taxID(String taxID)
   public void setTaxID(String taxID){
       this.taxID = taxID;
   }
   
   // Returns the management property 
   public Plot getPlot(){
       return plot;
   }
   
   // Set Plot(int x, int y, int width, int depth) and return plot
   public Plot setPlot(int x, int y, int width, int depth){
       plot = new Plot(x, y, width, depth);
       return plot;
   }
   
   // Get mgmt_width and return mgmt_width
   public int getMGMT_WIDTH(){
       return MGMT_WIDTH;
   }
  
   // Get mgmt_depth and return mgmt_depth
   public int getMGMT_DEPTH(){
       return MGMT_DEPTH;
   }
   
   // Empty constructor No-Arg constructor that passes default values
   public ManagementCompany(){
       this.name = "";
       this.taxID = "";
       this.mgmFeePer = 0;
       this.plot = new Plot(0, 0, 10, 10);
       properties = new Property[MAX_PROPERTY];
   }
   
   // Constructor that passes parameter values String Name, String TaxId, double mgmFee
   public ManagementCompany(String name, String taxID, double mgmFee){
       this.name = name;
       this.taxID = taxID;
       this.mgmFeePer = mgmFee;
       this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
       this.properties = new Property[MAX_PROPERTY];
   }
   
   // Constructor that passes parameter values String Name, String TaxId, double MagemeCompy, int x, int y, int Width, int Depth
   public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){
       this.name = name;
       this.taxID = taxID;
       this.mgmFeePer = mgmFee;
       this.plot = new Plot(x,y,width,depth);
       this.properties = new Property[MAX_PROPERTY];
   }
   
   // Constructor that creates new object with passed object values otherCompany
   public ManagementCompany(ManagementCompany otherCompany){
       this.name = otherCompany.name;
       this.taxID = otherCompany.taxID;
       this.mgmFeePer = otherCompany.mgmFeePer;
       this.plot = new Plot(otherCompany.plot);
       this.properties = new Property[MAX_PROPERTY];

   }
   
   // Returns the max amount of properties
   public int getMAX_PROPERTY(){
       return MAX_PROPERTY;
   }
   
    // Add property (Property) and return conditional values
   public int addProperty(Property property){
       if(property == null) {
           return -2;
       }
       if(!plot.encompasses(property.getPlot())){
           return -3;
       }
       for (int i = 0;i < properties.length; i++) {
           if (properties[i] != null) {
               if(properties[i].getPlot().overlaps(property.getPlot())) {
                   return -4;
               }
           }
           else {
               properties[i] = property;
               return i;
           }
       }
       return -1;
   }

   //Add property (Name, City, Rent, Owner) and return conditional values
   public int addProperty(String name, String city, double rent, String owner) {
       return addProperty(new Property(name, city, rent, owner));
   }
 
  //Add property (Name, City, Rent, Owner, X, Y, Width, Depth) and return conditional values
  
   public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth){
       return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
   }
   
   //Returns the total rent due
   public double totalRent(){
	   // Variables
       double total = 0.0;
       // Loop
       for (Property property : properties){
           if (property == null){
               break;
           }
           total += property.getRentAmount();
       }
       // Return
       return total;
   }
  
 //Returns the highest rent property
   public double maxRentProp(){
	// Variables
       double rentAmount = 0;
    // Loop
       for (Property property : properties){
    	   if (property == null){
    		   break;
    		   }
    	   if (rentAmount < property.getRentAmount()){
    		   rentAmount = property.getRentAmount();
    		   }
    	   }
       return rentAmount;
       }
   
   //index of property that has maximum rent amount and return index
   public int maxRentPropertyIndex(){
       int index = 0;
       for (int i =0; i < properties.length; i++){
           if (properties[i] == null){
               break;
           }
           if (properties[i].getRentAmount() >= properties[index].getRentAmount()){
               index = i;
           }
       }
       return index;
   }
   
   // index of the property and and return the string
   public String displayPropertyAtIndex(int i){
       String string = properties[i].toString();
       return string;
   }
   
	//Returns the Text version of Properties object
   public String toString(){
	// Variables
       String output = "";
       for (int i=0; i<MAX_PROPERTY;i++) {
           if(properties[i]==null){
               break;
           }
           output += properties[i].toString()+"\n";
       }
       return "List of the properties for " + name + ", taxID: " + taxID + "\n___________________________________\n"+output+"\n"
                       + "___________________________________\ntotal " + "management Fee: "+(totalRent()*mgmFeePer/100);
   }
}