public class Pawn extends Piece {
    private  boolean first_move;

    public Pawn(boolean white) {
        super(white);
        first_move = true;
    }

    @Override
    public boolean canMove() {
        int step = 1, fl = 1, fr = 1;

        if (first_move) {
            step = 2;
            first_move = false;
        }

        return super.canMove();
    }

    @Override
    public boolean isPathClear() {
        if (first_move){
            return false;
        }
        return true;
    }
}
