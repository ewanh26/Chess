package chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Pawn extends ChessPiece {

    protected int x,y;
    protected PieceType type;
    protected Image img = null;
    protected ImageObserver imageObserver;

    public Pawn(int x, int y, PieceType type) {
        super(x, y, type);
    }

    public void draw(Graphics g) {
        try {
            img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\Pawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(img, x, y, imageObserver);
    }
}
