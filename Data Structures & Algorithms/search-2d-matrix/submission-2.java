class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = ((bot - top) / 2) + top;
            if (matrix[row][COLS - 1] < target) {
                top = row + 1;
            } else if (matrix[row][0] > target) {
                bot = row - 1;
            } else {
                break;
            }
        }

        // if (!(top <= bot)) {
        //     return false;
        // }

        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = ((r - l) / 2) + l;
            if (matrix[row][m] < target) {
                l = m + 1;
            } else if (matrix[row][m] > target) {
                r = m - 1; // Corrected update for r
            } else {
                return true;
            }
        }

        return false;
    }
}