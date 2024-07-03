package Week3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class CarDashboard extends JFrame {
    public CarDashboard() {
        setTitle("Car Dashboard");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        getContentPane().add(mainPanel);

        String basePath = "C:\\Projects\\CSC-372-1\\src\\Week3\\";

        JLabel speedGauge = addImageLabel(basePath + "speedometer.png", 150, 150);
        mainPanel.add(speedGauge, BorderLayout.WEST);

        JLabel tachometerGauge = addImageLabel(basePath + "tachometer.png", 150, 150);
        mainPanel.add(tachometerGauge, BorderLayout.CENTER);

        JLabel mapLabel = addImageLabel(basePath + "map.png", 120, 120);
        mainPanel.add(mapLabel, BorderLayout.EAST);

        JPanel mediaPanel = new JPanel();
        mediaPanel.setLayout(new BoxLayout(mediaPanel, BoxLayout.X_AXIS));
        mediaPanel.add(Box.createHorizontalGlue());
        mediaPanel.add(new JButton(new ImageIcon(makeRoundImageIcon(new ImageIcon(basePath + "play.png"), 50, 50).getImage())));
        mediaPanel.add(new JButton(new ImageIcon(makeRoundImageIcon(new ImageIcon(basePath + "pause.png"), 50, 50).getImage())));
        mediaPanel.add(new JButton(new ImageIcon(makeRoundImageIcon(new ImageIcon(basePath + "stop.png"), 50, 50).getImage())));
        mediaPanel.add(Box.createHorizontalGlue());
        mainPanel.add(mediaPanel, BorderLayout.SOUTH);

        mainPanel.add(new JPanel(), BorderLayout.NORTH);

        pack();
    }

    private JLabel addImageLabel(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            return new JLabel("Missing Image: " + imagePath);
        }
        ImageIcon resizedIcon = makeRoundImageIcon(icon, width, height);
        return new JLabel(resizedIcon);
    }

    private ImageIcon makeRoundImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setClip(new Ellipse2D.Float(0, 0, width, height));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(bufferedImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CarDashboard().setVisible(true);
        });
    }
}
