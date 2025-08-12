
public abstract class Player {
    private final char name;
    private final boolean max;

    public Player(char name, boolean max) {
        this.name = name;
        this.max = max;
    }

    public char getName() {
        return name;
    }

    public boolean isMax() {
        return max;
    }
}
