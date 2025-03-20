import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareClickListener implements ActionListener {
    private final char file;
    private final char rank;
    private static Spot start_square = null;
    Game game;
    Board board;

    public SquareClickListener(char file, char rank, Game game, Board board) {
        this.file = file;
        this.rank = rank;
        this.game = game;
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Spot startSquare = getStartSquare();

        if (startSquare == null) {
            startSquare = board.getSpot(file, rank);
            if (startSquare.getPiece() == null) return;
            startSquare.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            startSquare.setBorderPainted(true);
            setStartSquare(startSquare);
        } else {
            Spot endSquare = board.getSpot(file, rank);
            endSquare.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            endSquare.setBorderPainted(true);
            sendMove(startSquare, endSquare);
            resetSelection(startSquare, endSquare);
        }
    }

    private void resetSelection(Spot startSquare, Spot endSquare) {
        startSquare.setBorderPainted(false);
        endSquare.setBorderPainted(false);
        setStartSquare(null);
    }

    private void sendMove(Spot start, Spot end) {
        String move = "" + start.getFile() + start.getRank() + " " + end.getFile() + end.getRank();
        System.out.println("Move : " + move);
        game.processMove(move);
    }

    public static Spot getStartSquare() {
        return start_square;
    }

    public static void setStartSquare(Spot start_square) {
        SquareClickListener.start_square = start_square;
    }
}
