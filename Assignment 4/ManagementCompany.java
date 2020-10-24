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
	private String Name = "";
	private String TaxID = "";
	private double ManagementFee = 0.00;
	private Plot ManagementPlot;
	private Property Properties[] = new Property[MAX_PROPERTY];
	private int currentPropertyIndex = -1;

	 //Returns the max amount of properties
	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}
	 //Returns the management property 
	public Plot getPlot() { 
   return this.ManagementPlot; }

	 //Returns the management company name 
	public String getName() { 
   return this.Name; }

	 //Returns the total rent due
	public double totalRent() {
		// Variables
		double totalRent = 0;
		// Loop
		for (int index = 0; index < this.Properties.length; index++) {
			// Checks
			if (this.Properties[index] == null) { continue; }
			// Variables
			Property p = this.Properties[index];
			totalRent += p.getRentAmount();
		}
		// Return
		return (this.Properties.length > 0 ? totalRent : 0.00);
	}

	 // Empty constructor
	public ManagementCompany() {
		this.ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	 //constructor String Name, String TaxId, double MagemeCompy
	public ManagementCompany(String Name, String TaxId, double MagemeCompy) {
		this.Name = Name;
		this.TaxID = TaxId;
		this.ManagementFee = MagemeCompy;
		this.ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	 // constructor String Name, String TaxId, double MagemeCompy, int x, int y, int Width, int Depth
	public ManagementCompany(String Name, String TaxId, double MagemeCompy, int x, int y, int Width, int Depth) {
		this.Name = Name;
		this.TaxID = TaxId;
		this.ManagementFee = MagemeCompy;
		this.ManagementPlot = new Plot(x, y, Width, Depth);
	}
	
	 //Add property (Property)
	public int addProperty(Property P) {
		// Variables
		int currentIndex = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		// Checks
		if (newIndex >= this.MAX_PROPERTY) { return -1; }
		// Variables
		this.Properties[newIndex] = new Property(P);
		// Default
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	 //Add property (Name, City, Rent, Owner)
	public int addProperty(String Name, String City, double Rent, String Owner) {
		// Variables
		int currentIndex = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		// Checks
		if (newIndex >= this.MAX_PROPERTY) { return -1; }
		// Variables
		this.Properties[newIndex] = new Property(Name, City, Rent, Owner);
		// Default
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	 //Add property (Name, City, Rent, Owner, X, Y, Width, Depth)
	public int addProperty(String Name, String City, double Rent, String Owner, int x, int y, int Width, int Depth) {
		// Variables
		int currentIndex = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		Plot plot = new Plot(x, y, Width, Depth);
		// Checks
		if (newIndex >= this.MAX_PROPERTY) { return -1; }
		if (this.ManagementPlot.encompasses(plot) == false) { return -3; }
		if (currentIndex >= 0) {
			for (int index = 0; index < this.Properties.length; index++) {
				// Checks
				if (this.Properties[index] == null) { continue; }
				if (this.Properties[index].getPlot().overlaps(plot) == true) { return -4; }
			}
		}
		// Variables
		this.Properties[newIndex] = new Property(Name, City, Rent, Owner, x, y, Width, Depth);
		// Default
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	//Returns the highest rent property
	public String maxRentProp() {
		// Variables
		double high = 0;
		String stringified = "";
		// Loop
		for (int index = 0; index < this.Properties.length; index++) {
			// Variables
			Property p = this.Properties[index];
			if (p == null) { continue; }
			if (p.getRentAmount() > high) {
				high = p.getRentAmount();
				stringified = p.toString();
			}
		}
		// Return
		return (high> 0 ? stringified : "");
	}

	//Returns the stringified version of Properties object
	public String toString() {
		// Variables
		String Return = "";
		// Append
		Return += "List of properties for " + this.getName() + ", TaxID: " + this.TaxID;
		// Loop
		for (int index = 0; index < this.Properties.length; index++) {
			// Checks
			if (this.Properties[index] == null) { continue; }
			// Variables
			Return += "\n" + this.Properties[index].toString();
		}
		// Append
		Return += "\ntotal management Fee: " + (this.totalRent() * (this.ManagementFee * 0.01));
		// Return
		return Return;
	}
}