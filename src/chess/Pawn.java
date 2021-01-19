package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Pawn extends ChessPiece {

    protected String pos;
    protected PieceType type;
    protected Image img = null;
    protected ImageObserver imageObserver;

    public Pawn(String pos, PieceType type) {
        super(pos, type);

        try {
            img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\Pawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
