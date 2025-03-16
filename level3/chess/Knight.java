public class Knight extends Piece {

    public Knight(boolean white) {
        super(white, "N");
    }

    @Override
    public boolean canMove(Spot start, Spot end, Player currentPlayer, Board board) {
        int dx = Math.abs(start.getFile() - end.getFile());
        int dy = Math.abs(start.getRank() - end.getRank());


        if (dx == 1 && dy == 2 || dx == 2 && dy == 1)
            return isPathClear(end.getPiece(), currentPlayer);

        return  false;
    }

    public boolean isPathClear(Piece target, Player currentPlayer) {
        return target == null || target.isWhite() != currentPlayer.isWhite();
    }
}
