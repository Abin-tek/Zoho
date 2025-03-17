public class Queen extends Piece {
    public Queen(boolean white) {
        super(white, "Q");
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        Piece straight = new Rook(start.getPiece().isWhite());
        Piece diagonal = new Bishop(start.getPiece().isWhite());

        return straight.canMove(start, end, board) || diagonal.canMove(start, end, board);
    }
}
