import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareClickListener implements ActionListener {
    private final int row;
    private final int col;
    private JButton startSquare;
    private JButton endSquare;
    ChessBoard chessBoard;
    Game game;

    public SquareClickListener(int row, int col, ChessBoard chessBoard) {
        this.row = row;
        this.col = col;
        this.chessBoard = chessBoard;
        startSquare = null;
        endSquare = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (startSquare != null) {
            startSquare = chessBoard.getSquares(row, col);
            startSquare.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            startSquare.setBorderPainted(true);
        } else {
            endSquare = chessBoard.getSquares(row, col);
            endSquare.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            endSquare.setBorderPainted(true);
            sendMove(startSquare, endSquare);
            resetSelection();
        }
    }

    private void sendMove(JButton start, JButton end) {
        String move = getSquareName(start) + " " + getSquareName(end);
        System.out.println("Move : " + move);

    }

    private String getSquareName(JButton square) {
        for (int row = 0; row < ChessBoard.SIZE; row++) {
            for (int col = 0; col < ChessBoard.SIZE; col++) {
                if (chessBoard.getSquares()[row][col] == square) {
                    return (char) ('a' + col) + String.valueOf(8 - row);
                }
            }
        }

        return "";
    }

    private void resetSelection() {
        if (startSquare != null)
            startSquare.setBorderPainted(false);
        if (endSquare != null)
            endSquare.setBorderPainted(false);

        startSquare = null;
        endSquare = null;
    }

}
