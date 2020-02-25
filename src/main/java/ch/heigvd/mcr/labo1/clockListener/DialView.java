package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DialView extends ClockView {
    private JLabel clockImg = new JLabel();

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
    }

    public void update(int totalSeconds){
        super.update(totalSeconds);


    }
}
