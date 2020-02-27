package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;
import java.awt.*;

public abstract class ClockView extends JLabel {
    private int allSeconds;

    public ClockView(int width, int height) {
        setSize(width, height);
    }

    public void update(int seconds){
        this.allSeconds = seconds;
    }

    int hours(){
        return allSeconds / 3600;
    }
    int minutes(){
        return  (allSeconds % 3600) / 60;
    }
    int seconds(){
        return allSeconds % 60;
    }
}
