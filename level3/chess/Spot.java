import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spot extends JButton implements ActionListener {
    private static final Color LIGHT_COLOR = new Color(222, 184, 135);
    private static final Color DARK_COLOR = new Color(139, 69, 19);
    private static final Color SELECTED_COLOR = new Color(180, 130, 90);
    private static final int PIECE_SIZE = 90;
    private final char file;
    private final char rank;
    private Piece piece;
    private final Board board;
    private static Spot start_square = null;

    public Spot(char file, char rank, Piece piece, Board board) {
        this.file = file;
        this.rank = rank;
        this.piece = piece;
        this.board = board;
        if (piece != null)
            setIcon(resizeImage("icons/" + piece.getVal() + ".png"));
        setOpaque(true);
        setBorderPainted(false);
        setBackgroundColor(this);
        addActionListener(this);
    }

    private void setBackgroundColor(Spot spot) {
        spot.setBackground(((spot.getFile() + spot.getRank()) & 1) == 0 ? LIGHT_COLOR : DARK_COLOR);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (start_square == null) {
            Piece start_piece = this.getPiece();
            if (start_piece == null) return;
            this.setBackground(SELECTED_COLOR);
            setStartSquare(this);
        } else {
            Piece end_piece = this.getPiece();
            if (end_piece != null && end_piece.isWhite() == start_square.getPiece().isWhite()) {
                setBackgroundColor(start_square);
                setStartSquare(this);
                this.setBackground(SELECTED_COLOR);
                return;
            }
            sendMove(start_square, this);
            setBackgroundColor(start_square);
            setStartSquare(null);
        }
    }

    private void sendMove(Spot start, Spot end) {
        String move = "" + start.getFile() + start.getRank() + " " + end.getFile() + end.getRank();
        board.passMove(move);
    }

    public static void setStartSquare(Spot square) {
        Spot.start_square = square;
    }
}
