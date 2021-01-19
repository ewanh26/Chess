package chess;

import java.awt.*;

public abstract class ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Image img;

    public ChessPiece(String pos, PieceType type) {
        this.pos = pos;
        this.type = type;
    }

}
