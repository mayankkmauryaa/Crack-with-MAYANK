class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board == null || board.length == 0)
            return 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int row, int col) {
        board[row][col] = 'R';
        for (int x = 0; x < 4; x++) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) == 1) {
                        int nr = row + i;
                        int ny = col + j;
                        if (nr >= 0 && nr < board.length && ny >= 0 && ny < board[0].length
                                && board[nr][ny] == 'X') {
                            dfs(board, nr, ny);
                        }
                    }
                }
            }
        }
    }
}