class Solution {
   public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_map<int, unordered_set<char>> rows, cols;
        map<pair<int, int>, unordered_set<char>> squares;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char digit = board[r][c];
                if (digit == '.') continue;
                if (rows[r].contains(digit) || cols[c].contains(digit) ||
                    squares[{r / 3, c / 3}].contains(digit)) {
                    return false;
                }
                rows[r].insert(digit);
                cols[c].insert(digit);
                squares[{r / 3, c / 3}].insert(digit);
            }
        }
        return true;
    }
};
