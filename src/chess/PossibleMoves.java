package chess;

import java.awt.*;
import java.util.ArrayList;

@Utility
public class PossibleMoves {

    public static ChessPiece[][] getMoves(PieceType type, Color color, int row, int col, ChessPiece[][] array2D) {
        int direction = color == Color.WHITE ? -1 : 1;

        switch (type) {
            case Pawn -> {
                array2D[row + direction][col] = new AvailableMove(PieceType.Pawn);
                if (row == 1 || row == 6) {
                    array2D[row + direction*2][col] = new AvailableMove(PieceType.Pawn);
                }
            }
        }

        return array2D;
    }

}
