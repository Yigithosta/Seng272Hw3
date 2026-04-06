package gui;

import model.Dimension;
import model.Metric;
import model.Scenario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Step4CollectPanel extends JPanel {

    public Step4CollectPanel(MainFrame frame) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Step 4 - Collect Data");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        Scenario scenario = frame.getSelectedScenario();

        String[] columns = {"Metric", "Direction", "Range", "Value", "Score (1-5)", "Coeff / Unit"};
        List<String[]> rows = new ArrayList<>();

        for (Dimension dimension : scenario.getDimensions()) {
            for (Metric metric : dimension.getMetrics()) {
                rows.add(new String[]{
                        metric.getName(),
                        metric.getDirection(),
                        metric.getRangeText(),
                        String.valueOf(metric.getValue()),
                        String.valueOf(metric.calculateScore()),
                        metric.getCoefficient() + " / " + metric.getUnit()
                });
            }
        }

        String[][] data = rows.toArray(new String[0][]);

        JTable table = new JTable(data, columns);
        table.setRowHeight(24);
        table.setEnabled(false);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        JButton nextButton = new JButton("Next");

        backButton.addActionListener(e -> frame.showStep("3"));
        nextButton.addActionListener(e -> frame.showStep("5"));

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}