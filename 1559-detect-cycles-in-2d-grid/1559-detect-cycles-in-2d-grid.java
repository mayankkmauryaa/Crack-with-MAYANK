class Solution {
    boolean[][] vis;
    int m;
    int n;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!vis[i][j] && dfs(i, j, -1, -1, grid))
                    return true;
        return false;
    }

    private boolean dfs(int r, int c, int pr, int pc, char[][] grid) {
        vis[r][c] = true;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if (Math.abs(i + j) == 1) {
                    int nr = r + i;
                    int nc = c + j;
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n)
                        if (nr != pr || nc != pc)
                            if (grid[nr][nc] == grid[r][c])
                                if (vis[nr][nc] || dfs(nr, nc, r, c, grid))
                                    return true;
                }
        return false;
    }
}