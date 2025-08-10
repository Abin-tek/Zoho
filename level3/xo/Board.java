public class Board {
    private final Piece[][] board;
    private final int grid;
    private int row;
    private int col;
    private char curr_player;

    public Board(int grid) {
        this.grid = grid;
        this.board = new char[grid][grid];
    }

    protected void printBoard() {
        System.out.println();
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                char c = board[i][j];
                System.out.print(c == '\0' ? '\u2022' : c);
                System.out.print("   ");
            }
            System.out.println("\n");
        }
        System.out.println();
    }


    protected boolean isValidMove() {
        return row >= 0 && row < grid && col >= 0 && col < grid && board[row][col] == '\0';
    }

    protected  boolean checkWinner() {
        return checkRow() || checkCol() || checkDiag();
    }

    private boolean checkRow() {
        for (int j = 0; j < grid; j++) {
            if (board[row][j] != curr_player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol() {
        for (int i = 0; i < grid; i++) {
            if (board[i][col] != curr_player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiag() {
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < grid; i++) {
            if (board[i][i] != curr_player) {
                diag1 = false;
            }
            if (board[i][grid - i - 1] != curr_player) {
                diag2 = false;
            }
        }
        return diag1 || diag2;
    }
}
