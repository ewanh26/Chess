package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Knight extends ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public Knight(String pos, PieceType type, Color color) {
        super(pos, type, color);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\KnightBlack.png"));
            } else {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\KnightWhite.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String[] possibleMoves() {
        return new String[0];
    }

}
