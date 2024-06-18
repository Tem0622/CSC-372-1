package Week2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp extends JFrame implements ActionListener {
    private double balance = 0.0;  // Initial balance
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;

    public BankBalanceApp() {
        // Frame settings
        setTitle("Bank Balance Application");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));

        // Adding components
        balanceLabel = new JLabel("Balance: $" + balance);
        panel.add(balanceLabel);

        amountField = new JTextField();
        panel.add(amountField);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        panel.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (e.getSource() == depositButton) {
                balance += amount;  // Deposit the amount
            } else if (e.getSource() == withdrawButton) {
                if (amount <= balance) {
                    balance -= amount;  // Withdraw only if enough balance is available
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient funds to withdraw", "Transaction Error", JOptionPane.ERROR_MESSAGE);
                    return;  // Prevents the withdrawal if funds are insufficient
                }
            }
            balanceLabel.setText("Balance: $" + balance);  // Update balance display
            amountField.setText("");  // Clear the input field
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        BankBalanceApp app = new BankBalanceApp();
        app.setVisible(true);
    }
}
