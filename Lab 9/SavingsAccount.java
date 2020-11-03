public class SavingsAccount extends BankAccount {
  // Variable for class
  private double rate = 2.5;
  private static int savingsNumber = 0;
  private String accountNumber;
  // Constructor for class
  public SavingsAccount(String name, double amount) {
    super(name,amount);
    this.accountNumber = super.getAccountNumber() + "-" + savingsNumber++;
  }
  // Constructor class for one account 
  public SavingsAccount(SavingsAccount oldAccount, double amount) {
    super(oldAccount, amount);
    this.accountNumber = super.getAccountNumber() + "-" + savingsNumber++;
  }
  // Calculate monthly interest 
  public void postInterest() {
    super.deposit(super.getBalance() * this.rate + this.getBalance());
  }
  // Determine the current account number
  public String getAccountNumber(){
    return accountNumber;
  }
  
}