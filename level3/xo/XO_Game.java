import java.util.Scanner;

public class XO_Game {
    Board board;
    private final int grid;
    private int moveCount;
    private int num;
    private char curr_player;
    private boolean win;
    private Scanner sc;

    XO_Game() {
        sc = new Scanner(System.in);
        System.out.print("Enter grid size and first player: ");
        grid = getGridSize();
        moveCount = 0;
        curr_player = getFirstPlayer();
        win = false;
        board = new Board(given_grid);
    }

    private char getFirstPlayer() {
        char name = sc.next().toUpperCase().charAt(0);
        
        return 'X';
    }

    private int getGridSize() {
        int size = sc.nextInt();
        if (size >= 3 && size <= 9)
            return size;
        return 3;
    }

    public void start() {
        while (!win && moveCount < grid * grid) {
            board.printBoard();
            System.out.printf("Player %c, Enter the position (1 to 9): ", curr_player);
            num = sc.nextInt();

            int[] coordinates = Position.calculate(num, grid);

            if (board.isValidMove()) {
                moveCount++;

                board[row][col] = curr_player;
                if (board.checkWinner()) {
                    win = true;
                    board.printBoard();
                    System.out.println(curr_player + " uh, neethamle...");
                } else
                    curr_player = curr_player == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Venam philips uhh...");
            }
        }

        if (!win) {
            board.printBoard();
            System.out.println("Idiapoom...");
        }
        sc.close();
    }


}