
public class Customer implements Cloneable{
	// Instance variables for name and age
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	
	public Customer(Customer cust) { name = cust.name; age = cust.age; }
	
	public String getName() { return name;}
	public int getAge() { return age; }
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	
	/*
	 * 	An Overridden  toString method: String representation for Customer
	 *  including the name and age getters and setters  and any other methods 
	 *  that are needed for your design.
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
}