package chess;

import java.awt.*;
import java.util.ArrayList;

@Utility
public class PossibleMoves {

    public static void getMoves(PieceType type, Color color, int row, int col, ChessPiece[][] array2D) {
        int direction = color == Color.WHITE ? -1 : 1;
        ChessPiece[][] newArray2D = new ChessPiece[8][8];
        newArray2D = array2D;

        switch (type) {
            case Pawn -> {
                newArray2D[row + direction][col] = new AvailableMove(PieceType.AvailableMove, PieceType.Pawn);
                if (row == 1 || row == 6) {
                    newArray2D[row + direction*2][col] = new AvailableMove(PieceType.AvailableMove, PieceType.Pawn);
                }
            }
        }
    }

}
