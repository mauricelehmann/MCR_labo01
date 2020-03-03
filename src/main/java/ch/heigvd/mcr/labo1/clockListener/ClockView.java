package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class ClockView
 * When the subject notify the clockview, it give the total amount of seconds
 * The observer (ClockView instance) decompose the total amount of seconds in minutes, hours and seconds
 */
public abstract class ClockView extends JPanel {
    private int allSeconds;

    /**
     * Set the default size of the windows
     * @param width
     * @param height
     */
    public ClockView(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
    }

    /**
     * Update the total amount of seconds
     * @param seconds
     */
    public void update(int seconds){
        this.allSeconds = seconds;
    }

    /**
     * Get hours from total amount of seconds
     * @return hours
     */
    int hours(){
        return allSeconds / 3600;
    }
    /**
     * Get minutes from seconds
     * @return minutes
     */
    int minutes(){
        return  (allSeconds % 3600) / 60;
    }
    /**
     * Get remaining seconds from total amount of seconds
     * @return seconds
     */
    int seconds(){
        return allSeconds % 60;
    }
}
