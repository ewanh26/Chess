package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Queen extends ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public Queen(String pos, PieceType type, Color color) {
        super(pos, type, color);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\QueenBlack.png"));
            } else {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\QueenWhite.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String[] possibleMoves() {
        return new String[0];
    }

}
