import GUI.NumericViewGui;
import clockListener.NumericView;
import engine.Clock;
import clockListener.ClockView;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {




        Clock clock = new Clock();
        clock.addClockListener(new NumericView());


        clock.start();
        TimeUnit.SECONDS.sleep(10);
        clock.stop();
        System.out.println("FIN");


    }

}
