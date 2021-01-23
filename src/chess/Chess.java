package chess;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.*;

public class Chess extends JFrame {

    private JLabel[] boardLabels;
    private int gridW = 8;
    private int gridH = 8;
    private int squareSize = 64;

    private Color hoverColor = Color.decode("#DDCCFF");
    private Color beforeHoverColor;
    private Color borderColor = Color.BLACK;

    public ArrayList<ChessPiece> pieceArrayList = new ArrayList<>();
    public ChessPiece[][] boardArray2D = new ChessPiece[8][8];

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

        for (int i = 0; i < 8; i++) {
            addPiece(new Pawn(6, i, PieceType.Pawn, Color.WHITE));
            addPiece(new Pawn(1, i, PieceType.Pawn, Color.BLACK));
            switch (i) {
                case 0, 7 -> {
                    addPiece(new Rook(7, i, PieceType.Rook, Color.WHITE));
                    addPiece(new Rook(0, i, PieceType.Rook, Color.BLACK));
                }
                case 1, 6 -> {
                    addPiece(new Knight(7, i, PieceType.Knight, Color.WHITE));
                    addPiece(new Knight(0, i, PieceType.Knight, Color.BLACK));
                }
                case 2, 5 -> {
                    addPiece(new Bishop(7, i, PieceType.Bishop, Color.WHITE));
                    addPiece(new Bishop(0, i, PieceType.Bishop, Color.BLACK));
                }
                case 3 -> {
                    addPiece(new Queen(7, i, PieceType.Queen, Color.WHITE));
                    addPiece(new Queen(0, i, PieceType.Queen, Color.BLACK));
                }
                case 4 -> {
                    addPiece(new King(7, i, PieceType.King, Color.WHITE));
                    addPiece(new King(0, i, PieceType.King, Color.BLACK));
                }
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

        int start = 0;
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
            boardLabels[i].setName(Integer.toString(start) + String.valueOf(columnCounter-1));
            boardLabels[i].setOpaque(true);
            boardLabels[i].setBorder(BorderFactory.createLineBorder(borderColor));
            boardLabels[i].setBackground(squareColor);
            boardLabels[i].setPreferredSize(new Dimension(squareSize, squareSize));
            boardLabels[i].addMouseListener(mouseHandler);
            getContentPane().add(boardLabels[i]);
            if (columnCounter == gridW) {
                checker = !checker;
                start++;
                columnCounter = 0;
            }
        }

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void addPiece(ChessPiece piece) {
        boardArray2D[piece.row][piece.col] = piece;
        pieceArrayList.add(piece);
        for (JLabel square : boardLabels) {
            if (square.getName().equals(Integer.toString(piece.row)+Integer.toString(piece.col))) {
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
                    case Bishop -> {
                        Bishop p = (Bishop) piece;
                        ImageIcon icon = new ImageIcon(p.img);
                        square.setIcon(icon);
                    }
                    case Queen -> {
                        Queen p = (Queen) piece;
                        ImageIcon icon = new ImageIcon(p.img);
                        square.setIcon(icon);
                    }
                    case King -> {
                        King p = (King) piece;
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
            System.out.println(label.getName());
            //System.out.println(label.getIcon());
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
