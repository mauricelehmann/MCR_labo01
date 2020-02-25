package ch.heigvd.mcr.labo1;

import ch.heigvd.mcr.labo1.GUI.ControlPanelGUI;
import ch.heigvd.mcr.labo1.engine.Clock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ControlPanelGUI numericViewGui = new ControlPanelGUI(new Clock());
    }
}
