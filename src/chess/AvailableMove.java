package chess;

import java.awt.*;

public class AvailableMove extends ChessPiece {
    PieceType type;
    PieceType self;
    public AvailableMove(PieceType self, PieceType type){super(type, self);};
}
