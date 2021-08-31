package com.repositories.images;

import javax.swing.*;
import java.awt.*;

public class Display {
    public static void display(Image image) {
        JFrame jFrame = new JFrame("Image");

        jFrame.getContentPane().add(new ImagePanel(image));
        jFrame.pack();
        jFrame.setVisible(true);

        // JPanel jPanel = new JPanel();
    }

    private static class ImagePanel extends JPanel {
        private final Image image;

        public ImagePanel(Image image) {
            this.image = image;

            setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.drawImage(image, 0, 0, null);
        }
    }
}
