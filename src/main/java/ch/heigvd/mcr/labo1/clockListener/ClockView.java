package ch.heigvd.mcr.labo1.clockListener;

public abstract class ClockView {

    private int allSeconds;

    public void update(int seconds){
        this.allSeconds = seconds;
    }
    int getHours(){
        return allSeconds / 3600;
    }
    int getMinutes(){
        return  (allSeconds % 3600) / 60;
    }
    int getSeconds(){
        return allSeconds % 60;
    }
}
