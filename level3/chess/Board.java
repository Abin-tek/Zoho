import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private static final Color BEZEL_COLOR = new Color(66, 66, 66);
    private final Spot[][] grid;
    public static final int SIZE = 8;
    private static final int BOARD_SIZE = 800;
    Game game;

    public Board(Game game) {
        this.grid = new Spot[SIZE][SIZE];
        this.game = game;
        setLayout(new GridLayout(SIZE, SIZE));
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        setBorder(BorderFactory.createLineBorder(BEZEL_COLOR, 10));
        resetBoard();
    }

    public void resetBoard() {
        grid[0][0] = new Spot('a', '8', new Rook(false), this);
        grid[0][1] = new Spot('b', '8', new Knight(false), this);
        grid[0][2] = new Spot('c', '8', new Bishop(false), this);
        grid[0][3] = new Spot('d', '8', new Queen(false), this);
        grid[0][4] = new Spot('e', '8', new King(false), this);
        grid[0][5] = new Spot('f', '8', new Bishop(false), this);
        grid[0][6] = new Spot('g', '8', new Knight(false), this);
        grid[0][7] = new Spot('h', '8', new Rook(false), this);

        grid[7][0] = new Spot('a', '1', new Rook(true), this);
        grid[7][1] = new Spot('b', '1', new Knight(true), this);
        grid[7][2] = new Spot('c', '1', new Bishop(true), this);
        grid[7][3] = new Spot('d', '1', new Queen(true), this);
        grid[7][4] = new Spot('e', '1', new King(true), this);
        grid[7][5] = new Spot('f', '1', new Bishop(true), this);
        grid[7][6] = new Spot('g', '1', new Knight(true), this);
        grid[7][7] = new Spot('h', '1', new Rook(true), this);

        for (int i = 0; i < SIZE; i++) {
            grid[1][i] = new Spot((char) ('a' + i), '7', new Pawn(false), this);
            grid[6][i] = new Spot((char) ('a' + i), '2', new Pawn(true), this);
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Spot((char) ('a' + j), (char) ('8' - i), null, this);
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.add(grid[i][j]);
            }
        }
    }

    public Spot getSpot(char file, char rank) {
        if (!belongsToBoard(file, rank))
            return null;
        return grid['8' - rank][file - 'a'];
    }

    private boolean belongsToBoard(char file, char rank) {
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }

    protected void passMove(String ip) {
        game.processMove(ip);
    }

    public boolean playMove(Spot start, Spot end, Player currentPlayer) {
        Piece start_piece = start.getPiece();
        Piece end_piece = end.getPiece();

        if (start.equals(end) || start_piece == null || start_piece.isWhite() != currentPlayer.isWhite())
            return false;
        if (end_piece != null && end_piece.isWhite() == currentPlayer.isWhite())
            return false;

        if (start_piece.canMove(start, end, this)) {
            currentPlayer.makeMove(start, end);
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = grid[i][j].getPiece();
                System.out.print((piece != null ? piece.getVal() : "--") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
