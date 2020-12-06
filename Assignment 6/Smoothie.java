public class Smoothie extends Beverage {
	
	private int numberOfFruits;
	private boolean isProteinAdded;
	private final double COST_P_POWDER = 1.5;
	private final double COST_OF_FRUITS = 0.50;

	public Smoothie(String name, SIZE size, int noFruits, boolean isProteinAdded) {
		super(name, TYPE.SMOOTHIE, size);
		this.numberOfFruits = noFruits;
		this.isProteinAdded = isProteinAdded;
	}

	@Override
	public double calcPrice() {
		double returnCost = getBasePrice();
		if (isProteinAdded) { returnCost += COST_P_POWDER;
		}
		if(getSize() == SIZE.MEDIUM ) { returnCost +=SIZE_PRICE;
		}
		if(getSize() == SIZE.LARGE ) { returnCost +=SIZE_PRICE +1 ;
		}
		returnCost += numberOfFruits * COST_OF_FRUITS;
		return returnCost;
	}

	public int getNumOfFruits() { return numberOfFruits; }
	
	public boolean getAddProtien() { return isProteinAdded;}

	@Override
	public String toString() {
		return super.toString()+"\nSmoothie [numberOfFruits=" + numberOfFruits + ", isProteinAdded=" + isProteinAdded + "!"
				+ "" + "\nPrice = "+calcPrice();
	}
	
	public boolean equals(Smoothie bev) {
		if (super.equals(bev) && numberOfFruits==bev.numberOfFruits && isProteinAdded==bev.isProteinAdded) {
			return true;
		}
		return false;
	}
}