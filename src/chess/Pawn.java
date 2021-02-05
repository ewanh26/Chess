package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Pawn extends ChessPiece {

    protected int x, y;
    protected PieceType type;
    protected Color color;
    protected Image img;

    public Pawn(int row, int col, PieceType type, Color color) {
        super(row, col, type, color);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("src\\Images\\PawnBlack.png"));
            } else {
                img = ImageIO.read(new File("src\\Images\\PawnWhite.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
