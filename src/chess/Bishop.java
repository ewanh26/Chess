package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bishop extends ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public Bishop(int row, int col, PieceType type, Color color) {
        super(row, col, type, color);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\BishopBlack.png"));
            } else {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\BishopWhite.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] possibleMoves() {
        char[] splitPos = { pos.charAt(0), pos.charAt(1) };
        String[] possibleMoves;

        return null;
    }
}
