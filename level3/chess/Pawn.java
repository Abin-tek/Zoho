public class Pawn extends Piece {
    private boolean first_move;
    private int step;

    public Pawn(boolean white) {
        super(white, "P");
        first_move = true;
        step = 1;
    }

    @Override
    public boolean canMove(Spot start, Spot end, Player currentPlayer, Board board) {

        if (first_move) {
            step = 2;
            first_move = false;
        } else {
            step = 1;
        }


        if (end.getFile() == start.getFile()) {
            if (currentPlayer.isWhite() && start.getRank() - end.getRank() < -step)
                return false;
            else if (start.getRank() - end.getRank() > step)
                return false;
        } else {
            if (Math.abs(start.getFile() - end.getFile()) != 1 || start.getRank() - end.getRank() == (currentPlayer.isWhite() ? 1 : -1))
                return false;
        }

        return isPathClear(start, end, currentPlayer, board);
    }

    @Override
    public boolean isPathClear(Spot start, Spot end, Player currentPlayer, Board board) {
        step = currentPlayer.isWhite() ? 1 : -1;

        for (char i = (char) (start.getRank() + step); i < end.getRank(); i += step) {
            if (board.getBox(end.getFile(), i).getPiece() != null)
                return false;
        }

        Piece target = board.getBox(end.getFile(), end.getRank()).getPiece();

        if (start.getFile() != end.getFile())
            return target != null && target.isWhite() != currentPlayer.isWhite();
        else
            return target == null;
    }
}
