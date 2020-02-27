package ch.heigvd.mcr.labo1.clockListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DialView extends ClockView {
    private JLabel clockImg = new JLabel();
    private Line2D hoursNeedle, minutesNeedle, secondsNeedle;

    public DialView(String imgPath, int width, int height) {
        super(width, height);

        BufferedImage dialImage = getScaledDialImage(imgPath);
        setIcon(new ImageIcon(dialImage));

        //Add the needles
        Point center = new Point(getWidth() / 2,getHeight() / 2); // FIXME: prendre centre du panel

        hoursNeedle = new Line2D.Double(center.x, center.y, center.x, 50);
        minutesNeedle = new Line2D.Double(center.x, center.y, center.x, 40);
        secondsNeedle = new Line2D.Double(center.x, center.y, center.x, 10);
    }

    public void update(int totalSeconds){
        super.update(totalSeconds);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        paintNeedle(graphics, hoursNeedle, 10, hours());
        paintNeedle(graphics, minutesNeedle, 5, minutes());
        paintNeedle(graphics, secondsNeedle, 1, seconds());
    }

    private void paintNeedle(Graphics graphics, Line2D line, int stroke, float angle) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(stroke));

        AffineTransform rotation =
                AffineTransform.getRotateInstance (
                        Math.toRadians(angle * 6), line.getX1(), line.getY1()
                );

        graphics2D.draw(rotation.createTransformedShape(line));
    }

    private BufferedImage getScaledDialImage(String path){
        //Set image of the dial on background
        //URL path = DialView.class.getResource(imgPath);
        BufferedImage dialImg = null;
        try {
            dialImg = ImageIO.read(DialView.class.getResource(path));
        } catch (IOException ex){
            //TODO do something!
        }

        //Rescale the image
        Image scaledImg = dialImg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        BufferedImage bufferedImg = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        //Reconvert into an BufferedImage
        Graphics2D g2d = bufferedImg.createGraphics();
        g2d.drawImage(scaledImg, 0, 0, null);
        g2d.dispose();

        return bufferedImg;
    }
}
