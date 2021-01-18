package chess;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Pawn extends ChessPiece {

    protected int x,y;
    protected PieceType type;
    protected Image img = null;
    protected ImageObserver imageObserver;

    public Pawn(int x, int y, PieceType type) {
        super(x, y, type);
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, imageObserver);
    }
}
