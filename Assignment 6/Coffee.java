
public class Coffee extends Beverage {
	private boolean extraCost;
	private boolean isExtraSyrup;
	
	public Coffee(String name, SIZE size, boolean isextra, boolean isExtraSyrup) {
		super(name, TYPE.COFFEE, size);
		this.extraCost = isextra;
		this.isExtraSyrup = isExtraSyrup;
	}

	public boolean getExtraShot() { return extraCost; }
	
	public boolean getExtraSyrup() { return isExtraSyrup; }	
	/*
	 * An Overridden calcPrice method.
	 */
	@Override
	public double calcPrice() {
		double returnCost = getBasePrice();
		if (getSize() == SIZE.MEDIUM) { returnCost += SIZE_PRICE; }
		if (getSize() == SIZE.LARGE) { returnCost += SIZE_PRICE + 1;}
		if (extraCost) { returnCost += 0.50; }
		if (isExtraSyrup) { returnCost += 0.50;}
		return returnCost;
	}
	/*
	 * An Overridden  toString method: String representation of Coffee beverage, including the name , 
	 * size ,  whether it contains extra shot, extra syrup and the price of the coffee
	 */
	@Override
	public String toString() {
		return super.toString() + "\nCoffee [extraCost=" + extraCost + ", isExtraSyrup=" + isExtraSyrup + "price="
				+ calcPrice() + "]";
	}
	/*
	 * An Overridden  equals method: checks equality based on 
	 * the Beverage class equals method and additional instance variables for this class.
	 */
	public boolean equals(Coffee bev) {
		if (super.equals(bev) && extraCost == bev.extraCost && isExtraSyrup == bev.isExtraSyrup) {
			return true;
		}
		return false;
	}
}