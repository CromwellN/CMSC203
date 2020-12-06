



public class Alcohol extends Beverage {
	/*
	 * Contains additional instance variable for weather or not it is offered in the weekend.
	 * The additional cost for drinks offered in the weekend is 60 cents. 
	 */
	
	private boolean isWeekend;
	private final double ADDITIONAL_COST = 0.60;
	
	
	public Alcohol(String name, SIZE size, boolean isWeekend) {
		super(name, TYPE.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	/*
	 * An Overridden toString method: String representation of a alcohol drink including 
	 * the name, size, whether or not beverage is offered in the weekend and the price.
	 */
	@Override
	public String toString() { 
		return super.toString() + "\n" + "Alcohol [isWeekend=" + isWeekend + "]\n" + "Price = " + calcPrice();
	}
	/*
	 * An Overridden equals method: checks equality based on 
	 * the Beverage class equals method and additional instance variables for this class.
	 */
	public boolean equals(Alcohol bev) {
		if (super.equals(bev) && isWeekend==bev.isWeekend) { 
			return true;
		}
		return false;
	}
	/*
	 * An Overridden calcPrice method. getters and setters 
	 * and any other methods that are needed for your design.
	 */
	@Override
	public double calcPrice() {
		double returnCost = getBasePrice();
		if (getSize() == SIZE.MEDIUM) { returnCost += SIZE_PRICE;
		}
		if (getSize() == SIZE.LARGE) { returnCost += SIZE_PRICE + 1;
		}
		if (isWeekend) { returnCost += ADDITIONAL_COST;
		}
		return returnCost;
	}
}