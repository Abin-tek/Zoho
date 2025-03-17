public class Knight extends Piece {

    public Knight(boolean white) {
        super(white, "N");
    }

    @Override
    public boolean canMove(Spot start, Spot end, Board board) {
        int dx = Math.abs(start.getFile() - end.getFile());
        int dy = Math.abs(start.getRank() - end.getRank());

        return dx * dy == 2;
    }
}
