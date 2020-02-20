import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Main {
    private Timer timer;
    Main(){
        timer = new Timer();
    }

    public void start(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("coucou");
            }
        }, 0, 1000);
    }
    public void pause()
    {
        timer.cancel(); 
    }


    public static void main(String[] args) throws InterruptedException {
        Main m1 = new Main();
        m1.start();
        TimeUnit.SECONDS.sleep(10);
        m1.pause();
        System.out.println("FIN");
    }

}
