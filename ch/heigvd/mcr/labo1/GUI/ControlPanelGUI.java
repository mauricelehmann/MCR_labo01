package ch.heigvd.mcr.labo1.GUI;

import ch.heigvd.mcr.labo1.clockListener.DialView;
import ch.heigvd.mcr.labo1.clockListener.NumericView;
import ch.heigvd.mcr.labo1.engine.Clock;

import javax.swing.*;
import java.awt.*;

public class ControlPanelGUI {
    private JButton startClockButton = new JButton("Démarrer");
    private JButton stopClockButton = new JButton("Arreter");
    private JButton resetClockButton = new JButton("Réinitialiser");
    private JButton numericViewButton = new JButton("Horloge numérique");
    private JButton dialRomanViewButton = new JButton("Horloge Romaine");

    private JFrame frame;
    private Clock clock;

    public ControlPanelGUI(Clock clock) {
        this.clock = clock;

        // initialize frame
        frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(new GridLayout(2, 4));

        startClockButton.addActionListener(actionEvent -> clock.start());
        numericViewButton.addActionListener(actionEvent -> createNumericView(numericViewButton.getText()));
        dialRomanViewButton.addActionListener(actionEvent -> createDialView(dialRomanViewButton.getText()));

        stopClockButton.addActionListener(actionEvent -> clock.stop());
        resetClockButton.addActionListener(actionEvent -> clock.reset());


        // Add elements to content pane of frame
        frame.getContentPane().add(numericViewButton);
        frame.getContentPane().add(dialRomanViewButton);
        frame.getContentPane().add(startClockButton);
        frame.getContentPane().add(stopClockButton);
        frame.getContentPane().add(resetClockButton);

        frame.pack();
        frame.setVisible(true);
    }

    private JFrame createView(String name){
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        return frame;
    }

    private void createNumericView(String name) {
        NumericView numericView = new NumericView(createView(name));
        clock.addClockListener(numericView);
    }

    private void createDialView(String dialtype){
        DialView dialView = new DialView(createView(dialtype));
        clock.addClockListener(dialView);
    }

}
