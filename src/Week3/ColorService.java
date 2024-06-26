package Week3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorService {
    private String randomGreenColor;

    public ColorService() {
        // Generate a random green color once per execution
        Random random = new Random();
        int hue = random.nextInt(256);
        randomGreenColor = String.format("#00%02X00", hue);
    }

    public void changeBackgroundColor(Container contentPane, JTextArea textArea) {
        Color newColor = Color.decode(randomGreenColor); // Decode the color once
        contentPane.setBackground(newColor); // Set background color
        // Iterate over all components and set their background color
        for (Component comp : contentPane.getComponents()) {
            if (comp instanceof JViewport) {
                ((JViewport) comp).getView().setBackground(newColor);
            } else {
                comp.setBackground(newColor);
            }
        }
        textArea.setBackground(new Color(0, 0, 0, 0)); // Make text area background transparent
        textArea.append("\nColor set to: " + randomGreenColor);
        contentPane.repaint();  // Force the frame to repaint all components
    }
}
