import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players = new Player[2];
    private Player current_player;
    private Status status;
    private Spot start;
    private Spot end;

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
            System.out.print("\n" + (current_player.isWhite() ? "White" : "Black") + "'s Move : ");
            String ip = sc.next().toLowerCase();

            if (ip.equals("exit")) break;

            start = board.getBox(ip.charAt(0), ip.charAt(1));
            ip = sc.next().toLowerCase();
            end = board.getBox(ip.charAt(0), ip.charAt(1));

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
