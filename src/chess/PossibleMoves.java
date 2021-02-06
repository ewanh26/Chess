package chess;

import chess.AvailableMove;
import chess.ChessPiece;
import chess.PieceType;
import chess.Utility;

import java.awt.*;

@Utility
public class PossibleMoves {

    public static void getMoves(PieceType type, Color color, int row, int col, ChessPiece[][] array2D) {
        int direction = color == Color.WHITE ? -1 : 1;
        ChessPiece[][] newArray2D = new ChessPiece[8][8];
        newArray2D = array2D;

        if (type != null) {
            switch (type) {
                case Pawn -> {
                    newArray2D[row + direction][col] = new AvailableMove();
                    //Chess.addPiece(new AvailableMove(row + direction, col));
                    if (row == 1 || row == 6) {
                        newArray2D[row + direction * 2][col] = new AvailableMove();
                        //Chess.addPiece(new AvailableMove(row + direction * 2, col));
                    }
                }
            }
        }
    }

    public static void clearMoves(ChessPiece[][] array2D) {
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D.length; j++) {
                array2D[i][j] = array2D[i][j] instanceof AvailableMove ? null : array2D[i][j];
            }
        }
    }

}