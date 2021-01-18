package chess;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class Board extends JFrame {

    public static int WIDTH;
    public static int HEIGHT;

    public Board(int WIDTH, int HEIGHT, String TITLE) {
        super(TITLE);

        Board.WIDTH = WIDTH;
        Board.HEIGHT = HEIGHT;

        setBackground(Color.black);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        contentPane.setBackground(Color.ORANGE.darker().darker().darker().darker());
        contentPane.add(new Checker());
        pack();
        setVisible(true);
    }

    public void update() {
        repaint();
    }

    static class Checker extends JPanel {

        private final Dimension preferredSize = new Dimension(Board.WIDTH, Board.HEIGHT);

        private void drawChessSquare(int w, int h, int x, int y, Graphics g, Color color) {
            g.setColor(color);
            g.fillRect(x, y, w, h);
        }

        @Override
        public Dimension getPreferredSize() {
            return preferredSize;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            boolean black = true;
            for (int i = 0; i < 64; i++) {
                int x = 0;
                int y = 0;

                if (i < 8) {
                    assert true;
                } else if (i < 8 * 2) {
                    y = Board.HEIGHT / 8;
                } else if (i < 8 * 3) {
                    y = (Board.HEIGHT / 8) * 2;
                } else if (i < 8 * 4) {
                    y = (Board.HEIGHT / 8) * 3;
                } else if (i < 8 * 5) {
                    y = (Board.HEIGHT / 8) * 4;
                } else if (i < 8 * 6) {
                    y = (Board.HEIGHT / 8) * 5;
                } else if (i < 8 * 7) {
                    y = (Board.HEIGHT / 8) * 6;
                } else {
                    y = (Board.HEIGHT / 8) * 7;
                }

                if (i % 8 == 0) {
                    assert true;
                } else if (i == 1 || (i - 1) % 8 == 0) {
                    x = Board.WIDTH / 8;
                } else if (i == 2 || (i - 2) % 8 == 0) {
                    x = (Board.WIDTH / 8) * 2;
                } else if (i == 3 || (i - 3) % 8 == 0) {
                    x = (Board.WIDTH / 8) * 3;
                } else if (i == 4 || (i - 4) % 8 == 0) {
                    x = (Board.WIDTH / 8) * 4;
                } else if (i == 5 || (i - 5) % 8 == 0) {
                    x = (Board.WIDTH / 8) * 5;
                } else if (i == 6 || (i - 6) % 8 == 0) {
                    x = (Board.WIDTH / 8) * 6;
                } else if (i == 7 || (i - 7) % 8 == 0) {
                    x = (Board.WIDTH / 8) * 7;
                }

                if (black) {
                    if (!((i-7) % 8 == 0)) black = !black;
                    drawChessSquare(Board.WIDTH / 8, Board.HEIGHT / 8, x, y, g, Color.black);
                } else {
                    if (!((i-7) % 8 == 0)) black = !black;
                    drawChessSquare(Board.WIDTH / 8, Board.HEIGHT / 8, x, y, g, Color.orange);
                }
            }
        }

    }
}
