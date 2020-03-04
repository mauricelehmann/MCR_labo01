/*
 * File:   NumericView.java
 * MCR - Labo 1
 * Author: Maurice Lehmann, Simon Walther
 *
 * Created on 4 March 2020
 */
package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;
import java.awt.*;

/**
 * GUI view of a numeric clock
 * Gets the time from the subject engine Clock as an observer
 */
public class NumericView extends ClockView {
    private JLabel timeLabel;

    /**
     * Constructor
     * @param width of the panel
     * @param height of the panel
     */
    public NumericView(int width, int height) {
        super(width, height);
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        add(timeLabel);
    }

    /**
     * Update the view
     * @param totalSeconds
     */
    public void update(int totalSeconds){
        super.update(totalSeconds);
        timeLabel.setText(String.format("%02d:%02d:%02d", hours(), minutes(), seconds()));
    }
}
