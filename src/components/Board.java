package components;

/**
 * Created by akrzos on 2016-06-10.
 */
public class Board {
    static int[][]  board = new int[20][20];
    Player player1;
    Player player2;
    Player activePlayer;

    public static int[][] getBoard() {
        return board;
    }

    //TODO placeholder method
    public void preparePlayers() {
        player1 = new Player();
        player2 = new Player();
        player1.setNumber(1);
        player2.setNumber(2);

        activePlayer = player1;
    }

    public void switchActivePlayer() {
        if (activePlayer==player1) {
            activePlayer=player2;
        } else {
            activePlayer=player1;
        }
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void printBoard() {
        System.out.println("==========================================================");
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y]==0) {
                    System.out.print(".");
                }
                                if (board[x][y]==1) {
                    System.out.print("X");
                }
                                if (board[x][y]==2) {
                    System.out.print("O");
                }

                System.out.print("  ");
            }
            System.out.println();
        }

    }

    public boolean mark(int x, int y, int playerNo) {
        if (x<0 || x>19 || y<0 || y>19) {
            return false;
        } else
        if (board[x][y]>0) {
            return false;
        } else {
            board[x][y]=playerNo;
            return true;
        }
    }

    public static int hasPlayerWon() {
        int checkedPlayer;
        boolean playerWon;

        //horizontalWin
        for (int x = 0; x <= 15; x++) {
            for (int y = 0; y <= 19; y++) {
                if (board[x][y]>0) {
                    checkedPlayer = board[x][y];
                    playerWon=true;
                    for (int i = 1; i < 5; i++) {
                        if (board[x+i][y]!=checkedPlayer) {
                            playerWon=false;
                        }
                    }
                    if (playerWon) {
                        return checkedPlayer;
                    }
                }
            }
        }

        //VerticalWin
        for (int x = 0; x <= 19; x++) {
            for (int y = 0; y <= 15; y++) {
                if (board[x][y]>0) {
                    checkedPlayer = board[x][y];
                    playerWon=true;
                    for (int i = 1; i < 5; i++) {
                        if (board[x][y+i]!=checkedPlayer) {
                            playerWon=false;
                        }
                    }
                    if (playerWon) {
                        return checkedPlayer;
                    }
                }
            }
        }

        //Diagonal\Win
        for (int x = 0; x <= 15; x++) {
            for (int y = 0; y <= 15; y++) {
                if (board[x][y]>0) {
                    checkedPlayer = board[x][y];
                    playerWon=true;
                    for (int i = 1; i < 5; i++) {
                        if (board[x+i][y+i]!=checkedPlayer) {
                            playerWon=false;
                        }
                    }
                    if (playerWon) {
                        return checkedPlayer;
                    }
                }
            }
        }

        //Diagonal/Win
        for (int x = 4; x <= 19; x++) {
            for (int y = 0; y <= 15; y++) {
                if (board[x][y]>0) {
                    checkedPlayer = board[x][y];
                    playerWon=true;
                    for (int i = 1; i < 5; i++) {
                        if (board[x-i][y+i]!=checkedPlayer) {
                            playerWon=false;
                        }
                    }
                    if (playerWon) {
                        return checkedPlayer;
                    }
                }
            }
        }
        return 0; //no player won
    }
}
