public abstract class Piece {
    private final boolean white;
    private StringBuffer val;

    public Piece(boolean white, String name) {
        this.white = white;
        this.val = new StringBuffer();
        setVal(name);
    }

    public boolean isPathClear(Spot start, Spot end, Player currentPlayer, Board board) {
        return false;
    }


    private void setVal(String name) {
        val.append(white ? "W" : "B");
        val.append(name);
    }

    public String getVal() {
        return val.toString();
    }

    public boolean canMove(Spot start, Spot end, Player currentPlayer, Board board) {
        return  false;
    }

    public boolean isWhite() {
        return white;
    }
}
