package chess;

import java.awt.*;

public abstract class ChessPiece {

    protected int x, y;
    protected PieceType type;

    public ChessPiece(int x, int y, PieceType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    abstract void draw(Graphics g);

}
