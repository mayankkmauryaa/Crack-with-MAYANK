class Solution {
    int n;
    int m;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(i, j, board, word, 0)) 
                    return true;
        return false;
    }

    public boolean dfs(int x, int y, char[][] board, String word, int idx) {
        if (board[x][y] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;

        char temp = board[x][y];
        board[x][y] = '.';
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++) 
                if (Math.abs(i + j) == 1) {
                    int nx = x + i;
                    int ny = y + j;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n)
                        if (board[nx][ny] != '.')
                            if (dfs(nx, ny, board, word, idx + 1)) {
                                board[x][y] = temp;
                                return true;
                            }
                }
        board[x][y] = temp;
        return false;
    }
}