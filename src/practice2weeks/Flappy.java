package practice2weeks;
import javax.swing.*;
import java.awt.*;

public class Flappy extends JFrame {

    int[] bird = {300, -20};        // y, velocity
    int[] obstacle = {600, 300};    // x, holeY

    public Flappy() {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // птица
                g.fillOval(30, bird[0], 30, 30);

                // препятствия
                g.fillRect(obstacle[0], 0, 60, obstacle[1] - 200);
                g.fillRect(obstacle[0], obstacle[1], 60, 600);
            }
        };

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                bird[1] = -10;
            }
        });

        add(panel);
        setVisible(true);

        new Timer(1000 / 60, e -> {
            bird[0] += bird[1];
            bird[1]++; // гравитация

            obstacle[0] -= 5;
            if (obstacle[0] < -60) {
                obstacle[0] = 600;
                obstacle[1] = (int)(Math.random() * 300) + 250;
            }

            // столкновение
            if (bird[0] < 0 || bird[0] > 570 ||
                    (obstacle[0] < 60 && obstacle[0] > 0 &&
                            (bird[0] < obstacle[1] - 200 || bird[0] > obstacle[1]))) {
                System.exit(0);
            }

            panel.repaint();
        }).start();
    }

    public static void main(String[] args) {
        new Flappy();
    }
}

