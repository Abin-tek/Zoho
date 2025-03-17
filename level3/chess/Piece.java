public abstract class Piece {
    private final boolean white;
    protected int step;
    private final StringBuffer val;

    public Piece(boolean white, String name) {
        this.white = white;
        this.val = new StringBuffer();
        setVal(name);
        step = 1;
    }

    private void setVal(String name) {
        val.append(white ? "W" : "B");
        val.append(name);
    }

    public String getVal() {
        return val.toString();
    }

    public boolean isWhite() {
        return white;
    }

    public boolean canMove(Spot start, Spot end, Board board) {
        return false;
    }

}
