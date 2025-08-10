public class Board {
    private Cell[][] grid;

    public Board() {
        this.grid = new Cell[3][3];
        createBoard();
        printBoard();
    }

    public Cell getCell(int position) {
        position -= 1;
        return grid[position / 3][position % 3];
    }

    public void setCell(int id, int row, int col) {
        grid[row][col] = new Cell(id, row, col);
    }

    private void createBoard() {
        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                setCell(counter++, i, j);
            }
        }
    }

    private void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell cell = grid[i][j];
                if (cell.getPiece() == null) System.out.print(cell.getId());
                else System.out.print(cell.getPiece().getName());
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    protected void placePiece(int position, char player) {
        position -= 1;
        int row = position / 3;
        int col = position % 3;
        grid[row][col].setPiece(player == 'X' ? new X() : new O());
        printBoard();
    }

    protected boolean isWin(char name, int position) {
        position -= 1;
        int row = position / 3;
        int col = position % 3;

        if (checkRow(name, row) || checkCol(name, col) || checkDiad(name))
            return true;

        return false;
    }

    private boolean checkDiad(char name) {
        if (chechRight(name) || checLeft(name))
            return true;

        return false;
    }

    private boolean checLeft(char name) {
        for (int i = 0; i < 3; i++) {
            Piece piece = grid[i][i].getPiece();
            if (piece == null || piece.getName() != name)
                return false;
        }

        return true;
    }

    private boolean chechRight(char name) {
        for (int i = 0; i < 3; i++) {
            Piece piece = grid[i][2-i].getPiece();
            if (piece == null || piece.getName() != name)
                return false;
        }

        return true;
    }

    private boolean checkCol(char name, int col) {
        for (int i = 0; i < 3; i++) {
            Piece piece = grid[i][col].getPiece();
            if (piece == null || piece.getName() != name)
                return false;
        }

        return true;
    }

    private boolean checkRow(char name, int row) {
        for (int i = 0; i < 3; i++) {
            Piece piece = grid[row][i].getPiece();
            if (piece == null || piece.getName() != name)
                return false;
        }

        return true;
    }


    protected boolean isValid(int ip) {
        return ip >= 1 && ip <= 9 && getCell(ip).getPiece() == null;
    }
}
