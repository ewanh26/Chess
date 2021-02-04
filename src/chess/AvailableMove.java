package chess;

import java.awt.*;

public class AvailableMove extends ChessPiece {
    PieceType type;
    public AvailableMove() {
        super();
        type = PieceType.AvailableMove;
    }
}
