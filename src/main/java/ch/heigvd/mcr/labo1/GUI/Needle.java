package ch.heigvd.mcr.labo1.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Needle extends JPanel {
    private float angle;
    private int stroke;
    private Line2D line;

    public Needle(Point center, float length, int stroke) {
        this.stroke = stroke;
        this.line = new Line2D.Double(center.x, center.y, center.x, length);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // FIXME: pas besoin de le faire à chaque fois qu'on dessine le composant ?
        ((Graphics2D) graphics).setStroke(new BasicStroke(stroke));

        AffineTransform rotation =
                AffineTransform.getRotateInstance (
                        Math.toRadians(angle * 6), line.getX1(), line.getY1()
                );

        ((Graphics2D) graphics).draw(rotation.createTransformedShape(line));
    }

    public void update(float angle) {
        this.angle = angle;
        this.repaint();
    }
}
