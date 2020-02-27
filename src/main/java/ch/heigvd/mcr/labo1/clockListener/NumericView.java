package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;
import java.awt.*;

public class NumericView extends ClockView {
    private JLabel timeLabel;

    public NumericView(int width, int height) {
        super(width, height);
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        add(timeLabel);
    }

    public void update(int totalSeconds){
        super.update(totalSeconds);
        timeLabel.setText(String.format("%02d:%02d:%02d", hours(), minutes(), seconds()));
    }
}
