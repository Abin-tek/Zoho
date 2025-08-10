import javax.swing.*;

public class Pawn extends Piece {
    private boolean first_move;

    public Pawn(boolean white) {
        super(white, "P");
        this.first_move = true;
    }

    @Override
    public boolean canMove(Move move) {
        Spot start = move.start;
        Spot end = move.end;
        char start_rank = start.getRank();
        char start_file = start.getFile();
        char end_rank = end.getRank();
        char end_file = end.getFile();
        int range = 1;

        if (this.first_move) {
            range = 2;
        }

        step = start.getPiece().isWhite() ? 1 : -1;
        int dy = end_rank - start_rank;
        dy *= step;
        int dx = Math.abs(start_file - end_file);

        if (end_file == start_file) {
            if (dy < 0 || dy > range)
                return false;
        } else {
            if (end.getPiece() == null ||  dx != 1 || dy != 1)
                return false;
        }

        return isPathClear(start_file, end_file, start_rank, end_rank, move.board);
    }

    public boolean isPathClear(char start_file, char end_file, char start_rank, char end_rank, Board board) {
        if (start_file == end_file) {
            if (this.first_move) {
                int midRank = (start_rank + end_rank + step) / 2;
                if ((board.getSpot(end_file, (char) (midRank)).getPiece() != null))
                    return false;
            }
        }

        this.first_move = false;
        return true;
    }
}
