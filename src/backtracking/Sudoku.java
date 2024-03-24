package backtracking;

public class Sudoku {

    public static boolean sudokuSolver(int[][] board, int row, int col) {
        if (row == 9) return true; // sudoku is filled
        if (col == 9) return sudokuSolver(board, row + 1, 0); // move to the next row
        // if current place is already filled move to the next cell
        if (board[row][col] != 0) return sudokuSolver(board, row, col + 1);

        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = i;
                if (sudokuSolver(board, row, col + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false; // num should not present in that row
            if (board[i][col] == num) return false; // num should not present in that col
        }
        int gridRow = row / 3;
        int gridCol = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cellRow = 3 * gridRow + i;
                int cellCol = 3 * gridCol + j;
                if (board[cellRow][cellCol] == num) return false; // num should not present in that grid
            }
        }
        return true;
    }

    public static boolean sudokuSolver(char[][] board, int row, int col) {
        if (row == 9) return true; // sudoku is filled
        if (col == 9) return sudokuSolver(board, row + 1, 0); // move to the next row
        // if current place is already filled move to the next cell
        if (board[row][col] != '.') return sudokuSolver(board, row, col + 1);

        for (char c = '1'; c <= '9'; c++) {
            if (isSafe(board, row, col, c)) {
                board[row][col] = c;
                if (sudokuSolver(board, row, col + 1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false; // num should not present in that row
            if (board[i][col] == num) return false; // num should not present in that col
        }
        int gridRow = row / 3;
        int gridCol = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cellRow = 3 * gridRow + i;
                int cellCol = 3 * gridCol + j;
                if (board[cellRow][cellCol] == num) return false; // num should not present in that grid
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        sudokuSolver(board, 0, 0);

        for (int[] a : board) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------------");

        char[][] charBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        sudokuSolver(charBoard, 0, 0);

        for (char[] row : charBoard) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
