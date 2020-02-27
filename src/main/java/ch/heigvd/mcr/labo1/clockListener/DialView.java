package ch.heigvd.mcr.labo1.clockListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DialView extends ClockView {
    private Line2D hoursNeedle, minutesNeedle, secondsNeedle;
    private String imgPath;

    public DialView(String imgPath, int width, int height) {
        super(width, height);
        this.imgPath = imgPath;

        Point center = new Point(getMinDimension() /2, getMinDimension()/2);
        hoursNeedle = new Line2D.Double(center , new Point(getMinDimension() /2, 100));
        minutesNeedle = new Line2D.Double(center , new Point(getMinDimension() /2,80));
        secondsNeedle = new Line2D.Double(center , new Point(getMinDimension() /2,50));
    }

    public void update(int totalSeconds){
        super.update(totalSeconds);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Affiche l'image
        graphics.drawImage(getScaledDialImage(imgPath),0,0,this);

        Point center = new Point(getMinDimension() / 2,getMinDimension() / 2);

        hoursNeedle.setLine(center , new Point(getMinDimension() /2, 100));
        minutesNeedle.setLine(center , new Point(getMinDimension() /2,80));
        secondsNeedle.setLine(center , new Point(getMinDimension() /2,50));

        rotateNeedle(graphics, secondsNeedle, 1, seconds(), Color.RED);
        rotateNeedle(graphics, minutesNeedle, 5, minutes(), Color.BLUE);
        rotateNeedle(graphics, hoursNeedle, 7, hours(), Color.BLACK);
    }

    private void rotateNeedle(Graphics graphics, Line2D line, int stroke, float angle, Color color) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(stroke));
        graphics2D.setColor(color);

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
        Image scaledImg = dialImg.getScaledInstance(getMinDimension(), getMinDimension(), Image.SCALE_SMOOTH);
        BufferedImage bufferedImg = new BufferedImage(getMinDimension(), getMinDimension(), BufferedImage.TYPE_INT_ARGB);

        //Reconvert into an BufferedImage
        Graphics2D g2d = bufferedImg.createGraphics();
        g2d.drawImage(scaledImg, 0, 0, null);
        g2d.dispose();

        return bufferedImg;
    }

    private int getMinDimension(){
        return Math.min(getHeight(),getWidth());
    }

}
