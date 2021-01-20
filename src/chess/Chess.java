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

    private PieceHandler handler;

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

        for (int i = 1; i <= 8; i++) {
            addPiece(new Pawn("G" + Integer.toString(i), PieceType.Pawn, Color.WHITE, handler), "G" + Integer.toString(i));
            addPiece(new Pawn("B" + Integer.toString(i), PieceType.Pawn, Color.BLACK, handler), "B" + Integer.toString(i));
            if (i == 1 || i == 8) {
                addPiece(new Rook("H" + Integer.toString(i), PieceType.Rook, Color.WHITE, handler), "H" + Integer.toString(i));
                addPiece(new Rook("A" + Integer.toString(i), PieceType.Rook, Color.BLACK, handler), "A" + Integer.toString(i));
            }
            if (i == 2 || i == 7) {
                addPiece(new Knight("H" + Integer.toString(i), PieceType.Knight, Color.WHITE, handler), "H" + Integer.toString(i));
                addPiece(new Knight("A" + Integer.toString(i), PieceType.Knight, Color.BLACK, handler), "A" + Integer.toString(i));
            }
        }
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
                squareColor = !checker ? Color.decode("#e3c16f") : Color.decode("#b88b4a");
            } else {
                squareColor = !checker ? Color.decode("#b88b4a") : Color.decode("#e3c16f");
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
                switch (piece.type) {
                    case Pawn -> {
                        Pawn p = (Pawn) piece;
                        ImageIcon icon = new ImageIcon(p.img);
                        square.setIcon(icon);
                    }
                    case Rook -> {
                        Rook p = (Rook) piece;
                        ImageIcon icon = new ImageIcon(p.img);
                        square.setIcon(icon);
                    }
                    case Knight -> {
                        Knight p = (Knight) piece;
                        ImageIcon icon = new ImageIcon(p.img);
                        square.setIcon(icon);
                    }
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
