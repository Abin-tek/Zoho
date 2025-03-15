public class Knight extends Piece {

    public Knight(boolean white) {
        super(white, "N");
    }

    @Override
    public boolean canMove(Spot start, Spot end, Player currentPlayer, Board board) {
        int dx = Math.abs(start.getFile() - end.getFile());
        int dy = Math.abs(start.getRank() - end.getRank());


        if (dx == 1 && dy == 2 || dx == 2 && dy == 1)
            return isPathClear(start, end, currentPlayer, board);

        return  false;
    }

    @Override
    public boolean isPathClear(Spot start, Spot end, Player currentPlayer, Board board) {
        Piece target = end.getPiece();
        return target == null || target.isWhite() != currentPlayer.isWhite();
    }
}
