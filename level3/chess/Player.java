public abstract class Player {
    private final boolean white;

    public Player(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void makeMove(Spot start, Spot end) {
        end.setPiece(start.getPiece());
        end.setIcon(start.getIcon());
        start.setPiece(null);
        start.setIcon(null);
    }
}
