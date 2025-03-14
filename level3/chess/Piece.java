public abstract class Piece {
    private boolean white;
    private StringBuffer val;

    public Piece(boolean white, String name) {
        this.white = white;
        this.val = new StringBuffer();
        setVal(name);
    }

    public boolean canMove() {

        return false;
    }

    public boolean isPathClear() {
        return false;
    }


    private void setVal(String name) {
        val.append(white ? "W" : "B");
        val.append(name);
    }

    public String getVal() {
        return val.toString();
    }
}
