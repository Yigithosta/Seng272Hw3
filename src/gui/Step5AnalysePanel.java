package gui;

import model.Dimension; // Senin modelin
import model.Scenario;

import javax.swing.*;
import java.awt.*; // java.awt.Dimension burada

public class Step5AnalysePanel extends JPanel {

    public Step5AnalysePanel(MainFrame frame) {
        // Ana yerleşim düzeni
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Başlık
        JLabel title = new JLabel("Step 5 - Analyse");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        Scenario scenario = frame.getSelectedScenario();

        // Sol Panel: İlerleme Çubukları (Progress Bars)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        double lowestScore = Double.MAX_VALUE;
        String worstDimension = "";

        for (Dimension dimension : scenario.getDimensions()) {
            double score = dimension.calculateDimensionScore();

            // Skorları 0-5 arası varsayarak progress barı 0-50 (veya 0-100) ölçeğine çekiyoruz
            JProgressBar progressBar = new JProgressBar(0, 50);
            progressBar.setValue((int) Math.round(score * 10));
            progressBar.setString(dimension.getName() + " : " + score);
            progressBar.setStringPainted(true);

            /* HATA BURADAYDI: java.awt.Dimension olduğunu açıkça belirttik.
               Böylece model.Dimension ile karışmaz.
            */
            progressBar.setMaximumSize(new java.awt.Dimension(420, 30));
            progressBar.setAlignmentX(Component.LEFT_ALIGNMENT);

            leftPanel.add(progressBar);
            leftPanel.add(Box.createVerticalStrut(10));

            // En düşük skoru bulma
            if (score < lowestScore) {
                lowestScore = score;
                worstDimension = dimension.getName();
            }
        }

        // Sağ Panel: Radar Grafiği
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Radar Chart (Bonus)"));
        rightPanel.add(new RadarChartPanel(scenario.getDimensions()), BorderLayout.CENTER);

        // Orta Gövde: Sol ve Sağ paneli birleştirir
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        add(centerPanel, BorderLayout.CENTER);

        // Analiz Hesaplamaları
        double gap = Math.round((5.0 - lowestScore) * 100.0) / 100.0;
        String qualityLabel = getQualityLevel(lowestScore);

        // Alt Panel: Analiz Sonuçları ve Navigasyon
        JPanel bottomContainer = new JPanel(new BorderLayout());

        JPanel gapAnalysisPanel = new JPanel();
        gapAnalysisPanel.setLayout(new BoxLayout(gapAnalysisPanel, BoxLayout.Y_AXIS));
        gapAnalysisPanel.setBorder(BorderFactory.createTitledBorder("Gap Analysis"));

        gapAnalysisPanel.add(new JLabel("Lowest Dimension: " + worstDimension));
        gapAnalysisPanel.add(new JLabel("Score: " + lowestScore));
        gapAnalysisPanel.add(new JLabel("Gap Value: " + gap));
        gapAnalysisPanel.add(new JLabel("Quality Level: " + qualityLabel));

        JLabel adviceLabel = new JLabel("This dimension has the lowest score and requires the most improvement.");
        adviceLabel.setForeground(Color.RED);
        gapAnalysisPanel.add(adviceLabel);

        bottomContainer.add(gapAnalysisPanel, BorderLayout.CENTER);

        // Buton Paneli
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.showStep("4"));
        navPanel.add(backButton);

        bottomContainer.add(navPanel, BorderLayout.SOUTH);

        add(bottomContainer, BorderLayout.SOUTH);
    }

    // Kalite seviyesini belirleyen yardımcı metod
    private String getQualityLevel(double score) {
        if (score >= 4.5) return "Excellent";
        if (score >= 3.5) return "Good";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor";
    }
}