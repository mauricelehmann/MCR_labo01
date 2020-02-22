package ch.heigvd.mcr.labo1;

import ch.heigvd.mcr.labo1.clockListener.NumericView;
import ch.heigvd.mcr.labo1.engine.Clock;
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
