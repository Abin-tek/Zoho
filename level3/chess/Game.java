import java.util.Scanner;

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
        this.board = new Board();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        board.resetBoard();
        board.printBoard();

        while (true) {
            System.out.print("\n" + (current_player.isHuman() ? "Human" : "Robot") + "'s Move : ");
            String ip = sc.next().toLowerCase();

            if (ip.equals("exit")) break;

            Spot start = board.getSpot(ip.charAt(0), ip.charAt(1));
            ip = sc.next().toLowerCase();
            Spot end = board.getSpot(ip.charAt(0), ip.charAt(1));

            if (start != null && end != null && board.playMove(start, end, current_player)) {
                board.printBoard();
                current_player = current_player.equals(players[0]) ? players[1] : players[0];
            } else {
                System.out.println("Invalid move");
            }
        }

        status = Status.End;
        System.out.println("Game over!");
    }

    public Status getStatus() {
        return status;
    }
}
