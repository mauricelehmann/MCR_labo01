package ch.heigvd.mcr.labo1.engine;

import ch.heigvd.mcr.labo1.clockListener.ClockView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Give the time to his listeners views.
 * The time is always store in seconds. The listener are notified every tick and gets the total amount of seconds
 */
public class Clock {

	//List of all listener of the instance
    ArrayList<ClockView> clockListener = new ArrayList<ClockView>();
    private Timer timer;
    private int seconds;

    /**
     * Start the clock
     */
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
        }, 0, 1000);
    }

    /**
     * Reset the clock
     */
    public void reset(){
        setTime(0);
        this.sendUpdate();
    }

    /*
     * Stop the clock or start it if already stopped
     */
    public void stop() {
        if(timer != null) {
            timer.cancel();
            timer = null;
        }else{
            start();
        }
    }

    /**
     * Add an observer to the instance
     * @param view observer
     */
    public void addClockListener(ClockView view){
        clockListener.add(view);
    }

    /**
     * Set the time (in seconds)
     * @param time
     */
    private void setTime(int time){
        this.seconds = time;
    }

    /**
     * Notify the listeners (send the total amount of seconds since the start of the clock)
     */
    private void sendUpdate(){
        for(ClockView cv : clockListener){
            cv.update(seconds);
        }
    }
}
