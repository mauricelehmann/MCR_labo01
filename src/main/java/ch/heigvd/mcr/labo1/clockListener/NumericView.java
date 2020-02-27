package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;

public class NumericView extends ClockView {
    public NumericView(int width, int height) {
        super(width, height);

        setText("00:00:00");
    }

    public void update(int totalSeconds){
        super.update(totalSeconds);
        setText(String.format("%02d:%02d:%02d", hours(), minutes(), seconds()));
    }
}
