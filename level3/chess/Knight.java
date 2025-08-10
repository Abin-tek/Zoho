public class Knight extends Piece {

    public Knight(boolean white) {
        super(white, "N");
    }

    @Override
    public boolean canMove(Move move) {
        Spot start = move.start;
        Spot end = move.end;
        int dx = Math.abs(start.getFile() - end.getFile());
        int dy = Math.abs(start.getRank() - end.getRank());

        return dx * dy == 2;
    }
}
