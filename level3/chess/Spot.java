import javax.swing.*;
import java.awt.*;

public class Spot extends JButton {
    private static final Color LIGHT_COLOR = new Color(222, 184, 135);
    private static final Color DARK_COLOR = new Color(139, 69, 19);
    private static final int PIECE_SIZE = 90;
    private final char file;
    private final char rank;
    private Piece piece;
    Game game;
    Board board;

    public Spot(char file, char rank, Piece piece, Game game, Board board) {
        this.file = file;
        this.rank = rank;
        this.piece = piece;
        this.setIcon(resizeImage("icons/" + piece.getVal() + ".png"));
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setBackground(((file + rank) & 1) == 0 ? LIGHT_COLOR : DARK_COLOR);
        this.game = game;
        this.board = board;
        this.addActionListener(new SquareClickListener(file, rank, this.game, this.board));
    }

    public Spot(char file, char rank, Game game, Board board) {
        this.file = file;
        this.rank = rank;
        this.piece = null;
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setBackground(((file + rank) & 1) == 0 ? LIGHT_COLOR : DARK_COLOR);
        this.game = game;
        this.board = board;
        this.addActionListener(new SquareClickListener(file, rank, this.game, this.board));

    }

    public char getFile() {
        return file;
    }

    public char getRank() {
        return rank;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    private ImageIcon resizeImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(PIECE_SIZE, PIECE_SIZE, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

}
