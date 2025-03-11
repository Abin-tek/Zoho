import java.util.Scanner;

public class XO_Game {
    private char[][] board;
    private int grid, move, row, col;
    private char curr_player;
    private boolean win;

    XO_Game(int given_grid, char first_player) {
        grid = given_grid;
        move = 0;
        row = 0;
        col = 0;
        curr_player = first_player != 'X' && first_player != 'O' ? 'X' : first_player;
        win = false;
        board = new char[grid][grid];
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (!win && move < grid * grid) {
            printBoard();
            System.out.printf("Player %c, Enter the move (x, y): ", curr_player);
            row = sc.nextInt();
            col = sc.nextInt();

            if (isValidMove()) {
                move++;
                board[row][col] = curr_player;
                if (checkWinner()) {
                    win = true;
                    printBoard();
                    System.out.println(curr_player + " uh, neethamle...");
                } else
                    curr_player = curr_player == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Venam philips uhh...");
            }
        }

        if (!win) {
            printBoard();
            System.out.println("Idiapoom...");
        }
        sc.close();
    }

    private void printBoard() {
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

    private boolean isValidMove() {
        return row >= 0 && row < grid && col >= 0 && col < grid && board[row][col] == '\0';
    }

    private boolean checkWinner() {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter grid size and first player: ");
        XO_Game xo = new XO_Game(sc.nextInt(), sc.next().toUpperCase().charAt(0));
        xo.start();
        sc.close();
    }
}