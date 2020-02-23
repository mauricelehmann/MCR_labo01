package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;

public class DialView extends ClockView{
    private JLabel time;

    public DialView(JFrame frame) {
        frame.add(new JLabel(new ImageIcon("clock1.jpg")));
        frame.setVisible(true);

    }
    public void update(int totalSeconds){
        super.update(totalSeconds);

    }
}
