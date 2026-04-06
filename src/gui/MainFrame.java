package gui;

import model.AppData;
import model.Profile;
import model.Scenario;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private StepIndicatorPanel stepIndicatorPanel;

    private Profile profile;
    private String qualityType;
    private String mode;
    private String scenarioName;
    private Scenario selectedScenario;

    public MainFrame() {
        profile = new Profile();
        qualityType = "Product";
        mode = "Education";
        scenarioName = "Scenario C - Team Alpha";
        selectedScenario = AppData.createScenario(qualityType, mode, scenarioName);

        setTitle("ISO 15939 Measurement Process Simulator");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        stepIndicatorPanel = new StepIndicatorPanel();
        add(stepIndicatorPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new Step1ProfilePanel(this), "1");
        cardPanel.add(new Step2DefinePanel(this), "2");
        cardPanel.add(new Step3PlanPanel(this), "3");
        cardPanel.add(new Step4CollectPanel(this), "4");
        cardPanel.add(new Step5AnalysePanel(this), "5");

        add(cardPanel, BorderLayout.CENTER);

        showStep("1");
        setVisible(true);
    }

    public void showStep(String step) {
        cardLayout.show(cardPanel, step);
        stepIndicatorPanel.updateStep(Integer.parseInt(step));
    }

    public void refreshPanelsAfterScenarioChange() {
        cardPanel.removeAll();
        cardPanel.add(new Step1ProfilePanel(this), "1");
        cardPanel.add(new Step2DefinePanel(this), "2");
        cardPanel.add(new Step3PlanPanel(this), "3");
        cardPanel.add(new Step4CollectPanel(this), "4");
        cardPanel.add(new Step5AnalysePanel(this), "5");
        cardPanel.revalidate();
        cardPanel.repaint();
    }

    public Profile getProfile() {
        return profile;
    }

    public String getQualityType() {
        return qualityType;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public Scenario getSelectedScenario() {
        return selectedScenario;
    }

    public void rebuildScenario() {
        selectedScenario = AppData.createScenario(qualityType, mode, scenarioName);
    }
}