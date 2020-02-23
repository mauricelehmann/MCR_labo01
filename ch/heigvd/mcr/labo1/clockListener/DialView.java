package ch.heigvd.mcr.labo1.clockListener;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class DialView extends ClockView{
    private JLabel time;

    public DialView(JFrame frame) {

        String path = "C:\\Users\\mle\\Desktop\\COURS\\2 eme\\SEMESTRE 2\\MCR\\Labos\\01\\source\\src\\ch\\heigvd\\mcr\\labo1\\img\\clock1.jpg";

        ImageIcon ic = new ImageIcon(path);
        Image dialImg = ic.getImage();
        dialImg = dialImg.getScaledInstance(frame.getSize().height - 50,frame.getSize().width - 50,java.awt.Image.SCALE_SMOOTH);
        ic = new ImageIcon(dialImg);
        JLabel img = new JLabel(ic,SwingConstants.CENTER);
        
        frame.add(img);
        frame.setVisible(true);

    }
    public void update(int totalSeconds){
        super.update(totalSeconds);

    }
}
