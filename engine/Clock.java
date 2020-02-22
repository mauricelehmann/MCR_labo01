package engine;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import clockListener.ClockView;

public class Clock {

    ArrayList<ClockView> clockListener = new ArrayList<ClockView>();
    private Timer timer;
    private int seconds;

    public void start(){
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("tic tac");
                for(ClockView cv : clockListener){
                    cv.update(seconds);
                }
                setTime(seconds + 1);
            }
        }, 0, 10);
    }
    public void reset(){
        seconds = 0;
    }
    public void stop() throws InterruptedException {
        timer.cancel();
        this.reset();
    }

    public void addClockListener(ClockView view){
        clockListener.add(view);
    }
    public void setTime(int time){
        this.seconds = time;
    }
}
