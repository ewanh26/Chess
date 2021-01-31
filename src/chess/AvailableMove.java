package chess;

import java.awt.*;

public class AvailableMove extends ChessPiece {
    PieceType type;
    PieceType self;
    public AvailableMove(PieceType type, PieceType self){super(type, self);};
}
