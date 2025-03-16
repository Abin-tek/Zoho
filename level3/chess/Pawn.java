public class Pawn extends Piece {
    private boolean first_move;

    public Pawn(boolean white) {
        super(white, "P");
        this.first_move = true;
    }

    @Override
    public boolean canMove(Spot start, Spot end, Player currentPlayer, Board board) {
        char start_rank = start.getRank();
        char start_file = start.getFile();
        char end_rank = end.getRank();
        char end_file = end.getFile();
        int range = 1;

        if (this.first_move) {
            range = 2;
        }

        int dy = start_rank - end_rank;
        dy *= currentPlayer.isWhite() ? -1 : 1;
        int dx = Math.abs(start_file - end_file);

        if (end_file == start_file) {
            if (dy < 0 || dy > range)
                return false;
        } else {
            if (dx != 1 || dy != 1)
                return false;
        }

        return isPathClear(start_file, end_file, start_rank, end_rank, currentPlayer, board, end.getPiece());
    }

    public boolean isPathClear(char start_file, char end_file, char start_rank, char end_rank, Player currentPlayer, Board board, Piece target) {
        if (start_file == end_file) {
            if (this.first_move) {
                int midRank = (start_rank + end_rank + 1) / 2;
                if ((board.getSpot(end_file, (char) (midRank)).getPiece() != null))
                    return false;
            }

            if (target != null)
                return false;
        } else if (target == null || target.isWhite() == currentPlayer.isWhite())
            return false;

        this.first_move = false;
        return true;
    }
}
