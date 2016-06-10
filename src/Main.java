import components.Board;

import java.util.Objects;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.preparePlayers();
        Random generator = new Random();
        while (board.hasPlayerWon()==0) {
            board.printBoard();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            board.mark(generator.nextInt(20), generator.nextInt(20), board.getActivePlayer().getNumber());
            board.switchActivePlayer();
        }


    }
}
