package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;

public class NumericView extends ClockView {
    private JFrame frame = new JFrame("My First GUI");
    private JLabel time;

    public NumericView(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        time = new JLabel("00h 00m 00s");
        frame.setVisible(true);
        frame.add(time);
    }
    public void update(int totalSeconds){
        super.update(totalSeconds);
        time.setText(String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds()));
    }
}
