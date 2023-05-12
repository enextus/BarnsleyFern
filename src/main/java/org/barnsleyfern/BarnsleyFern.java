package org.barnsleyfern;

import javax.swing.*;
import java.awt.*;

public class BarnsleyFern {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Barnsley Fern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new FernCanvas());
        frame.setVisible(true);
    }

    static class FernCanvas extends JComponent {
        private static final int WIDTH = 700;
        private static final int HEIGHT = 700;
        private static final int NUM_POINTS = 50000;
        double x, y;

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, WIDTH, HEIGHT);

            g2.setColor(Color.GREEN);
            for (int i = 0; i < NUM_POINTS; i++) {
                drawPoint(g2);
                nextPoint();
            }
        }

        private void drawPoint(Graphics2D g2) {
            int screenX = (int) ((x + 2.5) * WIDTH / 5);
            int screenY = HEIGHT - (int) (y * HEIGHT / 10);
            g2.drawLine(screenX, screenY, screenX, screenY);
        }

        double[] applyStem(double x, double y) {
            return new double[]{0, 0.16 * y};
        }

        double[] applySuccessiveLeaf(double x, double y) {
            return new double[]{0.85 * x + 0.04 * y, -0.04 * x + 0.85 * y + 1.6};
        }

        double[] applyLeftLeaf(double x, double y) {
            return new double[]{0.2 * x - 0.26 * y, 0.23 * x + 0.22 * y + 1.6};
        }

        double[] applyRightLeaf(double x, double y) {
            return new double[]{-0.15 * x + 0.28 * y, 0.26 * x + 0.24 * y + 0.44};
        }

        private void nextPoint() {
            double nextX, nextY;
            double rnd = Math.random();

            if (rnd < 0.01) {
                double[] point = applyStem(x, y);
                nextX = point[0];
                nextY = point[1];
            } else if (rnd < 0.86) {
                double[] point = applySuccessiveLeaf(x, y);
                nextX = point[0];
                nextY = point[1];
            } else if (rnd < 0.93) {
                double[] point = applyLeftLeaf(x, y);
                nextX = point[0];
                nextY = point[1];
            } else {
                double[] point = applyRightLeaf(x, y);
                nextX = point[0];
                nextY = point[1];
            }

            x = nextX;
            y = nextY;
        }

    }

}
