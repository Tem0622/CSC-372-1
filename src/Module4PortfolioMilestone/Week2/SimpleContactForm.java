package Module4PortfolioMilestone.Week2;

//--- Abstract Window Toolkit (AWT)

// Provides layout manager for arranging components in five regions:
// north, south, east, west, and center.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class generates a simple contact form. The form includes fields for the
 * user's name, email, and message, and a submit button to submit the form.
 *
 * @author Alejandro Ricciardi
 * @version 1.0
 * @date 06/16/2024
 */
public class SimpleContactForm {

    /**
     * The main method to create and display the contact form.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

		/*------------
		 |   Frame   |
		 ------------*/

        // ---- Initializes frame
        // Creates the main application frame
        JFrame frame = new JFrame("Contact Form");
        frame.setSize(400, 300); // Set the size of the frame
        // Close the application when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for the frame

		/*------------
		 |   Panel   |
		 ------------*/

        // ---- Initializes panel
        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridForm = new GridBagConstraints();
        gridForm.insets = new Insets(5, 5, 5, 5); // Add padding around components

        // ---- Creates and adds grid components to the panel

        // -- Name
        // Adds "Name" label
        JLabel nameLabel = new JLabel("Name:");
        gridForm.gridx = 0; // Position at column 0
        gridForm.gridy = 0; // Position at row 0
        panel.add(nameLabel, gridForm);
        // Add text field for name input
        JTextField nameField = new JTextField(20);
        gridForm.gridx = 1; // Position at column 1
        gridForm.gridy = 0; // Position at row 0
        panel.add(nameField, gridForm);

        // -- Email
        // Add "Email" label
        JLabel emailLabel = new JLabel("Email:");
        gridForm.gridx = 0; // Position at column 0
        gridForm.gridy = 1; // Position at row 1
        panel.add(emailLabel, gridForm);
        // Adds text field for email input
        JTextField emailField = new JTextField(20);
        gridForm.gridx = 1; // Position at column 1
        gridForm.gridy = 1; // Position at row 1
        panel.add(emailField, gridForm);

        // Adds "Message" label
        JLabel messageLabel = new JLabel("Message:");
        gridForm.gridx = 0; // Position at column 0
        gridForm.gridy = 2; // Position at row 2
        panel.add(messageLabel, gridForm);

        // -- Message
        // Adds text area for message input with a scroll pane
        JTextArea messageArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        gridForm.gridx = 1; // Position at column 1
        gridForm.gridy = 2; // Position at row 2
        panel.add(scrollPane, gridForm);
        // Adds "Submit" button
        JButton submitButton = new JButton("Submit");
        gridForm.gridx = 1; // Position at column 1
        gridForm.gridy = 3; // Position at row 3
        panel.add(submitButton, gridForm);

        // Adds the panel to the frame's center
        frame.add(panel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);

		/*------------
		 |  JDialog  |
		 ------------*/
        // Add action listener to the submit button
        ActionListener submitBtnClicked = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message dialog when the submit button is clicked
                JOptionPane.showMessageDialog(frame, "Message was sent!");
            }
        };

        submitButton.addActionListener(submitBtnClicked);
    }
}
