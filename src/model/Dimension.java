package model;

import java.util.ArrayList;
import java.util.List;

public class Dimension {
    private String name;
    private int coefficient;
    private List<Metric> metrics;

    public Dimension(String name, int coefficient) {
        this.name = name;
        this.coefficient = coefficient;
        this.metrics = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void addMetric(Metric metric) {
        metrics.add(metric);
    }

    public double calculateDimensionScore() {
        double total = 0.0;
        int totalCoeff = 0;

        for (Metric metric : metrics) {
            total += metric.calculateScore() * metric.getCoefficient();
            totalCoeff += metric.getCoefficient();
        }

        if (totalCoeff == 0) return 0.0;

        return Math.round((total / totalCoeff) * 100.0) / 100.0;
    }
}