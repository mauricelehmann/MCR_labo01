package ch.heigvd.mcr.labo1.engine;

import ch.heigvd.mcr.labo1.clockListener.ClockView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    ArrayList<ClockView> clockListener = new ArrayList<ClockView>();
    private Timer timer;
    private int seconds;

    public void start() {
        // if a timer is already running do nothing
        if(timer != null) {
            return;
        }
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Clock.this.sendUpdate();
                setTime(seconds + 1);
            }
        }, 0, 1);
    }

    public void reset(){
        setTime(0);
        this.sendUpdate();
    }

    //TODO : Enfaite il faut pouvoir faire "pause" en cliquant une fois , puis pouvoir reprendre en cliquant sur le MEME bouton !
    public void stop() {
        if(timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void addClockListener(ClockView view){
        clockListener.add(view);
    }
    private void setTime(int time){
        this.seconds = time;
    }
    private void sendUpdate(){
        for(ClockView cv : clockListener){
            cv.update(seconds);
        }
    }
}
