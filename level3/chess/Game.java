public class Game {
    private Board board;
    private Player[] players = new Player[2];
    private Player current_player;
    private Status status;
    private Spot start;
    private Spot end;

    public Game(Player robot, Player human) {
        this.players[0] = robot;
        this.players[1] = human;
        this.current_player = human;
        this.status = Status.Active;
    }

    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrent_player() {
        return current_player;
    }

    public Status getStatus() {
        return status;
    }

    public Spot getStart() {
        return start;
    }

    public Spot getEnd() {
        return end;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setCurrent_player(Player current_player) {
        this.current_player = current_player;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStart(Spot start) {
        this.start = start;
    }

    public void setEnd(Spot end) {
        this.end = end;
    }

    public void start(){

    }
}
