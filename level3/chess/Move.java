public class Move {
    Player player;
    Spot start;
    Spot end;
    Board board;

    public Move(Player player, Spot start, Spot end, Board board) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.board = board;
    }
}
