package ch.heigvd.mcr.labo1.GUI;

import ch.heigvd.mcr.labo1.clockListener.DialView;
import ch.heigvd.mcr.labo1.clockListener.NumericView;
import ch.heigvd.mcr.labo1.engine.Clock;

import javax.swing.*;
import java.awt.*;

public class ControlPanelGUI {
    private final String BASE_IMG_PATH = "/img/";
    private final String ROMAN_DIAL_IMG_PATH = BASE_IMG_PATH + "clock1.jpg";
    private final String ARABIC_DIAL_IMG_PATH = BASE_IMG_PATH + "clock2.jpg";

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

    public ControlPanelGUI(Clock clock) {
        this.clock = clock;

        // initialize frame
        controlPanelWindow = new JFrame("My First GUI");
        controlPanelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanelWindow.setLayout(new GridLayout(2, 4));

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
        // TODO : close app exitButton.addActionListener(actionEvent -> );

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

    private JFrame createWindow(String name) {
        JFrame window = new JFrame(name);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 300);
        window.setVisible(true);
        return window;
    }

    private NumericView createNumericView(JFrame window) {
        JPanel panel = new JPanel();
        panel.setSize(300, 300);
        window.add(panel);

        NumericView numericView = new NumericView(panel);
        clock.addClockListener(numericView);

        return numericView;
    }

    private DialView createDialView(JFrame window, String imgPath){
        JPanel panel = new JPanel();
        panel.setSize(300, 300);
        window.add(panel);

        DialView dialView = new DialView(panel, imgPath);
        clock.addClockListener(dialView);

        return dialView;
    }

    private void createMixedView(JFrame window) {
        window.setLayout(new GridLayout(1, 3));

        DialView romanDialView = createDialView(window, ROMAN_DIAL_IMG_PATH);
        DialView arabicDialView = createDialView(window, ARABIC_DIAL_IMG_PATH);
        NumericView numericView = createNumericView(window);

        window.pack();
    }

}
