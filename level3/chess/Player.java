public abstract class Player {
    private final boolean white;
    private final boolean human;

    public Player(boolean white, boolean human) {
        this.white = white;
        this.human = human;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isHuman() {
        return human;
    }

    public void makeMove(Spot start, Spot end) {
        end.setPiece(start.getPiece());
        start.setPiece(null);
    }
}
