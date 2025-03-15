public class Spot {
    private char file;
    private char rank;
    private Piece piece;

    public Spot(char file, char rank, Piece piece) {
        this.file = file;
        this.rank = rank;
        this.piece = piece;
    }

    public Spot(char file, char rank) {
        this.file = file;
        this.rank = rank;
        this.piece = null;
    }

    public char getFile() {
        return file;
    }

    public char getRank() {
        return rank;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


}
