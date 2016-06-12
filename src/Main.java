import components.AI;
import components.Board;

import java.util.Objects;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.preparePlayers();
        Random generator = new Random();

        AI robot = new AI(Board.getBoard() , 1);

        board.mark(19,15,1);
        board.mark(18,16,1);
        board.mark(17,17,1);
//        board.mark(16,18,1);
        board.mark(15,19,1);

        board.printBoard();
        while (board.hasPlayerWon()==0) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.planNextMove();
            board.mark(robot.getNextMoveX(),robot.getNextMoveY(),robot.getPlayerNumber());
            board.mark(generator.nextInt(20), generator.nextInt(20), board.getActivePlayer().getNumber());
            board.switchActivePlayer();
            board.printBoard();
        }


    }
}
