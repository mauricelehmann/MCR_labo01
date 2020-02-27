package ch.heigvd.mcr.labo1.GUI;

import ch.heigvd.mcr.labo1.clockListener.DialView;
import ch.heigvd.mcr.labo1.clockListener.NumericView;
import ch.heigvd.mcr.labo1.engine.Clock;

import javax.swing.*;
import java.awt.*;

public class ControlPanelGUI {
    private final String BASE_IMG_PATH = "/img/";
    private final String ARABIC_DIAL_IMG_PATH = BASE_IMG_PATH + "clock1.jpg";
    private final String ROMAN_DIAL_IMG_PATH = BASE_IMG_PATH + "clock2.jpg";

    private JButton numericViewButton = new JButton("Horloge numérique");
    private JButton dialRomanViewButton = new JButton("Horloge romaine");
    private JButton dialArabicViewButton = new JButton("Horloge arabe");
    private JButton mixedClockViewButton = new JButton("Horloge mixte");

    private Clock clock;

    public ControlPanelGUI(Clock clock) {

        this.clock = clock;
        JButton startClockButton = new JButton("Démarrer");
        JButton stopClockButton = new JButton("Arreter");
        JButton resetClockButton = new JButton("Réinitialiser");
        JButton exitButton = new JButton("Quitter");

        // initialize frame
        JFrame controlPanelWindow = new JFrame("JHorloge");
        controlPanelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanelWindow.setPreferredSize(new Dimension(650, 100));
        controlPanelWindow.setLayout(new FlowLayout());

        // Add action to buttons
        dialRomanViewButton.addActionListener(actionEvent ->
                initDialView(createWindow(dialRomanViewButton.getText()), ROMAN_DIAL_IMG_PATH)
        );

        dialArabicViewButton.addActionListener(actionEvent ->
                initDialView(createWindow(dialArabicViewButton.getText()), ARABIC_DIAL_IMG_PATH)
        );

        numericViewButton.addActionListener(actionEvent ->
                initNumericView(createWindow(numericViewButton.getText()))
        );

        mixedClockViewButton.addActionListener(actionEvent ->
                createMixedView(createWindow(mixedClockViewButton.getText()))
        );

        startClockButton.addActionListener(actionEvent -> clock.start());
        resetClockButton.addActionListener(actionEvent -> clock.reset());
        stopClockButton.addActionListener(actionEvent -> clock.stop());

        // Add elements to content pane of frame

        controlPanelWindow.add(dialRomanViewButton);
        controlPanelWindow.add(dialArabicViewButton);
        controlPanelWindow.add(numericViewButton);
        controlPanelWindow.add(mixedClockViewButton);
        controlPanelWindow.add(startClockButton);
        controlPanelWindow.add(stopClockButton);
        controlPanelWindow.add(resetClockButton);
        controlPanelWindow.add(exitButton);

        controlPanelWindow.pack();
        controlPanelWindow.setVisible(true);
    }

    private JFrame createWindow(String name) {
        JFrame window = new JFrame(name);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(300, 300);
        window.setVisible(true);
        return window;
    }

    private void initNumericView(JFrame window) {
        NumericView numericView = new NumericView(300, 300);
        window.add(numericView);
        clock.addClockListener(numericView);
    }

    private void initDialView(JFrame window, String imgPath){
        DialView dialView = new DialView(imgPath, window.getWidth(), window.getHeight());
        window.add(dialView);
        clock.addClockListener(dialView);
    }

    private void createMixedView(JFrame window) {
        window.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        initDialView(window, ROMAN_DIAL_IMG_PATH);
        initDialView(window, ARABIC_DIAL_IMG_PATH);
        initNumericView(window);
        window.pack();
    }
}
