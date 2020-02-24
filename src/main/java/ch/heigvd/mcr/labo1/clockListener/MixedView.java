package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;

public class MixedView {
    private NumericView numericView = null;
    private DialView arabicDialView = null;
    private DialView romanDialView = null;

    public MixedView(NumericView numericView, DialView arabicDialView, DialView romanDialView) {
        this.numericView = numericView;
        this.arabicDialView = arabicDialView;
        this.romanDialView = romanDialView;
    }
}
