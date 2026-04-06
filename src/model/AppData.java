package model;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    public static List<String> getModes() {
        List<String> modes = new ArrayList<>();
        modes.add("Health");
        modes.add("Education");
        return modes;
    }

    public static List<String> getScenarioNamesByMode(String mode) {
        List<String> names = new ArrayList<>();

        if ("Health".equals(mode)) {
            names.add("Scenario A - City Hospital");
            names.add("Scenario B - Family Clinic");
        } else if ("Education".equals(mode)) {
            names.add("Scenario C - Team Alpha");
            names.add("Scenario D - Team Beta");
        }

        return names;
    }

    public static Scenario createScenario(String qualityType, String mode, String scenarioName) {
        if ("Education".equals(mode) && "Scenario C - Team Alpha".equals(scenarioName)) {
            return createEducationScenarioC(qualityType);
        }
        if ("Education".equals(mode) && "Scenario D - Team Beta".equals(scenarioName)) {
            return createEducationScenarioD(qualityType);
        }
        if ("Health".equals(mode) && "Scenario A - City Hospital".equals(scenarioName)) {
            return createHealthScenarioA(qualityType);
        }
        return createHealthScenarioB(qualityType);
    }

    private static Scenario createEducationScenarioC(String qualityType) {
        Scenario scenario = new Scenario(qualityType, "Education", "Scenario C - Team Alpha");

        Dimension usability = new Dimension("Usability", 25);
        usability.addMetric(new Metric("SUS Score", 50, "Higher", 0, 100, "points", 89));
        usability.addMetric(new Metric("Onboarding Time", 50, "Lower", 0, 60, "min", 5));

        Dimension performance = new Dimension("Performance Efficiency", 20);
        performance.addMetric(new Metric("Video Start Time", 50, "Lower", 0, 15, "sec", 3));
        performance.addMetric(new Metric("Concurrent Exams", 50, "Higher", 0, 600, "users", 520));

        Dimension accessibility = new Dimension("Accessibility", 20);
        accessibility.addMetric(new Metric("WCAG Compliance", 50, "Higher", 0, 100, "%", 92));
        accessibility.addMetric(new Metric("Screen Reader Score", 50, "Higher", 0, 100, "%", 85));

        Dimension reliability = new Dimension("Reliability", 20);
        reliability.addMetric(new Metric("Uptime", 50, "Higher", 95, 100, "%", 97.4));
        reliability.addMetric(new Metric("MTTR", 50, "Lower", 0, 120, "min", 42));

        Dimension functional = new Dimension("Functional Suitability", 15);
        functional.addMetric(new Metric("Feature Completion", 50, "Higher", 0, 100, "%", 88));
        functional.addMetric(new Metric("Assignment Submit Rate", 50, "Higher", 0, 100, "%", 91));

        scenario.addDimension(usability);
        scenario.addDimension(performance);
        scenario.addDimension(accessibility);
        scenario.addDimension(reliability);
        scenario.addDimension(functional);

        return scenario;
    }

    private static Scenario createEducationScenarioD(String qualityType) {
        Scenario scenario = new Scenario(qualityType, "Education", "Scenario D - Team Beta");

        Dimension usability = new Dimension("Usability", 25);
        usability.addMetric(new Metric("SUS Score", 50, "Higher", 0, 100, "points", 76));
        usability.addMetric(new Metric("Onboarding Time", 50, "Lower", 0, 60, "min", 14));

        Dimension performance = new Dimension("Performance Efficiency", 20);
        performance.addMetric(new Metric("Video Start Time", 50, "Lower", 0, 15, "sec", 6));
        performance.addMetric(new Metric("Concurrent Exams", 50, "Higher", 0, 600, "users", 380));

        Dimension accessibility = new Dimension("Accessibility", 20);
        accessibility.addMetric(new Metric("WCAG Compliance", 50, "Higher", 0, 100, "%", 81));
        accessibility.addMetric(new Metric("Screen Reader Score", 50, "Higher", 0, 100, "%", 79));

        Dimension reliability = new Dimension("Reliability", 20);
        reliability.addMetric(new Metric("Uptime", 50, "Higher", 95, 100, "%", 96.2));
        reliability.addMetric(new Metric("MTTR", 50, "Lower", 0, 120, "min", 58));

        Dimension functional = new Dimension("Functional Suitability", 15);
        functional.addMetric(new Metric("Feature Completion", 50, "Higher", 0, 100, "%", 82));
        functional.addMetric(new Metric("Assignment Submit Rate", 50, "Higher", 0, 100, "%", 84));

        scenario.addDimension(usability);
        scenario.addDimension(performance);
        scenario.addDimension(accessibility);
        scenario.addDimension(reliability);
        scenario.addDimension(functional);

        return scenario;
    }

    private static Scenario createHealthScenarioA(String qualityType) {
        Scenario scenario = new Scenario(qualityType, "Health", "Scenario A - City Hospital");

        Dimension usability = new Dimension("Usability", 25);
        usability.addMetric(new Metric("Task Completion Rate", 50, "Higher", 0, 100, "%", 87));
        usability.addMetric(new Metric("Average Registration Time", 50, "Lower", 0, 30, "min", 8));

        Dimension performance = new Dimension("Performance Efficiency", 20);
        performance.addMetric(new Metric("Record Retrieval Time", 50, "Lower", 0, 10, "sec", 2));
        performance.addMetric(new Metric("Concurrent Users", 50, "Higher", 0, 1000, "users", 740));

        Dimension accessibility = new Dimension("Accessibility", 20);
        accessibility.addMetric(new Metric("Accessibility Compliance", 50, "Higher", 0, 100, "%", 78));
        accessibility.addMetric(new Metric("Mobile Access Score", 50, "Higher", 0, 100, "%", 83));

        Dimension reliability = new Dimension("Reliability", 20);
        reliability.addMetric(new Metric("System Availability", 50, "Higher", 95, 100, "%", 98.3));
        reliability.addMetric(new Metric("Incident Recovery Time", 50, "Lower", 0, 120, "min", 35));

        Dimension functional = new Dimension("Functional Suitability", 15);
        functional.addMetric(new Metric("Prescription Accuracy", 50, "Higher", 0, 100, "%", 94));
        functional.addMetric(new Metric("Appointment Success Rate", 50, "Higher", 0, 100, "%", 90));

        scenario.addDimension(usability);
        scenario.addDimension(performance);
        scenario.addDimension(accessibility);
        scenario.addDimension(reliability);
        scenario.addDimension(functional);

        return scenario;
    }

    private static Scenario createHealthScenarioB(String qualityType) {
        Scenario scenario = new Scenario(qualityType, "Health", "Scenario B - Family Clinic");

        Dimension usability = new Dimension("Usability", 25);
        usability.addMetric(new Metric("Task Completion Rate", 50, "Higher", 0, 100, "%", 79));
        usability.addMetric(new Metric("Average Registration Time", 50, "Lower", 0, 30, "min", 12));

        Dimension performance = new Dimension("Performance Efficiency", 20);
        performance.addMetric(new Metric("Record Retrieval Time", 50, "Lower", 0, 10, "sec", 4));
        performance.addMetric(new Metric("Concurrent Users", 50, "Higher", 0, 1000, "users", 430));

        Dimension accessibility = new Dimension("Accessibility", 20);
        accessibility.addMetric(new Metric("Accessibility Compliance", 50, "Higher", 0, 100, "%", 72));
        accessibility.addMetric(new Metric("Mobile Access Score", 50, "Higher", 0, 100, "%", 76));

        Dimension reliability = new Dimension("Reliability", 20);
        reliability.addMetric(new Metric("System Availability", 50, "Higher", 95, 100, "%", 96.8));
        reliability.addMetric(new Metric("Incident Recovery Time", 50, "Lower", 0, 120, "min", 55));

        Dimension functional = new Dimension("Functional Suitability", 15);
        functional.addMetric(new Metric("Prescription Accuracy", 50, "Higher", 0, 100, "%", 88));
        functional.addMetric(new Metric("Appointment Success Rate", 50, "Higher", 0, 100, "%", 84));

        scenario.addDimension(usability);
        scenario.addDimension(performance);
        scenario.addDimension(accessibility);
        scenario.addDimension(reliability);
        scenario.addDimension(functional);

        return scenario;
    }
}