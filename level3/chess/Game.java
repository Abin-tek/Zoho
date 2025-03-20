

public class Game {
    private final Board board;
    private final Player[] players = new Player[2];
    private Player current_player;
    private Status status;

    public Game(Player human, Player robot) {
        this.players[0] = human;
        this.players[1] = robot;
        this.current_player = human;
        this.status = Status.Active;
        this.board = new Board(this);
    }

    public void start() {
        board.printBoard();
    }

    public void processMove(String ip) {
        if (ip.equals("exit")) {
            status = Status.End;
            System.out.println("Game over!");
            return;
        }

        Spot[] move = getMoves(ip);
        if (move == null) {
            System.out.println("Invalid input format");
            return;
        }

        Spot start = move[0];
        Spot end = move[1];

        if (start != null && end != null && board.playMove(start, end, current_player)) {
            board.printBoard();
            current_player = current_player.equals(players[0]) ? players[1] : players[0];
        } else {
            System.out.println("Invalid move");
        }
    }

    private Spot[] getMoves(String ip) {
        if (ip.length() != 5)
            return null;

        return new Spot[]{board.getSpot(ip.charAt(0), ip.charAt(1)), board.getSpot(ip.charAt(3), ip.charAt(4))};
    }

    public Status getStatus() {
        return status;
    }
}
