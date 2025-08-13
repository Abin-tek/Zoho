import java.util.Stack;

public class MoveHistory {
    private final Stack<Move> undoStack;
    private final Stack<Move> redoStack;

    public MoveHistory() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public Stack<Move> getUndoStack() {
        return undoStack;
    }

    public Board undo() {
        redoStack.add(undoStack.pop()); // to pop AI move

        Move undoMove = undoStack.pop();
        undoMove.printMove();
        System.out.print(" : UNDONE!\n");
        redoStack.add(undoMove);

        Move lastAiMove = undoStack.peek();
        lastAiMove.show();
        return lastAiMove.getBoard();
    }

    public Board redo() {
        Move redoMove = redoStack.pop();
        undoStack.add(redoMove);
        redoMove.printMove();
        System.out.print(" : REDONE!\n");

        undoStack.add(redoStack.pop());
        Move lastAiMove = undoStack.peek();
        lastAiMove.show();
        return lastAiMove.getBoard();
    }
}
