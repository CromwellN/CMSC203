/*Class: CMSC203 CRN 22445
 Program: Assignment 6
 Instructor: Dr. Grinberg
 Summary of Description: This program encrypt and decrypt a phrase using two similar approaches.
 Due Date: 12/06/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Cromwell Nzouakeu
*/


import java.util.ArrayList;

public class Order implements OrderInterface, Comparable {
	
	private int number;
	private int time;
	private DAY day;
	private Customer customer;
	private ArrayList<Beverage> bevList;
	
	/*
	 * Instance variables for order number, order time, 
	 * order day and customer and a list of beverages within this order
	 */

	public Order(int time, DAY day, Customer customer) {
		this.number = getRandNum();
		this.time = time;
		this.day = day;
		this.customer = new Customer(customer);
		this.bevList = new ArrayList<>();
	}
	
	/*
	 *  A method to generate a random number within the range of 10000 and 90000 
	 */
	public int getRandNum() {
		int min = 10000;
		int max = 90000;
		int randomNum = (int) (Math.random() * (max - min + 1) + min);
		return randomNum;
	}
	
	/**
	 * @param day the day of the week
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	@Override
	public boolean isWeekend() { return (day == DAY.SATURDAY || day == DAY.SUNDAY);
	}
	
	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * @return the beverage listed in the itemNo of the order or null if there is no item in the order
	 */
	@Override
	public Beverage getBeverage(int itemNo) { return bevList.get(itemNo);
	}
	
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		bevList.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
	@Override
	public void addNewBeverage(String bevName, SIZE size) { bevList.add(new Alcohol(bevName, size, isWeekend()));
	}

	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		bevList.add(new Smoothie(bevName, size, numOfFruits, addPRotien));
	}

	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	@Override
	public double calcOrderTotal() {
		double totalCost = 0;
		for (Beverage bev : bevList) {
			totalCost += bev.calcPrice();
		}
		return totalCost;
	}
	
	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	@Override
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		for (Beverage bev : bevList) {
			if (bev.getType() == type) {
				count++;
			}
		}
		return count++;
	}

	/**
	 * Override the compareTo method to compare this order with another order based on the order number. 
	 * @Returns 0 if this order number is same as another order's order number, 1 if it is greater 
	 * than another order's order number, -1 if it smaller than another order's order number.	
	 * getters and setters  and any other methods that are needed for your design. 
	 */
	
	@Override
	public int compareTo(Object arg0) {
		Order temp = (Order) arg0;
		if (number > temp.getOrderNo()) {
			return 1;
		} else if (number < temp.getOrderNo()) {
			return -1;
		}
		return 0;
	}
	
	/*
	 * An Overridden toString method: Includes order number, time, day, customer name , customer age 
	 * and the list of beverages (with information of the beverage).
	 */
		@Override
		public String toString() {
			String string = "Order [number=" + number + ", time=" + time + ", day=" + day + ", customer=" + customer.toString() + "]";
			for (Beverage bev : bevList) {
				string += "\n" + bev.toString();
			}
			// append total cost
			string += "\nCost = " + calcOrderTotal();
			return string;
		}
		
		public Customer getCustomer() {
		return new Customer(customer.getName(), customer.getAge());
	}
	public int getTotalItems() { return bevList.size();
	}

	public int getOrderNo() { return number; }

	public DAY getOrderDay() { return day; }

	public int getOrderTime() { return time; }

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
