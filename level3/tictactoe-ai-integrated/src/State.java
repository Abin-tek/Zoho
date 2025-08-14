public class State implements Cloneable {
    private Board board;
    private Player currPlayer;
    private boolean max;
    private int depth;
    private int value;
    private int id;
    private boolean terminal;

    public State(Board board, Player currPlayer, boolean max, int depth, int value, int id, boolean terminal) {
        this.board = board;
        this.currPlayer = currPlayer;
        this.max = max;
        this.depth = depth;
        this.value = value;
        this.id = id;
        this.terminal = terminal;
    }

    @Override
    public State clone() {
        try {
            State cloned = (State) super.clone();
            cloned.board = this.board.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public int getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isMax() {
        return max;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean compare(State state) {
        return state.value > this.value;
    }

    public void result() {
        if (board.isWin(id, currPlayer)) {
            value = currPlayer.isMax() ? 10 - depth : depth - 10;
        } else if (depth == 9) {
            value = 0;
        } else {
            return;
        }

        terminal = true;
    }

    public boolean isTerminal() {
        return terminal;
    }

    protected void evaluate(int i, Toggle callBack) {
        board.playMove(i, currPlayer);
        id = i;
        result();

        depth++;
        max = !max;
        currPlayer = callBack.togglePlayer(currPlayer);
    }
}
