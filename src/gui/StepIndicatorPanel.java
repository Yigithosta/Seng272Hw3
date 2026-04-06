package gui;

import javax.swing.*;
import java.awt.*;

public class StepIndicatorPanel extends JPanel {

    private final JLabel[] labels;

    public StepIndicatorPanel() {
        setLayout(new GridLayout(1, 5, 8, 8));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        labels = new JLabel[5];
        String[] names = {"1. Profile", "2. Define", "3. Plan", "4. Collect", "5. Analyse"};

        for (int i = 0; i < names.length; i++) {
            labels[i] = new JLabel(names[i], SwingConstants.CENTER);
            labels[i].setOpaque(true);
            labels[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            labels[i].setBackground(new Color(235, 235, 235));
            add(labels[i]);
        }
    }

    public void updateStep(int activeStep) {
        for (int i = 0; i < labels.length; i++) {
            if (i + 1 < activeStep) {
                labels[i].setText("✓ " + labels[i].getText().replace("✓ ", ""));
                labels[i].setBackground(new Color(198, 239, 206));
                labels[i].setForeground(Color.BLACK);
            } else if (i + 1 == activeStep) {
                labels[i].setText(labels[i].getText().replace("✓ ", ""));
                labels[i].setBackground(new Color(189, 215, 238));
                labels[i].setForeground(Color.BLACK);
            } else {
                labels[i].setText(labels[i].getText().replace("✓ ", ""));
                labels[i].setBackground(new Color(235, 235, 235));
                labels[i].setForeground(Color.BLACK);
            }
        }
    }
}