package com.repositories.images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AddingTextToImage {
    public void run() throws IOException {
        BufferedImage image = ImageIO.read(AddingTextToImage.class.getResourceAsStream("/dog.jpg"));

        Font font = new Font("Arial", Font.BOLD, 18);

        Graphics g = image.getGraphics();

        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString("Test", 0, 20);

        Display.display(image);
    }
}
