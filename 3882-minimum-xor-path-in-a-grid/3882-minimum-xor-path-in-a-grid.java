class Solution {
    int ans;
    boolean[][][] memo;
    int m, n;
    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        ans = Integer.MAX_VALUE;
        memo = new boolean[m][n][1024];
        dfs(grid, 0, 0, 0);
        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int xor) {
        xor ^= grid[i][j];
        if (ans == 0) return;
        if (memo[i][j][xor]) return;
        memo[i][j][xor] = true;
        if (i == m - 1 && j == n - 1) {
            ans = Math.min(ans, xor);
            return;
        }
        if (i + 1 < m) dfs(grid, i + 1, j, xor);
        if (j + 1 < n) dfs(grid, i, j + 1, xor);
    }
}