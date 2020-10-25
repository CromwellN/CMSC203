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
	private int MAX_PROPERTY = 10;
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
		return MAX_PROPERTY;
	}
	 //Returns the management property 
	public Plot getPlot() { 
   return ManagementPlot; 
   }

	 //Returns the management company name 
	public String getName() { 
   return Name; 
   }

	 //Returns the total rent due
	public double totalRent() {
		// Variables
		double totalRent = 0;
		// Loop
		for (int index = 0; index < Properties.length; index++) {
			if (Properties[index] == null) {
				continue;
				}
			Property p = Properties[index];
			totalRent += p.getRentAmount();
		}
		// Return
		return (Properties.length > 0 ? totalRent : 0.00);
	}

	 // Empty constructor
	public ManagementCompany() {
		ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	 //constructor String Name, String TaxId, double MagemeCompy
	public ManagementCompany(String name, String TaxId, double MagemeCompy) {
		Name = name;
		TaxID = TaxId;
		ManagementFee = MagemeCompy;
		ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	 // constructor String Name, String TaxId, double MagemeCompy, int x, int y, int Width, int Depth
	public ManagementCompany(String name, String TaxId, double MagemeCompy, int x, int y, int Width, int Depth) {
		Name = name;
		TaxID = TaxId;
		ManagementFee = MagemeCompy;
		ManagementPlot = new Plot(x, y, Width, Depth);
	}
	
	 //Add property (Property)
	public int addProperty(Property P) {
		// Variables
		int currentIndex = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		// Check
		if (newIndex >= MAX_PROPERTY) { 
			return -1;
			}
		// Variables
		Properties[newIndex] = new Property(P);
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	 //Add property (Name, City, Rent, Owner)
	public int addProperty(String name, String City, double Rent, String Owner) {
		// Variables
		int currentIndex = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		// Checks
		if (newIndex >= MAX_PROPERTY) {
			return -1;
			}
		// Variables
		this.Properties[newIndex] = new Property(name, City, Rent, Owner);
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	 //Add property (Name, City, Rent, Owner, X, Y, Width, Depth)
	public int addProperty(String name, String City, double Rent, String Owner, int x, int y, int Width, int Depth) {
		// Variables
		int currentIndex = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		Plot plot = new Plot(x, y, Width, Depth);
		// Checks
		if (newIndex >= MAX_PROPERTY) {
			return -1; 
			}
		if (ManagementPlot.encompasses(plot) == false) { 
			return -3;
			}
		if (currentIndex >= 0) {
			for (int index = 0; index < Properties.length; index++) {
				if (Properties[index] == null) { 
					continue;
					}
				if (Properties[index].getPlot().overlaps(plot) == true) { 
					return -4;
					}
			}
		}
		// Variables
		Properties[newIndex] = new Property(name, City, Rent, Owner, x, y, Width, Depth);
		// Default
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	//Returns the highest rent property
	public String maxRentProp() {
		// Variables
		double high = 0;
		String Text = "";
		// Loop
		for (int index = 0; index < Properties.length; index++) {
			// Variables
			Property p = Properties[index];
			if (p == null) { continue; }
			if (p.getRentAmount() > high) {
				high = p.getRentAmount();
				Text = p.toString();
			}
		}
		// Return
		return (high> 0 ? Text : "");
	}

	//Returns the Text version of Properties object
	public String toString() {
		// Variables
		String Return = "";
		Return += "List of properties for " +getName() + ", TaxID: " +TaxID;
		// Loop
		for (int index = 0; index < Properties.length; index++) {
			// Checks
			if (Properties[index] == null) { 
				continue; 
				}
			// Variables
			Return += "\n" + Properties[index].toString();
		}
		Return += "\ntotal management Fee: " + (totalRent() * (ManagementFee * 0.01));
		// Return
		return Return;
	}
}