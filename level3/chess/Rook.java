
public class Rook extends Piece implements CrossMove{


    public Rook(boolean white) {
        super(white, "R");
    }

    @Override
    public boolean canMove(Move move) {
        Spot start = move.start;
        Spot end = move.end;

        char start_file = start.getFile();
        char end_file = end.getFile();
        char start_rank = start.getRank();
        char end_rank = end.getRank();

        if (start_rank != end_rank && start_file != end_file)
            return false;

        if (start_file < end_file || start_rank < end_rank) {
            step = 1;
        } else {
            step = -1;
        }

        return isPathClear(start_file, end_file, start_rank, end_rank, move.board);
    }

    public boolean isPathClear(char start_file, char end_file, char start_rank, char end_rank, Board board) {
        if (start_file == end_file) {
            for (int i = (start_rank + step); i != end_rank; i += step) {
                Piece current_piece = board.getSpot(start_file, (char) i).getPiece();
                if (current_piece != null)
                    return false;
            }
        } else {
            for (int i = (start_file + step); i != end_file; i += step) {
                Piece current_piece = board.getSpot((char) i, start_rank).getPiece();
                if (current_piece != null)
                    return false;
            }
        }

        return true;
    }
}
