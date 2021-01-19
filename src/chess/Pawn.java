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
    protected Image img = null;
    protected ImageObserver imageObserver;

    public Pawn(String pos, PieceType type, Color color) {
        super(pos, type, color);

        try {
            if (color == Color.BLACK)
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\PawnBlack.png"));
            else
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\PawnWhite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
