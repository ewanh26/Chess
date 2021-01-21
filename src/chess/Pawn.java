package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Pawn extends ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public Pawn(String pos, PieceType type, Color color) {
        super(pos, type, color);

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

    public String[] possibleMoves() {
        char[] splitPos = { pos.charAt(0), pos.charAt(1) };
        String[] possibleMoves;

        if (color == Color.BLACK) {
            int ASCII_CharPos = (int) splitPos[0];
            possibleMoves = new String[]{ Character.toString((char) ASCII_CharPos + 1) + splitPos[1] };
        } else {
            int ASCII_CharPos = (int) splitPos[0];
            possibleMoves = new String[]{ Character.toString((char) ASCII_CharPos - 1) + splitPos[1] };
        }

        return possibleMoves;
    }

}
