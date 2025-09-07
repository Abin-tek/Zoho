public class Game {
    private final X playerX;
    private final O playerO;
    private Player currPlayer;
    private final Player human;
    private final MoveHistory moveHistory;
    private Board board;
    private Move move;
    private final AI ai;
    private static final int max_depth = 10;

    public Game() {
        System.out.println("Game Started...");
        System.out.print("X or O ? : ");
        char c = InputHandler.getUserInput();

        playerX = new X(c != 'X');  // X will be default maximizer
        playerO = new O(c == 'X');
        currPlayer = playerX;
        human = playerO.isMax() ? playerX : playerO;

        moveHistory = new MoveHistory();
        board = new Board();
        move = new Move(0, 0, board, null);
        moveHistory.getUndoStack().add(move);
        ai = new AI(this);
    }

    public void start() {
        while (board.getDepth() < max_depth) {
            int id = getMove();

            if (board.movePlayed(id, currPlayer)) {
                move = new Move(board.getDepth(), id, board.clone(), currPlayer);
                moveHistory.getUndoStack().add(move);
                move.show();

                if (board.isWin(id, currPlayer)) {
                    System.out.println(currPlayer.getName() + " Won!");
                    break;
                }

                currPlayer = togglePlayer(currPlayer);
                board.setDepth(board.getDepth()+1);
            }
        }

        if (board.getDepth() == max_depth) System.out.println("Match Draw!");
        System.out.println("Game over...");
    }

    private int getMove() {
        if (currPlayer.equals(human)) {
            System.out.print("Move " + board.getDepth() + ", " + currPlayer.getName() + " turn: ");
            char ip = InputHandler.getUserInput();

            if (Character.isDigit(ip)) return ip - '0';

            switch (ip) {
                case 'U':
                    board = moveHistory.undo();
                    break;
                case 'R':
                    board = moveHistory.redo();
                    break;
            }

            return getMove();
        } else return ai.play(board, currPlayer);
    }

    protected Player togglePlayer(Player player) {
        return player.equals(playerX) ? playerO : playerX;
    }
}