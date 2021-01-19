package chess;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Chess extends JFrame {

    private JLabel[] boardLabels;
    private int gridW = 8;
    private int gridH = 8;
    private int squareSize = 64;

    private Color hoverColor = Color.decode("#DDCCFF");
    private Color beforeHoverColor;
    private Color borderColor = Color.BLACK;

    public Chess(String title) {
        super(title);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Chess("Chess").startApp(args);
            }
        });
    }

    private void startApp(String[] args) {
        initialize();
        addPiece(new Pawn("G2", PieceType.Pawn, Color.BLACK), "G2");
    }

    private void initialize() {
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(gridH, gridW));
        boardLabels = new JLabel[gridW * gridH];
        MouseHandler mouseHandler = new MouseHandler();

        int labelASCII_StartLetter = 65;
        boolean checker = false;
        Color squareColor;
        int columnCounter = 0;

        for (int i = 0; i < boardLabels.length; i++) {
            if (i%2==0) {
                squareColor = !checker ? Color.WHITE : Color.RED.darker();
            } else {
                squareColor = !checker ? Color.RED.darker() : Color.WHITE;
            }

            columnCounter++;
            boardLabels[i] = new JLabel();
            boardLabels[i].setName(Character.toString((char)labelASCII_StartLetter) + String.valueOf(columnCounter));
            boardLabels[i].setOpaque(true);
            boardLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            boardLabels[i].setBackground(squareColor);
            boardLabels[i].setPreferredSize(new Dimension(squareSize, squareSize));
            boardLabels[i].addMouseListener(mouseHandler);
            getContentPane().add(boardLabels[i]);
            if (columnCounter == gridW) {
                checker = !checker;
                labelASCII_StartLetter++;
                columnCounter = 0;
            }
        }

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void addPiece(ChessPiece piece, String pos) {
        for (JLabel square : boardLabels) {
            if (square.getName().equals(pos)) {
                if (piece.type == PieceType.Pawn) {
                    Pawn pawn = (Pawn) piece;
                    ImageIcon icon = new ImageIcon(pawn.img);
                    square.setIcon(icon);
                }
            }
        }
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            System.out.println("Clicked: " + label.getName());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            beforeHoverColor = label.getBackground();
            label.setBorder(BorderFactory.createLineBorder(borderColor, 3));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            label.setBorder(BorderFactory.createLineBorder(borderColor));
        }
    }

}