public class Cell {
    private int id;
    private int row;
    private  int col;
    private Piece piece;

    public Cell(int id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    public int getId() {
        return id;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
