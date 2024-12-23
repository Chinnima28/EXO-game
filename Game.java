import java.util.*;

public class Game {
    String player1;
    String player2;

    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    Scanner sc = new Scanner(System.in);

    public boolean boardValid(int i, int j, char[][] board) {
        return board[i][j] == '\0'; // Check if the cell is empty
    }

    public void play() {
        boolean play1 = false;
        boolean play2 = false;
        int movesLeft = 9;
        char[][] board = new char[3][3];

        while ((!play1 && !play2) && movesLeft > 0) {
            int i, j;

            if (movesLeft % 2 != 0) {
                System.out.println(player1 + ", enter the coordinates where you want to place your coin (row and column): ");
                i = sc.nextInt();
                j = sc.nextInt();

                if (i >= 0 && i < 3 && j >= 0 && j < 3 && boardValid(i, j, board)) {
                    board[i][j] = 'x';
                    if (exo(board, i, j, 'x')) {
                        play1 = true;
                        System.out.println(player1 + " wins!");
                        break;
                    }
                } else {
                    System.out.println("Choose valid coordinates.");
                    continue;
                }
            } else {
                System.out.println(player2 + ", enter the coordinates where you want to place your coin (row and column): ");
                i = sc.nextInt();
                j = sc.nextInt();

                if (i >= 0 && i < 3 && j >= 0 && j < 3 && boardValid(i, j, board)) {
                    board[i][j] = 'o';
                    if (exo(board, i, j, 'o')) {
                        play2 = true;
                        System.out.println(player2 + " wins!");
                        break;
                    }
                } else {
                    System.out.println("Choose valid coordinates.");
                    continue;
                }
            }

            movesLeft--;
        }

        if (!play1 && !play2 && movesLeft == 0) {
            System.out.println("It's a draw!");
        }
    }

    public boolean exo(char[][] board, int i, int j, char c) {
        for (int col = 0; col < 3; col++) {
            if (board[i][col] != c) {
                break;
            }
            if (col == 2) return true;
        }

        for (int row = 0; row < 3; row++) {
            if (board[row][j] != c) {
                break;
            }
            if (row == 2) return true;
        }

        if (i == j) {
            for (int diag = 0; diag < 3; diag++) {
                if (board[diag][diag] != c) {
                    break;
                }
                if (diag == 2) return true;
            }
        }

        if (i + j == 2) {
            for (int diag = 0; diag < 3; diag++) {
                if (board[diag][2 - diag] != c) {
                    break;
                }
                if (diag == 2) return true;
            }
        }

        return false;
    }
}
