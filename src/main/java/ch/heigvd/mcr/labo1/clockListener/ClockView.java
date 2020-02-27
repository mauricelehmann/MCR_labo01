package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;

public abstract class ClockView {
    private int allSeconds;

    protected ClockView() {}

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
