/*
 * File:   ControlPanelGUI.java
 * MCR - Labo 1
 * Author: Maurice Lehmann, Simon Walther
 *
 * Created on 4 March 2020
 */
package ch.heigvd.mcr.labo1.GUI;

import ch.heigvd.mcr.labo1.clockListener.DialView;
import ch.heigvd.mcr.labo1.clockListener.NumericView;
import ch.heigvd.mcr.labo1.engine.Clock;

import javax.swing.*;
import java.awt.*;

/**
 * Main control panel. Contains the buttons to start, initialize, stop the clock and create other GUI frames.
 */
public class ControlPanelGUI {
    private final String BASE_IMG_PATH = "/img/";
    private final String ARABIC_DIAL_IMG_PATH = BASE_IMG_PATH + "clock1.jpg";
    private final String ROMAN_DIAL_IMG_PATH = BASE_IMG_PATH + "clock2.jpg";

    private JButton numericViewButton = new JButton("Horloge numérique");
    private JButton dialRomanViewButton = new JButton("Horloge romaine");
    private JButton dialArabicViewButton = new JButton("Horloge arabe");
    private JButton mixedClockViewButton = new JButton("Horloge mixte");
    private JButton startClockButton = new JButton("Démarrer");
    private JButton stopClockButton = new JButton("Arreter");
    private JButton resetClockButton = new JButton("Réinitialiser");
    private JButton exitButton = new JButton("Quitter");

    private JFrame controlPanelWindow;
    private Clock clock;

    /**
     * Constructor
     *
     * @param clock the clock
     */
    public ControlPanelGUI(Clock clock) {
        this.clock = clock;

        // initialize frame
        controlPanelWindow = new JFrame();

        controlPanelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanelWindow.setPreferredSize(new Dimension(650, 200));
        controlPanelWindow.setLayout(new FlowLayout());

        // Add action to buttons
        dialRomanViewButton.addActionListener(actionEvent ->
                createDialView(createWindow(dialRomanViewButton.getText()), ROMAN_DIAL_IMG_PATH)
        );

        dialArabicViewButton.addActionListener(actionEvent ->
                createDialView(createWindow(dialArabicViewButton.getText()), ARABIC_DIAL_IMG_PATH)
        );

        numericViewButton.addActionListener(actionEvent ->
                createNumericView(createWindow(numericViewButton.getText()))
        );

        mixedClockViewButton.addActionListener(actionEvent ->
                createMixedView(createWindow(mixedClockViewButton.getText()))
        );

        startClockButton.addActionListener(actionEvent -> clock.start());
        resetClockButton.addActionListener(actionEvent -> clock.reset());
        stopClockButton.addActionListener(actionEvent -> clock.stop());
        exitButton.addActionListener(actionEvent -> System.exit(0));

        // Add elements to content pane of frame
        controlPanelWindow.getContentPane().add(dialRomanViewButton);
        controlPanelWindow.getContentPane().add(dialArabicViewButton);
        controlPanelWindow.getContentPane().add(numericViewButton);
        controlPanelWindow.getContentPane().add(mixedClockViewButton);
        controlPanelWindow.getContentPane().add(startClockButton);
        controlPanelWindow.getContentPane().add(stopClockButton);
        controlPanelWindow.getContentPane().add(resetClockButton);
        controlPanelWindow.getContentPane().add(exitButton);

        controlPanelWindow.pack();
        controlPanelWindow.setVisible(true);
    }

    /**
     * Init. a new frame
     *
     * @param name the window's name
     * @return the new JFrame
     */
    private JFrame createWindow(String name) {
        JFrame window = new JFrame(name);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(300, 300);
        window.setVisible(true);
        return window;
    }

    /**
     * Create the GUI numeric view
     *
     * @param window the window on which to put the view
     * @return the created view
     */
    private NumericView createNumericView(JFrame window) {
        NumericView numericView = new NumericView(300, 300);
        window.add(numericView);

        clock.addClockListener(numericView);

        return numericView;
    }

    /**
     * Create the GUI dial view
     *
     * @param window the window on which to put the view
     * @param imgPath the dial background image
     * @return DialView the created view
     */
    private DialView createDialView(JFrame window, String imgPath){
        DialView dialView = new DialView(imgPath, window.getWidth(), window.getHeight());
        window.add(dialView);
        clock.addClockListener(dialView);

        return dialView;
    }

    /**
     * Create mixed view with two Dialview (roman & arabic) and numeric view
     *
     * @param window the window on which to put the view
     */
    private void createMixedView(JFrame window) {
        window.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        createDialView(window, ROMAN_DIAL_IMG_PATH);
        createDialView(window, ARABIC_DIAL_IMG_PATH);
        createNumericView(window);
        window.pack();
    }
}
