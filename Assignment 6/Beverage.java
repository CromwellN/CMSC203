
public abstract class Beverage {

	/*
	 * Instance variables for beverage name, beverage type, size, and constant attributes
	 * for the base price ($2.0) and size price (additional $1 to go a size up).
	 */	
	private String name;
	private TYPE type;
	private SIZE size;
	public final double BASE_PRICE = 2.0;
	public final double SIZE_PRICE = 1.0;
	/*
	 * A parametrized constructor to create a Beverage object given its name, type and  size
	 */
	public Beverage(String name, TYPE type, SIZE size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	/*
	 * An abstract methods called calcPrice that calculates and returns the beverage price. 
	 */
	public double calcPrice() {
		double returnCost = getBasePrice();
		if (getSize() == SIZE.SMALL) { returnCost += BASE_PRICE;}
		if (getSize() == SIZE.MEDIUM) { returnCost += SIZE_PRICE + BASE_PRICE;}
		if (getSize() == SIZE.LARGE) { returnCost += SIZE_PRICE + BASE_PRICE+ 1; }
		return returnCost;
	}
	
	public String getBevName() { return name; }
	
	public TYPE getType() { return type; }
	
	public SIZE getSize() { return size; }
	
	public double getBasePrice() { return BASE_PRICE; }
	
	public void setName(String name) { this.name = name; }
	
	public void setType(TYPE type) { this.type = type; }
	
	public SIZE setSize() { return size; }
	
	public void setSize(SIZE size) { this.size = size; }
	
	public double setBasePrice() { return BASE_PRICE;  }
	
	/*
	 * An Overridden  toString method: String representation for Beverage including the name and size
	 */
	@Override
	public String toString() {
		return "Beverage [name=" + name + ", type=" + type + ", size=" + size + "!";
	}
	
	/*
	 * An Overridden  equals method: checks equality based on name, type, size of the beverage
	 * getters and setters  and any other methods that are needed for your design.  
	 */
	public boolean equals(Beverage bev) {
		if (this.name.equals(bev.getBevName()) && this.type == bev.getType() && size == bev.getSize()) { return true;
		}
		return false;
	} 
	
}