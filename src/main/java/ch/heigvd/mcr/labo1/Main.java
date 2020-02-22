package ch.heigvd.mcr.labo1;

import ch.heigvd.mcr.labo1.GUI.NumericViewGui;
import ch.heigvd.mcr.labo1.clockListener.NumericView;
import ch.heigvd.mcr.labo1.engine.Clock;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        NumericViewGui numericViewGui = new NumericViewGui(clock);
    }
}
