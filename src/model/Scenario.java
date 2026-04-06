package model;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private String qualityType;
    private String mode;
    private String scenarioName;
    private List<Dimension> dimensions;

    public Scenario(String qualityType, String mode, String scenarioName) {
        this.qualityType = qualityType;
        this.mode = mode;
        this.scenarioName = scenarioName;
        this.dimensions = new ArrayList<>();
    }

    public String getQualityType() {
        return qualityType;
    }

    public String getMode() {
        return mode;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public void addDimension(Dimension dimension) {
        dimensions.add(dimension);
    }
}