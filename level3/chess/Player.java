public abstract class Player {
    private final boolean white;

    public Player(boolean white, boolean human) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void makeMove(Spot start, Spot end) {
        end.setPiece(start.getPiece());
        start.setPiece(null);
    }
}
