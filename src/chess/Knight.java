package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Knight extends ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public Knight(int row, int col, PieceType type, Color color) {
        super(row, col, type, color);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("src\\Images\\KnightBlack.png"));
            } else {
                img = ImageIO.read(new File("src\\Images\\KnightWhite.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
