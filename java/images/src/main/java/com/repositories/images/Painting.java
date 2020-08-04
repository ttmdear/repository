package com.repositories.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Painting {
    public void run() throws IOException {

        // Display.display(image);
        JFrame jFrame = new JFrame("Painting");

        jFrame.getContentPane().add(new Canva());
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private static class Canva extends JPanel {
        private boolean pressed;

        public Canva() {
            setPreferredSize(new Dimension(1000, 1000));
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    // if (!pressed) {
                    //     return;
                    // }

                    getGraphics().setColor(Color.GREEN);
                    getGraphics().drawLine(e.getX(), e.getY(), e.getX(), e.getY());
                }

                // @Override
                // public void mousePressed(MouseEvent e) {
                //     pressed = true;
                // }

                // @Override
                // public void mouseReleased(MouseEvent e) {
                //     pressed = false;
                // }
            });
        }


    }
}
