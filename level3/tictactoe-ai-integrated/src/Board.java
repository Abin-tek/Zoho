public class Board implements Cloneable{
    private Cell[][] grid;

    public Board() {
        this.grid = new Cell[3][3];
        createBoard();
        printBoard();
    }

    @Override
    public Board clone() {
        try {
            Cell[][] newGrid = new Cell[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    newGrid[i][j] = getCell(calculateId(i, j)).clone();
                }
            }

            Board cloned = (Board) super.clone();
            cloned.grid = newGrid;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private boolean checkRight(char name) {
        for (int i = 0; i < 3; i++) {
            Player player = getCell(calculateId(i, 2 - i)).getPlayer();
            if (player == null || player.getName() != name)
                return false;
        }

        return true;
    }

    private boolean checkLeft(char name) {
        for (int i = 0; i < 3; i++) {
            Player player = getCell(calculateId(i, i)).getPlayer();
            if (player == null || player.getName() != name)
                return false;
        }

        return true;
    }

    private boolean checkDiagonals(char name) {
        return checkLeft(name) || checkRight(name);
    }

    private boolean checkCol(int col, char name) {
        for (int row = 0; row < 3; row++) {
            Player player = getCell(calculateId(row, col)).getPlayer();
            if (player == null || player.getName() != name)
                return false;
        }
        return true;
    }

    private boolean checkRow(int row, char name) {
        for (int col = 0; col < 3; col++) {
            Player player = getCell(calculateId(row, col)).getPlayer();
            if (player == null || player.getName() != name)
                return false;
        }
        return true;
    }

    protected boolean isWin(int id, Player player) {
        Cell cell = getCell(id);
        return checkRow(cell.getRow(), player.getName()) || checkCol(cell.getCol(), player.getName()) || checkDiagonals(player.getName());
    }

    protected boolean movePlayed(int id, Player player) {
        if (!isValid(id))
            return false;

        playMove(id, player);

        return true;
    }

    protected void playMove(int id, Player player) {
        Cell newCell = getCell(id).clone();
        newCell.setPlayer(player);
        setCell(newCell);
    }

    private void setCell(Cell newCell) {
        grid[newCell.getRow()][newCell.getCol()] = newCell;
    }

    protected boolean isValid(int id) {
        return id >= 1 && id <= 9 && getCell(id).getPlayer() == null;
    }

    public Cell getCell(int id) {
        id -= 1;
        return grid[id / 3][id % 3];
    }

    protected void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell cell = getCell(calculateId(i, j));
                if (cell.getPlayer() == null)
                    System.out.print(cell.getId());
                else
                    System.out.print(cell.getPlayer().getName());
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int calculateId(int i, int j) {
        return 3 * i + j + 1;
    }

    private void createBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Cell(calculateId(i, j), i, j);
            }
        }
    }
}
