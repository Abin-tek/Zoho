import java.util.Scanner;
import java.util.Stack;

public class Game {
    private final Scanner sc;
    private Board board;
    private final X playerX;
    private final O playerO;
    private Player currPlayer;
    private final Player firstPlayer;
    private final Stack<Move> undoStack;
    private final Stack<Move> redoStack;
    private Move move;
    private int count;

    public Game() {
        System.out.println("Game Started...");

        this.sc = new Scanner(System.in);
        this.playerX = new X();
        this.playerO = new O();

        System.out.print("X or O ? : ");
        char c = sc.next().toUpperCase().charAt(0);
        this.firstPlayer = c == 'X' ? playerX : playerO;
        this.currPlayer = playerX;

        this.board = new Board();

        this.undoStack = new Stack<>();
        this.move = new Move(0, 0, board, null);
        undoStack.add(move);
        this.redoStack = new Stack<>();
        count = 1;
    }

    public void start() {
        while (true) {
            int id = getMove();

            if (board.movePlayed(id, currPlayer)) {
                move = new Move(count, id, board.clone(), currPlayer);
                undoStack.add(move);
                move.show();

                if (board.isWin(id, currPlayer)) {
                    System.out.println(currPlayer.getName() + " Won!");
                    break;
                }
                if (count == 9) {
                    System.out.println("Match Draw!");
                    break;
                }

                currPlayer = togglePlayer(currPlayer);
                count++;
            }
        }

        System.out.println("Game over...");
    }

    private int getMove() {
        System.out.print("Move " + count + ", " + currPlayer.getName() + " turn: ");

        if (currPlayer.equals(firstPlayer)) {
            char ip = sc.next().toUpperCase().charAt(0);

            if (Character.isDigit(ip))
                return ip - '0';

            switch (ip) {
                case 'U':
                    undo();
                    break;
                case 'R':
                    redo();
                    break;
            }

            return getMove();
        } else
            return playAI();
    }

    private void redo() {
        Move redoMove = redoStack.pop();
        undoStack.add(redoMove);
        redoMove.printMove();
        System.out.print(" : REDONE!\n");

        undoStack.add(redoStack.pop());
        Move lastAiMove = undoStack.peek();
        this.board = lastAiMove.getBoard();
        count += 2;
        lastAiMove.show();
    }

    private void undo() {
        redoStack.add(undoStack.pop()); // to pop AI move

        Move undoMove = undoStack.pop();
        undoMove.printMove();
        System.out.print(" : UNDONE!\n");
        redoStack.add(undoMove);

        Move lastAiMove = undoStack.peek();
        this.board = lastAiMove.getBoard();
        count -= 2;
        lastAiMove.show();
    }

    private int playAI() {
        State state = new State(board.clone(), currPlayer, false, count - 1, Integer.MAX_VALUE, 0, false);
        State res = miniMax(state);
        System.out.print(res.getId());

        return res.getId();
    }

    private State miniMax(State state) {
        if (state.isTerminal())
            return state;

        if (state.isMax()) {
            State max = state.clone();
            max.setValue(Integer.MIN_VALUE);
            int score = 0;
            for (int i = 1; i <= 9; i++) {
                if (state.getBoard().isValid(i)) {
                    State curr = state.clone();
                    curr.getBoard().playMove(i, curr.getCurrPlayer());
                    curr.setDepth(curr.getDepth() + 1);
                    curr.setId(i);
                    curr.result();

                    curr.setCurrPlayer(togglePlayer(curr.getCurrPlayer()));
                    curr.setMax(!curr.isMax());

                    max = max.Max(miniMax(curr));
                    score += max.getValue();
                }
            }

            max.setValue(score);
            return max;

        } else {
            State min = state.clone();
            min.setValue(Integer.MAX_VALUE);
            int score = 0;
            for (int i = 1; i <= 9; i++) {
                if (state.getBoard().isValid(i)) {
                    State curr = state.clone();
                    curr.getBoard().playMove(i, curr.getCurrPlayer());
                    curr.setDepth(state.getDepth() + 1);
                    curr.setId(i);
                    curr.result();

                    curr.setMax(!curr.isMax());
                    curr.setCurrPlayer(togglePlayer(curr.getCurrPlayer()));

                    min = min.Min(miniMax(curr));
                    score += min.getValue();
                }
            }

            min.setValue(score);
            return min;

        }
    }

    private Player togglePlayer(Player player) {
        return player.equals(playerX) ? playerO : playerX;
    }
}
