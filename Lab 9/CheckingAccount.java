
public class CheckingAccount extends BankAccount {
	
	private static final double FEE = 0.15;
	
	// Constructor Class
	public CheckingAccount(String name, double amount) {
	    super(name, amount);
	    super.setAccountNumber(super.getAccountNumber() + "-10");
	  }
	// Withdraw balance function 
	public boolean withdraw(double amount) {   
	    return super.withdraw(amount+FEE);
	  }

}
