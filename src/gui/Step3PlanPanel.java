package gui;

import model.Dimension;
import model.Metric;
import model.Scenario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Step3PlanPanel extends JPanel {

    public Step3PlanPanel(MainFrame frame) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Step 3 - Plan Measurement");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        Scenario scenario = frame.getSelectedScenario();

        String[] columns = {"Dimension", "Metric", "Coeff", "Direction", "Range", "Unit"};
        List<String[]> rows = new ArrayList<>();

        for (Dimension dimension : scenario.getDimensions()) {
            for (Metric metric : dimension.getMetrics()) {
                rows.add(new String[]{
                        dimension.getName() + " (" + dimension.getCoefficient() + ")",
                        metric.getName(),
                        String.valueOf(metric.getCoefficient()),
                        metric.getDirection(),
                        metric.getRangeText(),
                        metric.getUnit()
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

        backButton.addActionListener(e -> frame.showStep("2"));
        nextButton.addActionListener(e -> frame.showStep("4"));

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}