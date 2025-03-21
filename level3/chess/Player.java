public abstract class Player {
    private final boolean white;
    private final String name;

    public Player(boolean white, String name) {
        this.white = white;
        this.name = name;
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

    public String getName() {
        return name;
    }
}
