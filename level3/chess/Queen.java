public class Queen extends Piece {
    public Queen(boolean white) {
        super(white, "Q");
    }

    @Override
    public boolean canMove(Move move) {
        Spot start = move.start;
        Piece straight = new Rook(start.getPiece().isWhite());
        Piece diagonal = new Bishop(start.getPiece().isWhite());

        return straight.canMove(move) || diagonal.canMove(move);
    }
}
