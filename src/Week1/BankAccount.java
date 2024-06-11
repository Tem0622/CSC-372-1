package Week1;

public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0; // initialize balance to zero
    }

    // Deposit method
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Withdrawal method
    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Account summary
    public void accountSummary() {
        System.out.println("Account ID: " + accountID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Current Balance: " + balance);
    }
}
