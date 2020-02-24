package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;

public abstract class ClockView {
    private JPanel panel = null;
    private int allSeconds;

    public ClockView(JPanel panel) {
        this.panel = panel;
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
