package chess;

import java.awt.*;

public abstract class ChessPiece {

    protected int row, col;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public ChessPiece(int row, int col,PieceType type, Color color) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.color = color;
    }

    protected ChessPiece(){};

}
