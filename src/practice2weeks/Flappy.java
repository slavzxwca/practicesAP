package practice2weeks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Flappy extends JFrame {

    enum State { MENU, PLAYING, PAUSED }
    State gameState = State.MENU;

    // Игровые параметры (используем double для плавности)
    double birdY = 300;
    double birdVelocity = -20;

    int[] obstacle = {600, 300};
    int obstacleSpeed = 6;
    int gap = 190;

    int backgroundX = 0;
    int backgroundSpeed = 2;

    int score = 0;
    int highScore = 0;
    boolean passed = false;

    // Картинки
    Image jumpImg = new ImageIcon(Flappy.class.getResource("jump.png")).getImage();
    Image jumpSmoothlyImg = new ImageIcon(Flappy.class.getResource("jumpsmoothly.png")).getImage();
    Image downImg = new ImageIcon(Flappy.class.getResource("down.png")).getImage();
    Image backgroundImg = new ImageIcon(Flappy.class.getResource("background.png")).getImage();
    Image pipeImg = new ImageIcon(Flappy.class.getResource("pipe.png")).getImage();

    Image currentBirdImg = jumpSmoothlyImg;

    public Flappy() {
        setTitle("Flappy Bird Deluxe");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                // Фон
                g.drawImage(backgroundImg, backgroundX, 0, 600, 600, null);
                g.drawImage(backgroundImg, backgroundX + 600, 0, 600, 600, null);

                if (gameState == State.MENU) {
                    drawMenu(g);
                } else {
                    drawGame(g, g2);
                }
            }

            private void drawMenu(Graphics g) {
                // СИЛЬНОЕ ЗАТЕМНЕНИЕ (как в паузе)
                g.setColor(new Color(0, 0, 0, 180));
                g.fillRect(0, 0, 600, 600);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("FLAPPY BIRD", 140, 150);

                g.setFont(new Font("Arial", Font.ITALIC, 20));
                g.drawString("BEST SCORE: " + highScore, 230, 190);

                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawRect(200, 240, 200, 50);
                g.drawString("ИГРАТЬ", 250, 275);

                g.drawRect(200, 320, 200, 50);
                g.drawString("ВЫХОД", 255, 355);
            }

            private void drawGame(Graphics g, Graphics2D g2) {
                // Отрисовка птицы (угол теперь зависит от birdVelocity)
                double angle = Math.min(Math.max(birdVelocity * 4, -45), 45);
                g2.rotate(Math.toRadians(angle), 45, (int)birdY + 15);
                g2.drawImage(currentBirdImg, 30, (int)birdY, 34, 24, null);
                g2.rotate(-Math.toRadians(angle), 45, (int)birdY + 15);

                // Трубы
                g.drawImage(pipeImg, obstacle[0], obstacle[1] - gap - 500, 60, 500, null);
                g.drawImage(pipeImg, obstacle[0], obstacle[1], 60, 600, null);

                // Счет
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                g.drawString("" + score, 280, 50);

                if (gameState == State.PAUSED) {
                    g.setColor(new Color(0, 0, 0, 150));
                    g.fillRect(0, 0, 600, 600);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Arial", Font.BOLD, 40));
                    g.drawString("ПАУЗА", 230, 220);
                    g.setFont(new Font("Arial", Font.PLAIN, 18));
                    g.drawString("P - Продолжить | M - Меню | ESC - Выход", 130, 280);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (gameState == State.MENU) {
                    int mx = e.getX(), my = e.getY();
                    if (mx >= 200 && mx <= 400 && my >= 240 && my <= 290) startGame();
                    if (mx >= 200 && mx <= 400 && my >= 320 && my <= 370) System.exit(0);
                } else if (gameState == State.PLAYING) {
                    birdVelocity = -7.5; // СДЕЛАЛ ПРЫЖОК ПЛАВНЕЕ (был -11)
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (gameState == State.MENU) startGame();
                    else if (gameState == State.PLAYING) birdVelocity = -7.5;
                }
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    if (gameState == State.PLAYING) gameState = State.PAUSED;
                    else if (gameState == State.PAUSED) gameState = State.PLAYING;
                }
                if (e.getKeyCode() == KeyEvent.VK_M && gameState == State.PAUSED) gameState = State.MENU;
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
            }
        });

        add(panel);
        setVisible(true);

        new Timer(1000 / 60, e -> {
            if (gameState != State.PAUSED) {
                backgroundX -= backgroundSpeed;
                if (backgroundX <= -600) backgroundX = 0;
            }

            if (gameState == State.PLAYING) {
                // ПЛАВНОЕ ПАДЕНИЕ
                birdY += birdVelocity;
                birdVelocity += 0.4; // ГРАВИТАЦИЯ СТАЛА МЕДЛЕННЕЕ (была 1.0)

                // Анимация спрайтов
                if (birdVelocity < -2) currentBirdImg = jumpImg;
                else if (birdVelocity > 2) currentBirdImg = downImg;
                else currentBirdImg = jumpSmoothlyImg;

                obstacle[0] -= obstacleSpeed;

                if (!passed && obstacle[0] + 60 <= 30) {
                    score++;
                    passed = true;
                    if (score > highScore) highScore = score;
                }

                // Столкновения (используем (int)birdY)
                if (birdY < 0 || birdY > 570 ||
                        (obstacle[0] < 60 && obstacle[0] + 60 > 30 &&
                                (birdY < obstacle[1] - gap || birdY > obstacle[1] - 30))) {
                    gameState = State.MENU;
                }

                if (obstacle[0] < -60) {
                    obstacle[0] = 600;
                    obstacle[1] = (int) (Math.random() * (500 - gap)) + gap;
                    passed = false;
                }
            }
            panel.repaint();
        }).start();
    }

    private void startGame() {
        birdY = 300;
        birdVelocity = -7;
        obstacle[0] = 600;
        score = 0;
        passed = false;
        currentBirdImg = jumpSmoothlyImg;
        gameState = State.PLAYING;
    }

    public static void main(String[] args) {
        new Flappy();
    }
}