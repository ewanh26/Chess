package chess;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PieceHandler {

    public ArrayList<ChessPiece> white_pieces, black_pieces;

    public void addPiece(ArrayList<ChessPiece> colour, ChessPiece piece) {
        colour.add(piece);
    }

    public void removePiece(ArrayList<ChessPiece> colour, ChessPiece piece) {
        colour.remove(piece);
    }

}
