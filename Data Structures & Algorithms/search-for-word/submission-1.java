class Solution {
    public boolean exist(char[][] board, String word) {
        int numOfRows = board.length;
        int numOfCols = board[0].length;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, word, 0, row, col, numOfRows, numOfCols)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(
            char[][] board,
            String word,
            int idx,
            int row,
            int col,
            int numOfRows,
            int numOfCols) {
        // Passing all the tests below means the cell shows char what we are looking for.
        if (row < 0
                || row >= numOfRows
                || col < 0
                || col >= numOfCols
                || board[row][col] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        // Change char at current cell not to visit here again
        board[row][col] = '#';

        if (backtrack(board, word, idx + 1, row - 1, col, numOfRows, numOfCols)
                || backtrack(board, word, idx + 1, row + 1, col, numOfRows, numOfCols)
                || backtrack(board, word, idx + 1, row, col + 1, numOfRows, numOfCols)
                || backtrack(board, word, idx + 1, row, col - 1, numOfRows, numOfCols)) {
            return true;
        }

        // Restore original char at current cell for other backtracking
        board[row][col] = word.charAt(idx);

        return false;
    }
}
