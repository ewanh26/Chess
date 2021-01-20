package chess;

import java.awt.*;

public abstract class ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public ChessPiece(String pos, PieceType type, Color color) {
        this.pos = pos;
        this.type = type;
        this.color = color;
    }

}
