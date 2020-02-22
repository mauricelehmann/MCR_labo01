package ch.heigvd.mcr.labo1.GUI;

import ch.heigvd.mcr.labo1.clockListener.NumericView;
import ch.heigvd.mcr.labo1.engine.Clock;

import javax.swing.*;
import java.awt.*;

public class NumericViewGui {
    private JButton startClockButton = new JButton("Démarrer");
    private JButton numericViewButton = new JButton("Horloge numérique");
    private JFrame frame = null;
    private Clock clock = null;

    public NumericViewGui(Clock clock) {
        this.clock = clock;

        // initialize frame
        frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(new GridLayout(2, 4));

        startClockButton.addActionListener(actionEvent -> clock.start());
        numericViewButton.addActionListener(actionEvent -> createNumericView());

        // Add elements to content pane of frame
        frame.getContentPane().add(numericViewButton);
        frame.getContentPane().add(startClockButton);

        frame.pack();
        frame.setVisible(true);
    }

    public void createNumericView() {
        JFrame frame = new JFrame("Numeric clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);

        NumericView numericView = new NumericView(frame);
        clock.addClockListener(numericView);
    }
}
