package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pawn extends ChessPiece {

    protected int x, y;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public Pawn(int row, int col, PieceType type, Color color) {
        super(row, col, type, color);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\PawnBlack.png"));
            } else {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\PawnWhite.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public ArrayList<String> possibleMoves() {
        char[] splitPos = { pos.charAt(0), pos.charAt(1) };
        String[] possibleMoves;
        int direction;

        if (color == Color.BLACK) {
            direction = 1;
        } else {
            direction = -1;
        }

        int ASCII_CharPos = (int) splitPos[0];
        possibleMoves = new String[]{ Character.toString((char) ASCII_CharPos + direction) + splitPos[1] };

        if (splitPos[0] == 'B' || splitPos[0] == 'G') {
            possibleMoves.
        }

        return possibleMoves;
    }*/

}
