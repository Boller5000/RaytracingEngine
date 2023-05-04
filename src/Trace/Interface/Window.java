package Trace.Interface;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    public Window() {
        super("Raytracer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        // Get the dimensions of the screen
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the position of the window so that it appears in the center of the screen
        int x = (int) ((screenDimensions.getWidth() - getWidth()) / 2);
        int y = (int) ((screenDimensions.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        setVisible(true);
    }

    public JPanel getContentPane() {
        return (JPanel) super.getContentPane();
    }

    public void setContentPane(JPanel contentPane) {
        super.setContentPane(contentPane);
    }
}