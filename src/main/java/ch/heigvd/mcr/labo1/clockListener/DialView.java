package ch.heigvd.mcr.labo1.clockListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * GUI view of a Dial
 * Gets the time from the subject engine Clock as an observer
 */
public class DialView extends ClockView {

    private Line2D hoursNeedle, minutesNeedle, secondsNeedle;
    private BufferedImage dialImg;

    //Constructor
    public DialView(String imgPath, int width, int height) {
        super(width, height);
        //Init. the needles
        int minDimensionCenter = getMinDimension() / 2;
        Point center = new Point(minDimensionCenter, minDimensionCenter);
        hoursNeedle = new Line2D.Double(center , new Point(minDimensionCenter, 100));
        minutesNeedle = new Line2D.Double(center , new Point(minDimensionCenter,80));
        secondsNeedle = new Line2D.Double(center , new Point(minDimensionCenter,50));

        try {
            dialImg = ImageIO.read(DialView.class.getResource(imgPath));
        } catch (IOException ex){
            System.out.println("Can't load image " + imgPath);
        }
    }

    public void update(int totalSeconds){
        super.update(totalSeconds);
        repaint();
    }


    /**
     * Paint the current DialView instance
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Affiche l'image
        graphics.drawImage(getScaledDialImage(),0,0,this);

        int minDimensionCenter = getMinDimension() / 2;
        Point center = new Point(minDimensionCenter, minDimensionCenter);

        hoursNeedle.setLine(center , new Point(minDimensionCenter, 100));
        minutesNeedle.setLine(center , new Point(minDimensionCenter,80));
        secondsNeedle.setLine(center , new Point(minDimensionCenter,50));

        rotateNeedle(graphics, secondsNeedle, 1, seconds(), Color.RED);
        rotateNeedle(graphics, minutesNeedle, 5, minutes(), Color.BLUE);
        rotateNeedle(graphics, hoursNeedle, 7, hours(), Color.BLACK);
    }

    /**
     *
     * @param graphics Graphic component from paintComponent() method
     * @param line Line2D, the needle line
     * @param stroke Thickness of the needle
     * @param angle New angle of the needle
     * @param color Color of the needle
     */
    private void rotateNeedle(Graphics graphics, Line2D line, int stroke, float angle, Color color) {

        Graphics2D graphics2D = (Graphics2D) graphics;
        //Set the stroke & color of the needle
        graphics2D.setStroke(new BasicStroke(stroke));
        graphics2D.setColor(color);

        //Rotate the needles : the angles are in radian so to do a 360° in 60 iterations we need to multiplie by six.
        AffineTransform rotation =
                AffineTransform.getRotateInstance (
                        Math.toRadians(angle * 6), line.getX1(), line.getY1()
                );

        graphics2D.draw(rotation.createTransformedShape(line));
    }

    /**
     * Get the dial image in the right dimensions
     * @return BufferedImage scaled
     */
    private BufferedImage getScaledDialImage(){
        // Rescale the image
        Image scaledImg = dialImg.getScaledInstance(getMinDimension(), getMinDimension(), Image.SCALE_FAST);
        BufferedImage bufferedImg = new BufferedImage(getMinDimension(), getMinDimension(), BufferedImage.TYPE_INT_ARGB);

        // Reconvert into an BufferedImage
        Graphics2D g2d = bufferedImg.createGraphics();
        g2d.drawImage(scaledImg, 0, 0, this);
        g2d.dispose();

        return bufferedImg;
    }

    /**
     * Get the dimension of the JFrame parent (square mode)
     * @return
     */
    private int getMinDimension(){
        return Math.min(getHeight(),getWidth());
    }

}
