package ch.heigvd.mcr.labo1.clockListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DialView extends ClockView {

    //TODO : Faut-il faire une interface pour cette classe interne ?! CF slide POO1 (167)
    private static class Needles extends JLabel {

        private Point center;
        private float secondAngle, minuteAngle, hourAngle, needleLength;
        private Graphics2D graphic2D;

        private Needles(Point center, float needleLength){
            this.center = center;
            this.needleLength = needleLength;
            this.repaint();
        }

        private void paintNeedle(float length, float angle, int stroke){

            //Draw a needle with the right angle
            Line2D needle = new Line2D.Double(center.x, center.y, center.x , length );
            AffineTransform rotation =
                    AffineTransform.getRotateInstance(
                            Math.toRadians(angle * 6), needle.getX1(), needle.getY1());

            graphic2D.setStroke(new BasicStroke(stroke)); //épaisseur
            graphic2D.draw(rotation.createTransformedShape(needle));

        }

        protected void paintComponent(Graphics graphic) {

            super.paintComponent(graphic);
            this.graphic2D = (Graphics2D) graphic;

            //Hour
            this.paintNeedle(needleLength + 40, hourAngle, 10);
            //Minute
            this.paintNeedle(needleLength + 10, minuteAngle, 5);
            //Second
            this.paintNeedle(needleLength, secondAngle, 1);

        }

        private void update(int second, int minute, int hour){
            this.secondAngle = second ;
            this.minuteAngle = minute ;
            this.hourAngle = hour;
            this.repaint();
        }
    }

    private Needles needles;

    public DialView(JFrame window, String imgPath) {

        BufferedImage dialImage = getScaledDialImage(window, imgPath);

        //Add the needles
        needles = new Needles(new Point(window.getWidth() / 2, window.getHeight() / 2), 40);
        needles.setIcon(new ImageIcon(dialImage));

        window.add(needles);
        window.pack();

    }

    public void update(int totalSeconds){
        super.update(totalSeconds);
        needles.update(seconds(),minutes(),hours());

    }
    private BufferedImage getScaledDialImage(JFrame window, String path){
        //Set image of the dial on background
        //URL path = DialView.class.getResource(imgPath);
        BufferedImage dialImg = null;
        try {
            dialImg = ImageIO.read(DialView.class.getResource(path));
        }catch (IOException ex){
            //TODO do something!
        }

        //Rescale the image
        Image scaledImg = dialImg.getScaledInstance(window.getSize().width, window.getSize().height, Image.SCALE_SMOOTH);
        BufferedImage bufferedImg = new BufferedImage(window.getSize().width, window.getSize().height, BufferedImage.TYPE_INT_ARGB);

        //Reconvert into an BufferedImage
        Graphics2D g2d = bufferedImg.createGraphics();
        g2d.drawImage(scaledImg, 0, 0, null);
        g2d.dispose();

        return bufferedImg;
    }

}
