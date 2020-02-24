package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;

public class NumericView extends ClockView {
    private JLabel time;

    public NumericView(JFrame frame) {
        time = new JLabel("00:00:00");
        frame.add(time);
        frame.setVisible(true);
    }
    public void update(int totalSeconds){
        super.update(totalSeconds);
        time.setText(String.format("%02d:%02d:%02d", hours(), minutes(), seconds()));
    }
}
