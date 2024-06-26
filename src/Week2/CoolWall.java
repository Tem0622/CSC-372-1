package Week2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.border.*;

public class CoolWall extends JFrame {
    public CoolWall() {
        super("Top Gear UK - Cool Wall");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 4));

        // Create panels for each category
        JPanel seriouslyUncool = createPanel("Seriously Uncool", Color.LIGHT_GRAY);
        JPanel uncool = createPanel("Uncool", Color.lightGray);
        JPanel cool = createPanel("Cool", Color.lightGray);
        JPanel subZero = createPanel("Sub Zero", Color.lightGray);

        // Add example cars
        seriouslyUncool.add(createCarLabel("car1.jpg", "Old_Bmw"));
        uncool.add(createCarLabel("car2.jpg", "Modern_Mustang"));
        cool.add(createCarLabel("car3.jpg", "Classic_Mustang"));
        subZero.add(createCarLabel("car4.jpg", "McLaren"));

        // Add panels to the frame
        add(seriouslyUncool);
        add(uncool);
        add(cool);
        add(subZero);

        // Set the frame visible
        setVisible(true);
    }

    private JPanel createPanel(String title, Color color) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), title));
        panel.setBackground(color);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Enable drag and drop
        panel.setTransferHandler(new TransferHandler("icon"));

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JLabel c = (JLabel) e.getSource();
                TransferHandler handler = c.getTransferHandler();
                handler.exportAsDrag(c, e, TransferHandler.MOVE);
            }
        });

        return panel;
    }

    private JLabel createCarLabel(String imagePath, String carName) {
        URL imgUrl = getClass().getResource(imagePath);
        if (imgUrl == null) {
            System.err.println("Resource not found: " + imagePath);
            return new JLabel(carName);
        }
        ImageIcon originalIcon = new ImageIcon(imgUrl);
        Image image = originalIcon.getImage(); // Transform it to an Image first
        Image resizedImage = image.getScaledInstance(100, 100,  Image.SCALE_SMOOTH); // Scale it to fit within these dimensions
        ImageIcon icon = new ImageIcon(resizedImage); // Transform it back to an ImageIcon

        JLabel label = new JLabel(carName, icon, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setBorder(new LineBorder(Color.BLACK, 1));
        label.setTransferHandler(new TransferHandler("icon"));

        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JLabel c = (JLabel) e.getSource();
                TransferHandler handler = c.getTransferHandler();
                handler.exportAsDrag(c, e, TransferHandler.MOVE);
            }
        });

        return label;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CoolWall();
            }
        });
    }
}
