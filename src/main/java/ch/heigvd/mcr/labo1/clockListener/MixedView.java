package ch.heigvd.mcr.labo1.clockListener;

public class MixedView {
    private NumericView numericView;
    private DialView arabicDialView;
    private DialView romanDialView;

    public MixedView(NumericView numericView, DialView arabicDialView, DialView romanDialView) {
        this.numericView = numericView;
        this.arabicDialView = arabicDialView;
        this.romanDialView = romanDialView;
    }
}
