package com.repositories.images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawingLines {
    public void run() throws IOException {
        BufferedImage image = ImageIO.read(DrawingLines.class.getResourceAsStream("/dog.jpg"));

        Graphics g = image.getGraphics();

        g.setColor(Color.GREEN);
        g.drawLine(0, 0, image.getWidth() - 1, image.getHeight() - 1);

        // g.setFont(font);
        // g.drawString("Test", 0, 20);

        Display.display(image);
    }
}
