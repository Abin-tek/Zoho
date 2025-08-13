public class Move {
    private final int depth;
    private final int id;
    private final Board board;
    private final Player player;

    public Move(int depth, int id, Board board, Player player) {
        this.depth = depth;
        this.id = id;
        this.board = board;
        this.player = player;
    }

    public Board getBoard() {
        return board;
    }

    public void show() {
        printMove();
        board.printBoard();
    }

    protected void printMove() {
        System.out.printf("\nMove %d of %c is %d", depth, player.getName(), id);
    }
}
