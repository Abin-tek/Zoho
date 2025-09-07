public class Board implements Cloneable {
    private Cell[][] grid;
    private int depth;
    private static final int n = 3;

    public Board() {
        depth = 1;
        grid = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Cell(n * i + j + 1, i, j);
            }
        }
        printBoard();
    }

    @Override
    public Board clone() {
        try {
            Cell[][] newGrid = new Cell[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newGrid[i][j] = grid[i][j].clone();
                }
            }
            Board cloned = (Board) super.clone();
            cloned.grid = newGrid;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private boolean checkDiagonals(char name) {
        boolean left = true;
        boolean right = true;
        for (int i = 0; i < n; i++) {
            Player leftPlayer = grid[i][i].getPlayer();
            Player rightPlayer = grid[i][n - i - 1].getPlayer();
            if (left && (leftPlayer == null || leftPlayer.getName() != name)) left = false;
            if (right && (rightPlayer == null || rightPlayer.getName() != name)) right = false;
        }
        return left || right;
    }

    private boolean checkRowCol(int row, int col, char name) {
        boolean rowWin = true;
        boolean colWin = true;
        for (int i = 0; i < n; i++) {
            Player rowPlayer = grid[row][i].getPlayer();
            Player colPlayer = grid[i][col].getPlayer();
            if (rowWin && (rowPlayer == null || rowPlayer.getName() != name)) rowWin = false;
            if (colWin && (colPlayer == null || colPlayer.getName() != name)) colWin = false;
        }
        return rowWin || colWin;
    }

    protected boolean isWin(int id, Player player) {
        Cell cell = getCell(id);
        return checkRowCol(cell.getRow(), cell.getCol(), player.getName()) || checkDiagonals(player.getName());
    }

    protected boolean movePlayed(int id, Player player) {
        if (!isValid(id)) return false;
        playMove(id, player);
        return true;
    }

    protected void playMove(int id, Player player) {
        getCell(id).setPlayer(player);
    }

    protected boolean isValid(int id) {
        return id >= 1 && id <= (n * n) && getCell(id).getPlayer() == null;
    }

    public Cell getCell(int id) {
        id -= 1;
        return grid[id / n][id % n];
    }

    protected void printBoard() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Cell cell = grid[i][j];
                if (cell.getPlayer() == null) System.out.print(cell.getId());
                else System.out.print(cell.getPlayer().getName());
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}