package solvedArchive.RecursionBacktracking;

public class NKnights {
    public static void main(String[] args) {

    }

    // nKnights problem
    static void nKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            return;
        }

        if (row == board.length - 1 && col == board.length)   return;


        if (col == board.length) {
            nKnights(board, row + 1, 0, knights);
            return;
        }

        if (isSafeNKnights(board, row, col)) {
            board[row][col] = true;
            nKnights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        nKnights(board, row, col + 1, knights);
    }

    //isSafe for nKnights
    static boolean isSafeNKnights(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // is valid for nKnights
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
