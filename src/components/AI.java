package components;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by arkad_000 on 2016-06-12.
 */
public class AI {
    private int playerNumber;
    private int nextMoveX;
    private int nextMoveY;
    int[][] board;

    public AI(int[][] board, int playerNumber) {
        this.playerNumber = playerNumber;
        this.board = board;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getNextMoveX() {
        return nextMoveX;
    }

    public int getNextMoveY() {
        return nextMoveY;
    }

    public void planNextMove() {
        //general loop
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                //if winning move available - take it!
                if (willThisMoveWin(i,j)) {
                    nextMoveX=i;
                    nextMoveY=j;
                    return;
                }
                //blocking winning move for opponent

                //TODO next options

                //take part in 4
                    //take part in others
                //take part in 3
                    //take part in others





            }
        }
    }

    public boolean willThisMoveWin(int x, int y) {
        if (board[x][y]>0) {
            return false;
        }

        Board.getBoard()[x][y]=playerNumber;
        if (Board.hasPlayerWon()==getPlayerNumber()) {
            Board.getBoard()[x][y]=0;
            return true;
        }
        Board.getBoard()[x][y]=0;
        return false;
    }

    public boolean willOponnentWinWithThisMove(int x, int y) {
        if (board[x][y]>0) {
            return false;
        }
        //TODO
        //oponnent can win with many moves - we need to block the best of them

        Board.getBoard()[x][y]=playerNumber;
        if (Board.hasPlayerWon()==getPlayerNumber()) {
            Board.getBoard()[x][y]=0;
            return true;
        }
        Board.getBoard()[x][y]=0;
        return false;
    }

    public int possibleWins(int x, int y) {

        //TODO

        return 0;
    }

}
