public abstract class Piece {
    boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean canMove() {

        return false;
    }

    public boolean isPathClear() {
        return false;
    }
}
