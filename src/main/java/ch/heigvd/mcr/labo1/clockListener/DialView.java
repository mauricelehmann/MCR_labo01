package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DialView extends ClockView {
    private JLabel time;

    public DialView(JFrame frame) {
        URL path = DialView.class.getResource("/img/clock1.jpg");

        ImageIcon ic = new ImageIcon(path);
        Image dialImg = ic.getImage();
        dialImg = dialImg.getScaledInstance(frame.getSize().height - 50,frame.getSize().width - 50,java.awt.Image.SCALE_SMOOTH);
        ic = new ImageIcon(dialImg);
        JLabel img = new JLabel(ic,SwingConstants.CENTER);
        
        frame.add(img);
        frame.setVisible(true);

    }
    public void update(int totalSeconds){
        super.update(totalSeconds);

    }
}
