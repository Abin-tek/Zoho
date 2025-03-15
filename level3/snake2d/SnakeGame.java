import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class SnakeGame {
    private final char[][] board;
    private final int total_row;
    private final int total_col;
    private final Queue<Node> snake_body;
    private final Random random = new Random();
    private int cur_row, cur_col;
    private char cur_head;

    SnakeGame(int row, int col) {
        board = new char[row][col];
        total_row = row;
        total_col = col;
        snake_body = new LinkedList<>();
        cur_row = 1;
        cur_col = 1;
        cur_head = '>';
    }

    public void start() {
        snake_body.add(new Node(cur_row, cur_col));
        board[cur_row][cur_col] = cur_head;
        placeFood();
        placeWall();
        printBoard();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter (R, D, L, U) : ");
            char move = sc.next().toUpperCase().charAt(0);
            if (makeMove(move)) {
                printBoard();
            } else {
                System.out.println("Game Over! :( ...");
                break;
            }
        }
        System.out.println();
        sc.close();
    }

    private void placeFood() {
        Node food;
        do {
            food = new Node(random.nextInt(total_row - 2) + 1, random.nextInt(total_col - 2) + 1);
        } while (board[food.row][food.col] != '\0');
        board[food.row][food.col] = '\u25CF';
    }

    private void placeWall() {
        for (int i = 0; i < total_row; i++) {
            for (int j = 0; j < total_col; j++) {
                if (i == 0 || j == 0 || i == total_row - 1 || j == total_col - 1) {
                    if (isNotMiddle(i, j))
                        board[i][j] = '\u25FC';
                }
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < total_row; i++) {
            for (int j = 0; j < total_col; j++) {
                char cell = board[i][j];
                System.out.print((cell == '\0' ? '\u2610' : cell) + " "); // Unicode of '☐'
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean makeMove(char dir) {
        int new_row = cur_row, new_col = cur_col;
        char new_head;
        switch (dir) {
            case 'R':
                new_col = ++new_col % total_col;
                new_head = '>';
                break;
            case 'D':
                new_row = ++new_row % total_row;
                new_head = 'v';
                break;
            case 'L':
                new_col = --new_col < 0 ? total_col - 1 : new_col;
                new_head = '<';
                break;
            case 'U':
                new_row = --new_row < 0 ? total_row - 1 : new_row;
                new_head = '^'; // Unicode of 'ʌ'
                break;
            default:
                System.out.println("Invalid input! use (R, D, L, U)");
                return true;
        }

        if (!isValidMove(new_row, new_col)) {
            return false;
        }

        board[cur_row][cur_col] = '\u25FC'; // Unicode of '◼'

        if (board[new_row][new_col] == '\u25CF') {
            placeFood();
        } else {
            Node tail = snake_body.poll();
            if (tail == null) throw new AssertionError();
            board[tail.row][tail.col] = '\0';
        }

        cur_row = new_row;
        cur_col = new_col;
        cur_head = new_head;
        snake_body.add(new Node(cur_row, cur_col));
        board[cur_row][cur_col] = cur_head;

        return true;
    }

    private boolean isValidMove(int row, int col) {
        return board[row][col] == '\0' || board[row][col] == '\u25CF';
    }

    private boolean isNotMiddle(int row, int col) {
        return row != total_row / 2 && row + 1 != total_row / 2 && col != total_col / 2 && col + 1 != total_col / 2;
    }
}