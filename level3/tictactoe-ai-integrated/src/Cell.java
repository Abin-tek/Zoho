
public class Cell implements Cloneable {
    private final int id;
    private final int row;
    private final int col;
    private Player player;

    public Cell(int id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.player = null;
    }

    @Override
    public Cell clone() {
        try {
            return (Cell) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Player getPlayer() {
        return player;
    }

    public int getId() {
        return id;
    }
}
