package Week3;

import javax.swing.*;
import java.awt.*;

public class MenuInterface extends JFrame {
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem dateItem, saveItem, colorItem, exitItem;
    private DateTimeService dateTimeService;
    private FileService fileService;
    private ColorService colorService;

    public MenuInterface() {
        setTitle("Menu Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        dateTimeService = new DateTimeService();
        fileService = new FileService();
        colorService = new ColorService();

        setupMenu();
        setupTextArea();

        setVisible(true);
    }

    private void setupMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("Options");

        dateItem = new JMenuItem("Show Date/Time");
        saveItem = new JMenuItem("Save to File");
        colorItem = new JMenuItem("Change Color");
        exitItem = new JMenuItem("Exit");

        dateItem.addActionListener(e -> dateTimeService.showDateTime(textArea));
        saveItem.addActionListener(e -> fileService.saveToFile(textArea));
        colorItem.addActionListener(e -> colorService.changeBackgroundColor(getContentPane(), textArea));
        exitItem.addActionListener(e -> System.exit(0));

        menu.add(dateItem);
        menu.add(saveItem);
        menu.add(colorItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void setupTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuInterface::new);
    }
}
