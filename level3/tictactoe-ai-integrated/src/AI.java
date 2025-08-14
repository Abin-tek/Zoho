public class AI {
    private final Game game;

    public AI(Game game) {
        this.game = game;
    }

    protected int play(Board board, Player currPlayer) {
        State state = new State(board.clone(), currPlayer, currPlayer.isMax(), board.getDepth(), Integer.MIN_VALUE, 0, false);
        return alphaBeta(state, Integer.MIN_VALUE, Integer.MAX_VALUE).getId();
    }

    private State alphaBeta(State state, int alpha, int beta) {
        if (state.isTerminal()) return state;

        if (state.isMax()) {
            State max = null;
            for (int i = 1; i <= 9; i++) {
                if (state.getBoard().isValid(i)) {
                    State curr = state.clone();
                    curr.evaluate(i, game::togglePlayer);
                    State res = alphaBeta(curr, alpha, beta);
                    if (max == null || max.compare(res)) {
                        curr.setValue(res.getValue());
                        max = curr;
                        alpha = res.getValue();
                    }
                }
                if (alpha >= beta)
                    break;
            }

            return max;
        } else {
            State min = null;
            for (int i = 1; i <= 9; i++) {
                if (state.getBoard().isValid(i)) {
                    State curr = state.clone();
                    curr.evaluate(i, game::togglePlayer);
                    State res = alphaBeta(curr, alpha, beta);
                    if (min == null || res.compare(min)) {
                        curr.setValue(res.getValue());
                        min = curr;
                        beta = res.getValue();
                    }
                }
                if (alpha >= beta)
                    break;
            }

            return min;
        }
    }
}