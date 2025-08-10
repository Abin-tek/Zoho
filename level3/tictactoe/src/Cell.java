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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
