class Solution {
    boolean vis[][];
    int m;
    int n;

    private boolean search(int i, int j, char[][] board, String word, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if (vis[i][j] || board[i][j] != word.charAt(k))
            return false;
        if (word.length() - 1 == k)
            return true;
        vis[i][j] = true;
        boolean down = search(i + 1, j, board, word, k + 1);
        boolean up = search(i - 1, j, board, word, k + 1);
        boolean left = search(i, j - 1, board, word, k + 1);
        boolean right = search(i, j + 1, board, word, k + 1);
        vis[i][j] = false;
        return down || up || left || right;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (search(r, c, board, word, 0))
                    return true;
        return false;
    }
}

class Solution_with_graph {
    int n;
    int m;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, char[][] board, String word, int idx) {
        if (board[x][y] != word.charAt(idx))
            return false;
        if (idx == word.length() - 1)
            return true;

        char temp = board[x][y];
        board[x][y] = '.';
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (Math.abs(i + j) == 1) {
                    int nx = x + i;
                    int ny = y + j;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (board[nx][ny] != '.') {
                            if (dfs(nx, ny, board, word, idx + 1)) {
                                board[x][y] = temp;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        board[x][y] = temp;
        return false;
    }
}