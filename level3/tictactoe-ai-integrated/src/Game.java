import java.util.Scanner;

public class Game {
    private final Scanner sc;
    private final X playerX;
    private final O playerO;
    private Player currPlayer;
    private final Player human;
    private final UndoRedo undoRedo;
    private Board board;
    private Move move;
    private int count;

    public Game() {
        System.out.println("Game Started...");
        System.out.print("X or O ? : ");
        sc = new Scanner(System.in);
        char c = sc.next().toUpperCase().charAt(0);

        playerX = new X(c == 'O');
        playerO = new O(c == 'X');
        currPlayer = playerX;
        human = playerO.isMax() ? playerX : playerO;

        undoRedo = new UndoRedo();
        move = new Move(0, 0, board, null);
        undoRedo.getUndoStack().add(move);
        this.count = 1;
        board = new Board();
    }

    public void start() {
        while (count < 10) {
            int id = getMove();

            if (board.movePlayed(id, currPlayer)) {
                move = new Move(count, id, board.clone(), currPlayer);
                undoRedo.getUndoStack().add(move);
                move.show();

                if (board.isWin(id, currPlayer)) {
                    System.out.println(currPlayer.getName() + " Won!");
                    break;
                }

                currPlayer = togglePlayer();
                count++;
            }
        }

        if (count == 10)
            System.out.println("Match Draw!");
        System.out.println("Game over...");
        sc.close();
    }

    private int getMove() {
        System.out.print("Move " + count + ", " + currPlayer.getName() + " turn: ");

        if (currPlayer.equals(human)) {
            char ip = sc.next().toUpperCase().charAt(0);

            if (Character.isDigit(ip))
                return ip - '0';

            switch (ip) {
                case 'U':
                    board = undoRedo.undo();
                    count -= 2;
                    break;
                case 'R':
                    board = undoRedo.redo();
                    count += 2;
                    break;
            }

            return getMove();
        } else
            return playAI();
    }

    private int playAI() {
        State state = new State(board.clone(), currPlayer, currPlayer.isMax(), count, Integer.MIN_VALUE, 0, false);
        return miniMax(state).getId();
    }

    private State miniMax(State state) {
        if (state.isTerminal())
            return state;

        if (state.isMax()) {
            State max = state.clone();
            max.setValue(Integer.MIN_VALUE);
            for (int i = 1; i <= 9; i++) {
                if (state.getBoard().isValid(i)) {
                    State curr = state.clone();

                    curr.evaluate(i, this::togglePlayer);

                    State res = miniMax(curr);
                    if (max.Max(res)) {
                        curr.setValue(res.getValue());
                        max = curr;
                    }
                }
            }

            return max;
        } else {
            State min = state.clone();
            min.setValue(Integer.MAX_VALUE);
            for (int i = 1; i <= 9; i++) {
                if (state.getBoard().isValid(i)) {
                    State curr = state.clone();

                    curr.evaluate(i, this::togglePlayer);

                    State res = miniMax(curr);
                    if (min.Min(res)) {
                        curr.setValue(res.getValue());
                        min = curr;
                    }
                }
            }

            return min;
        }
    }

    private Player togglePlayer() {
        return currPlayer.equals(playerX) ? playerO : playerX;
    }
}
