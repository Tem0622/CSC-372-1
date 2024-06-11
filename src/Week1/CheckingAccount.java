package Week1;

public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    // Process withdrawal with overdraft
    public void processWithdrawal(double amount) {
        if (getBalance() < amount) {
            super.withdrawal(amount + 30); // Include overdraft fee
            System.out.println("Withdrawal includes a $30 overdraft fee.");
        } else {
            super.withdrawal(amount);
        }
    }

    // Display account info including interest rate
    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
