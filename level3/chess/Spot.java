import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class Spot extends JButton {
//    private static final Color LIGHT_COLOR = new Color(222, 184, 135);
//    private static final Color DARK_COLOR = new Color(139, 69, 19);
    private static final Color LIGHT_COLOR_GREEN = new Color(235, 236, 208);
    private static final Color DARK_COLOR_GREEN = new Color(115, 149, 81);
    private static final int PIECE_SIZE = 90;
    private final char file;
    private final char rank;
    private Piece piece;

    public Spot(char file, char rank, Piece piece, Consumer<Spot> clickListener) {
        this.file = file;
        this.rank = rank;
        this.piece = piece;
        if (piece != null)
            setIcon(resizeImage("icons/" + piece.getVal() + "3d.png"));
        setOpaque(true);
        setBorderPainted(false);
        setBackgroundColor();
        addActionListener(e -> clickListener.accept(this));
        setFocusable(false);
    }

    protected void setBackgroundColor() {
        this.setBackground(((file + rank) & 1) == 0 ? LIGHT_COLOR_GREEN : DARK_COLOR_GREEN);
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
