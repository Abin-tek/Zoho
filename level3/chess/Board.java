import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board extends JFrame {
    private final Spot[][] grid;
    public static final int SIZE = 8;
    private static final int BOARD_SIZE = 1000;
    private static final int PIECE_SIZE = 80;
    private static final Color LIGHT_COLOR = new Color(222, 184, 135);
    private static final Color DARK_COLOR = new Color(139, 69, 19);
    private final Map<String, ImageIcon> pieceImages = new HashMap<>();
    Game game;
    private Spot startSquare;
    private Spot endSquare;
    JPanel boardPanel = new JPanel(new GridLayout(SIZE, SIZE)) {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(BOARD_SIZE, BOARD_SIZE);
        }
    };

    public Board(Game game) {
        setTitle("Chess");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);
        this.grid = new Spot[SIZE][SIZE];
        this.game = game;
        this.startSquare = null;
        this.endSquare = null;
        resetBoard();
        add(boardPanel, new GridBagConstraints());
        setVisible(true);
    }

    public void resetBoard() {
        grid[0][0] = new Spot('a', '8', new Rook(false), game, this);
        grid[0][1] = new Spot('b', '8', new Knight(false), game, this);
        grid[0][2] = new Spot('c', '8', new Bishop(false), game, this);
        grid[0][3] = new Spot('d', '8', new Queen(false), game, this);
        grid[0][4] = new Spot('e', '8', new King(false), game, this);
        grid[0][5] = new Spot('f', '8', new Bishop(false), game, this);
        grid[0][6] = new Spot('g', '8', new Knight(false), game, this);
        grid[0][7] = new Spot('h', '8', new Rook(false), game, this);

        grid[7][0] = new Spot('a', '1', new Rook(true), game, this);
        grid[7][1] = new Spot('b', '1', new Knight(true), game, this);
        grid[7][2] = new Spot('c', '1', new Bishop(true), game, this);
        grid[7][3] = new Spot('d', '1', new Queen(true), game, this);
        grid[7][4] = new Spot('e', '1', new King(true), game, this);
        grid[7][5] = new Spot('f', '1', new Bishop(true), game, this);
        grid[7][6] = new Spot('g', '1', new Knight(true), game, this);
        grid[7][7] = new Spot('h', '1', new Rook(true), game, this);

        for (int i = 0; i < SIZE; i++) {
            grid[1][i] = new Spot((char) ('a' + i), '7', new Pawn(false), game, this);
            grid[6][i] = new Spot((char) ('a' + i), '2', new Pawn(true), game, this);
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Spot((char) ('a' + j), (char) ('8' - i), game, this);
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boardPanel.add(grid[i][j]);
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

    public Spot getStartSquare() {
        return startSquare;
    }

    public void setStartSquare(Spot startSquare) {
        this.startSquare = startSquare;
    }

    public Spot getEndSquare() {
        return endSquare;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = grid[i][j].getPiece();
                System.out.print((piece != null ? piece.getVal() : "--") + " ");
            }
            System.out.println();
        }

    }

    public void refresh() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boardPanel.add(grid[i][j]);
            }
        }
    }
}
