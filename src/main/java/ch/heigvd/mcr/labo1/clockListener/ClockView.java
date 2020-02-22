package ch.heigvd.mcr.labo1.clockListener;

public abstract class ClockView {
    private int allSeconds;

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
