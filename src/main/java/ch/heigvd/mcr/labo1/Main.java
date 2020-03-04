/*
 * File:   Main.java
 * MCR - Labo 1
 * Author: Maurice Lehmann, Simon Walther
 *
 * Created on 4 March 2020
 */
package ch.heigvd.mcr.labo1;

import ch.heigvd.mcr.labo1.GUI.ControlPanelGUI;
import ch.heigvd.mcr.labo1.engine.Clock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ControlPanelGUI numericViewGui = new ControlPanelGUI(new Clock());
    }
}
