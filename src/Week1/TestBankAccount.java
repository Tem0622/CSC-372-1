package Week1;

public class TestBankAccount {
    public static void main(String[] args) {
        // Create a new CheckingAccount
        CheckingAccount myAccount = new CheckingAccount("Jane", "Smith", 67890, 0.75);

        // Display initial account summary
        System.out.println("Initial Account Summary:");
        myAccount.displayAccount();

        // Perform several deposits
        myAccount.deposit(300);
        myAccount.deposit(200);
        System.out.println("\nAfter Deposits:");
        myAccount.displayAccount();

        // Perform a withdrawal that does not trigger overdraft
        myAccount.processWithdrawal(250);
        System.out.println("\nAfter Withdrawal of $250:");
        myAccount.displayAccount();

        // Perform a withdrawal that exceeds the balance, triggering overdraft
        myAccount.processWithdrawal(300); // This should include a $30 overdraft fee
        System.out.println("\nAfter Overdraft Withdrawal of $300:");
        myAccount.displayAccount();

        // Additional deposit and withdrawal to check account activity
        myAccount.deposit(100);
        myAccount.processWithdrawal(50);
        System.out.println("\nFinal Account Activity:");
        myAccount.displayAccount();
    }
}
