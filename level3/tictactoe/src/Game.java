import java.util.Scanner;

public class Game {
    private Board board;
    private Scanner sc;
    private char curPlayer;

    public Game() {
        System.out.println("Game started...");
        this.board =  new Board();
        this.sc = new Scanner(System.in);
        this.curPlayer = 'X';
    }

    public void start(){
        int move = 9;

        while (true) {
            System.out.print("\n" + curPlayer + " turn : ");
            int ip = sc.nextInt();

            if (!board.isValid(ip))
                continue;

            board.placePiece(ip, curPlayer);
            move--;

            if (board.isWin(curPlayer, ip)) {
                System.out.println("\n" + curPlayer + " is the Winner...");
                break;
            }

            if (move == 0) {
                System.out.println("\nMatch Draw..." );
                break;
            }

            curPlayer = curPlayer == 'X' ? 'O' : 'X';
        }

        System.out.println("\nGame over...");
    }
}
