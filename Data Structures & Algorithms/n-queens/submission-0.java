class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> bannedCols = new HashSet<>();
        Set<Integer> bannedPosDiag = new HashSet<>();
        Set<Integer> bannedNegDiag = new HashSet<>();

        List<List<String>> validBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) { // Fill all cell with '.'
            Arrays.fill(row, '.');
        }

        backtrack(board, n, 0, bannedCols, bannedPosDiag, bannedNegDiag, validBoards);
        return validBoards;
    }

    private void backtrack(
            char[][] board,
            int boardSize,
            int curRow,
            Set<Integer> bannedCols,
            Set<Integer> bannedPosDiag,
            Set<Integer> bannedNegDiag,
            List<List<String>> validBoards) {
        // When we place all the queens in each row
        if (curRow == boardSize) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            validBoards.add(copy);
            return;
        }

        for (int col = 0; col < boardSize; col++) {
            // Skip cell if that cell can be attacked by other queen
            if (bannedCols.contains(col)
                    || bannedPosDiag.contains(curRow + col)
                    || bannedNegDiag.contains(curRow - col)) {
                continue;
            }

            // Restrict cells where next queen cannot be placed
            bannedCols.add(col);
            bannedPosDiag.add(curRow + col);
            bannedNegDiag.add(curRow - col);
            board[curRow][col] = 'Q';

            backtrack(board, boardSize, curRow + 1, bannedCols, bannedPosDiag, bannedNegDiag, validBoards);

            // Release of restriction for backtracking
            bannedCols.remove(col);
            bannedPosDiag.remove(curRow + col);
            bannedNegDiag.remove(curRow - col);
            board[curRow][col] = '.';
        }
    }
}
