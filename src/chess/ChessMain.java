package chess;

import java.awt.*;

public class ChessMain {

    public static void main(String[] args) {
        Board board = new Board(512, 512, "Chess");
        boolean running = true;

        game_loop : while (running) {
            board.update();
        }

    }

}
