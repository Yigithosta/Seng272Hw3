package gui;

import model.AppData;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Step2DefinePanel extends JPanel {

    public Step2DefinePanel(MainFrame frame) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Step 2 - Define Quality Dimensions");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Quality Type
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typePanel.setBorder(BorderFactory.createTitledBorder("Quality Type"));
        JRadioButton productButton = new JRadioButton("Product");
        JRadioButton processButton = new JRadioButton("Process");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(productButton);
        typeGroup.add(processButton);

        if ("Process".equals(frame.getQualityType())) {
            processButton.setSelected(true);
        } else {
            productButton.setSelected(true);
        }

        typePanel.add(productButton);
        typePanel.add(processButton);

        // Mode
        JPanel modePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modePanel.setBorder(BorderFactory.createTitledBorder("Mode"));
        JRadioButton healthButton = new JRadioButton("Health");
        JRadioButton educationButton = new JRadioButton("Education");
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(healthButton);
        modeGroup.add(educationButton);

        if ("Health".equals(frame.getMode())) {
            healthButton.setSelected(true);
        } else {
            educationButton.setSelected(true);
        }

        modePanel.add(healthButton);
        modePanel.add(educationButton);

        // Scenario
        JPanel scenarioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scenarioPanel.setBorder(BorderFactory.createTitledBorder("Scenario"));
        JComboBox<String> scenarioComboBox = new JComboBox<>();

        Runnable fillScenarioBox = () -> {
            scenarioComboBox.removeAllItems();
            String selectedMode = healthButton.isSelected() ? "Health" : "Education";
            List<String> scenarios = AppData.getScenarioNamesByMode(selectedMode);
            for (String s : scenarios) {
                scenarioComboBox.addItem(s);
            }
        };

        fillScenarioBox.run();
        scenarioComboBox.setSelectedItem(frame.getScenarioName());

        healthButton.addActionListener(e -> fillScenarioBox.run());
        educationButton.addActionListener(e -> fillScenarioBox.run());

        scenarioPanel.add(scenarioComboBox);

        centerPanel.add(typePanel);
        centerPanel.add(modePanel);
        centerPanel.add(scenarioPanel);

        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        JButton nextButton = new JButton("Next");

        backButton.addActionListener(e -> frame.showStep("1"));

        nextButton.addActionListener(e -> {
            String selectedType = productButton.isSelected() ? "Product" : "Process";
            String selectedMode = healthButton.isSelected() ? "Health" : "Education";
            String selectedScenario = (String) scenarioComboBox.getSelectedItem();

            if (selectedScenario == null || selectedScenario.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please select a scenario to continue.",
                        "Missing Selection",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            frame.setQualityType(selectedType);
            frame.setMode(selectedMode);
            frame.setScenarioName(selectedScenario);
            frame.rebuildScenario();
            frame.refreshPanelsAfterScenarioChange();
            frame.showStep("3");
        });

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}