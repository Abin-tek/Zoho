public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white, "B");
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        char start_file = start.getFile();
        char end_file = end.getFile();
        char start_rank = start.getRank();
        char end_rank = end.getRank();

        int dx = Math.abs(start_file - end_file);
        int dy = Math.abs(start_rank - end_rank);

        if (dx != dy)
            return false;

        dx = (start_file < end_file) ? 1 : -1;
        dy = (start_rank < end_rank) ? 1 : -1;

        return isPathClear(dx, dy, start_file, end_file, start_rank, board);
    }

    public boolean isPathClear(int dx, int dy, char start_file, char end_file, char start_rank, Board board) {

        for (int i = (start_file + dx), j = (start_rank + dy); i != end_file; i += dx, j += dy) {
            Piece current_piece = board.getSpot((char) i, (char) j).getPiece();
            if (current_piece != null)
                return false;
        }

        return true;
    }
}
