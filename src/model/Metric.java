package model;

public class Metric {
    private String name;
    private int coefficient;
    private String direction; // "Higher" or "Lower"
    private double min;
    private double max;
    private String unit;
    private double value;

    public Metric(String name, int coefficient, String direction, double min, double max, String unit, double value) {
        this.name = name;
        this.coefficient = coefficient;
        this.direction = direction;
        this.min = min;
        this.max = max;
        this.unit = unit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public String getDirection() {
        return direction;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public String getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double calculateScore() {
        double rawScore;

        if ("Higher".equals(direction)) {
            rawScore = 1 + ((value - min) / (max - min)) * 4.0;
        } else {
            rawScore = 5 - ((value - min) / (max - min)) * 4.0;
        }

        if (rawScore < 1.0) rawScore = 1.0;
        if (rawScore > 5.0) rawScore = 5.0;

        return Math.round(rawScore * 2.0) / 2.0;
    }

    public String getRangeText() {
        return min + " - " + max;
    }
}