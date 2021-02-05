package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class King extends ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public King(int row, int col, PieceType type, Color color) {
        super(row, col, type, color);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("src\\Images\\KingBlack.png"));
            } else {
                img = ImageIO.read(new File("src\\Images\\KingWhite.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
