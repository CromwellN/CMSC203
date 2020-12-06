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

public class BevShop implements BevShopInterfce {
	private int numOfDrinks;
	private Order currentOrder;
	private ArrayList<Order> orderList;

	public BevShop() {
		orderList = new ArrayList<Order>();
		numOfDrinks = 0;
	}

	public int getNumOfAlcoholDrink() { return numOfDrinks; }

	public Order getCurrentOrder() { return currentOrder; }
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean validTime(int time) { return time >= MIN_TIME && time <= MAX_TIME; }
	
	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	@Override
	public boolean eligibleForMore() {
		int count = currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
		return count < MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	@Override
	public boolean validAge(int age) { return age > MIN_AGE_FOR_ALCOHOL; }
	
	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		numOfDrinks = 0;
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		orderList.add(currentOrder);
	}
	
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		orderList.set(orderList.size() - 1, currentOrder);
	}
	
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		currentOrder.addNewBeverage(bevName, size);
		orderList.set(orderList.size() - 1, currentOrder);
		numOfDrinks++;
	}
	
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
		orderList.set(orderList.size() - 1, currentOrder);
	}
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	@Override
	public int findOrder(int orderNo) {
		int find = -1;
		int index = 0;
		for (Order order : orderList) {
			if (order.getOrderNo() == orderNo) {
				find = index;
				break;
			}index++;
		}return find;
	}
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		double totalCost = 0;
		for (Order order : orderList) {
			if (order.getOrderNo() == orderNo) {
				totalCost += order.calcOrderTotal();
			}
		}return totalCost;
	}
	
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	@Override
	public double totalMonthlySale() {
		double totalCost = 0;
		for (Order order : orderList) {
			totalCost += order.calcOrderTotal();
		}return totalCost;
	}
	
	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	@Override
	public void sortOrders() {
		int number = orderList.size();
		for (int index = 0; index < number - 1; index++) {
			int min_Index = index;
			for (int join = index + 1; join < number; join++)
				if (orderList.get(join).compareTo(orderList.get(min_Index)) < 0)
					min_Index = join;
			Order point = orderList.get(min_Index);
			orderList.set(min_Index, orderList.get(index));
			orderList.set(index, point);
		}
	}
	
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	@Override
	public Order getOrderAtIndex(int index) {
		int inx = 0;
		for (Order order : orderList) {
			if (index == inx) {
				Order point = order;
				return point;
			}
			inx++;
		}
		return null;
	}

	public boolean isMaxFruit(int index) { return index > MAX_FRUIT; }

	public int totalNumOfMonthlyOrders() { return orderList.size(); }
/*
 *  An Overridden toString method: The string representation of all the orders and the total monthly sale.  
 */
	@Override
	public String toString() {
		String string = "BevShop [numOfDrinks=" + numOfDrinks + ", currentOrder=" + currentOrder + "]";
		for (Order order : orderList) {
			string += "\n" + order.toString();
		}
		string += "\nTotal cost = " + totalMonthlySale();
		return string;
	}

	public int getMaxOrderForAlcohol() { return MAX_ORDER_FOR_ALCOHOL; }

	public int getMinAgeForAlcohol() { return MIN_AGE_FOR_ALCOHOL; }
}
