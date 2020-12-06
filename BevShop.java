import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	private int numOfDrinks;
	private Order currentOrder;
	private ArrayList<Order> orderList;

	BevShop() {
		orderList = new ArrayList<Order>();
		numOfDrinks = 0;
	}

	public int getNumOfAlcoholDrink() { return numOfDrinks;
	}

	public Order getCurrentOrder() { return currentOrder;
	}

	@Override
	public boolean validTime(int time) {
		// TODO Auto-generated method stub
		return time >= MIN_TIME && time <= MAX_TIME;
	}

	@Override
	public boolean eligibleForMore() {
		int count = currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
		return count < MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean validAge(int age) { return age > MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		numOfDrinks = 0;
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		orderList.add(currentOrder);
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		orderList.set(orderList.size() - 1, currentOrder);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		currentOrder.addNewBeverage(bevName, size);
		orderList.set(orderList.size() - 1, currentOrder);
		numOfDrinks++;
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
		orderList.set(orderList.size() - 1, currentOrder);
	}

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

	@Override
	public double totalOrderPrice(int orderNo) {
		double totalCost = 0;
		for (Order order : orderList) {
			if (order.getOrderNo() == orderNo) {
				totalCost += order.calcOrderTotal();
			}
		}return totalCost;
	}

	@Override
	public double totalMonthlySale() {
		double totalCost = 0;
		for (Order order : orderList) {
			totalCost += order.calcOrderTotal();
		}return totalCost;
	}

	@Override
	public void sortOrders() {
		int number = orderList.size();
		for (int index = 0; index < number - 1; index++) {
			int min_Index = index;
			for (int join = index + 1; join < number; join++)
				if (orderList.get(join).compareTo(orderList.get(min_Index)) < 0)
					min_Index = join;
			Order temp = orderList.get(min_Index);
			orderList.set(min_Index, orderList.get(index));
			orderList.set(index, temp);
		}
	}

	@Override
	public Order getOrderAtIndex(int index) {
		int indx = 0;
		for (Order o : orderList) {
			if (index == indx) {
				Order temp = o;
				return temp;
			}
			indx++;
		}
		return null;
	}

	public boolean isMaxFruit(int i) { return i > MAX_FRUIT;
	}

	public int totalNumOfMonthlyOrders() { return orderList.size();
	}

	@Override
	public String toString() {
		String string = "BevShop [numOfDrinks=" + numOfDrinks + ", currentOrder=" + currentOrder + "]";
		for (Order o : orderList) {
			string += "\n" + o.toString();
		}
		string += "\nTotal cost = " + totalMonthlySale();
		return string;
	}

	public int getMaxOrderForAlcohol() { return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		// TODO Auto-generated method stub
		return MIN_AGE_FOR_ALCOHOL;
	}
}