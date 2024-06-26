package Week3;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    public void saveToFile(JTextArea textArea) {
        String directoryPath = "src/week3";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try (FileWriter writer = new FileWriter(new File(directory, "log.txt"))) {
            writer.write(textArea.getText());
            textArea.append("\nContent saved to " + directoryPath + "/log.txt.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file.");
        }
    }
}
