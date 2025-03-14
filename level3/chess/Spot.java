public class Spot {
    private int file;
    private int rank;
    private Piece piece;

    public Spot(int file, int rank, Piece piece) {
        this.file = file;
        this.rank = rank;
        this.piece = piece;
    }

    public Spot(int file, int rank) {
        this.file = file;
        this.rank = rank;
        this.piece = null;
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


}
