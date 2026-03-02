class Solution {
    List<List<String>> result;
    int[][] board;

    public int totalNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        solve(0, n);
        return result.size();
    }

    private void solve(int row, int n) {
        if (row == n) {
            result.add(construct(n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n)) {
                board[row][col] = 1;
                solve(row + 1, n);
                board[row][col] = 0; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, int n) {

        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private List<String> construct(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j] == 1 ? 'Q' : '.');
            }
            list.add(sb.toString());
        }

        return list;
    }
}
