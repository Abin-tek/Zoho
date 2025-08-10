public class King extends Piece {
    public King(boolean white) {
        super(white, "K");
    }

    @Override
    public boolean canMove(Move move) {
        Spot start = move.start;
        Spot end = move.end;
        int dx = Math.abs(start.getFile() - end.getFile());
        int dy = Math.abs(start.getRank() - end.getRank());

        return dx * dy == 1 || dx + dy == 1;
    }
}
