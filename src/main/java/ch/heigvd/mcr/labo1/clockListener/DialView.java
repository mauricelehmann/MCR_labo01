package ch.heigvd.mcr.labo1.clockListener;

import ch.heigvd.mcr.labo1.GUI.Needle;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DialView extends ClockView {
    private JLabel clockImg = new JLabel();
    private Needle hoursNeedle, minutesNeedle, secondsNeedle;

    public DialView(JPanel panel, String imgPath) {
        super(panel);

        //Set image of the dial on background
        URL path = DialView.class.getResource(imgPath);
        //rescale img
        ImageIcon ic = new ImageIcon(path);
        Image dialImg = ic.getImage();
        dialImg = dialImg.getScaledInstance(panel.getSize().height - 50,panel.getSize().width - 50,java.awt.Image.SCALE_SMOOTH);
        ic = new ImageIcon(dialImg);
        clockImg.setIcon(ic);
        panel.add(clockImg);

        //Add the needles
        Point center = new Point(panel.getWidth() / 2,panel.getHeight() / 2);

        hoursNeedle = new Needle(center, 180, 10);
        minutesNeedle = new Needle(center, 190, 5);
        secondsNeedle = new Needle(center, 200, 1);

        panel.add(hoursNeedle);
        panel.add(minutesNeedle);
        panel.add(secondsNeedle);
    }

    public void update(int totalSeconds){
        super.update(totalSeconds);

        hoursNeedle.update(totalSeconds / 60);
        minutesNeedle.update((totalSeconds % 3600) / 60);
        secondsNeedle.update(totalSeconds % 60);
    }
}
