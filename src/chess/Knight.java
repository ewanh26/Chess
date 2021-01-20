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
    protected PieceHandler pieceHandler;
    protected Image img = null;
    protected ImageObserver imageObserver;

    public Knight(String pos, PieceType type, Color color, PieceHandler pieceHandler) {
        super(pos, type, color, pieceHandler);

        try {
            if (color == Color.BLACK) {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\KnightBlack.png"));
                pieceHandler.addPiece(pieceHandler.black_pieces, this);
            } else {
                img = ImageIO.read(new File("C:\\Users\\user\\Documents\\Chess\\src\\Images\\KnightWhite.png"));
                pieceHandler.addPiece(pieceHandler.white_pieces, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
