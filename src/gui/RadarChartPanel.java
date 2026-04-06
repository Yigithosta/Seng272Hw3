package gui;

import model.Dimension;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RadarChartPanel extends JPanel {

    private final List<Dimension> dimensions;

    public RadarChartPanel(List<Dimension> dimensions) {
        this.dimensions = dimensions;
        setPreferredSize(new java.awt.Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dimensions == null || dimensions.isEmpty()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int cx = w / 2;
        int cy = h / 2;
        int radius = Math.min(w, h) / 2 - 60;
        int n = dimensions.size();

        for (int level = 1; level <= 5; level++) {
            Polygon grid = new Polygon();
            double r = radius * (level / 5.0);
            for (int i = 0; i < n; i++) {
                double angle = -Math.PI / 2 + (2 * Math.PI * i / n);
                int x = (int) (cx + r * Math.cos(angle));
                int y = (int) (cy + r * Math.sin(angle));
                grid.addPoint(x, y);
            }
            g2.setColor(new Color(230, 230, 230));
            g2.drawPolygon(grid);
        }

        for (int i = 0; i < n; i++) {
            double angle = -Math.PI / 2 + (2 * Math.PI * i / n);
            int x = (int) (cx + radius * Math.cos(angle));
            int y = (int) (cy + radius * Math.sin(angle));

            g2.setColor(new Color(200, 200, 200));
            g2.drawLine(cx, cy, x, y);

            String label = dimensions.get(i).getName();
            FontMetrics fm = g2.getFontMetrics();
            int labelDistance = radius + 15;
            int lx = (int) (cx + labelDistance * Math.cos(angle));
            int ly = (int) (cy + labelDistance * Math.sin(angle));

            int textX = lx - (fm.stringWidth(label) / 2);
            int textY = ly + (fm.getAscent() / 4);

            g2.setColor(Color.DARK_GRAY);
            g2.setFont(new Font("SansSerif", Font.BOLD, 11));
            g2.drawString(label, textX, textY);
        }

        Polygon data = new Polygon();
        for (int i = 0; i < n; i++) {
            double score = dimensions.get(i).calculateDimensionScore();
            double scaled = (Math.min(score, 5.0) / 5.0) * radius;
            double angle = -Math.PI / 2 + (2 * Math.PI * i / n);

            int x = (int) (cx + scaled * Math.cos(angle));
            int y = (int) (cy + scaled * Math.sin(angle));
            data.addPoint(x, y);
        }

        g2.setColor(new Color(91, 155, 213, 120));
        g2.fillPolygon(data);
        g2.setColor(new Color(47, 85, 151));
        g2.setStroke(new BasicStroke(2f));
        g2.drawPolygon(data);
    }
}