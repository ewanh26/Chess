package chess;

import java.awt.*;

public abstract class ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected PieceHandler pieceHandler;
    protected Image img;

    public ChessPiece(String pos, PieceType type, Color color, PieceHandler pieceHandler) {
        this.pos = pos;
        this.type = type;
        this.color = color;
        this.pieceHandler = pieceHandler;
    }

}
