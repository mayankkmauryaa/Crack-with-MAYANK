// 238. Product of Array Except Self
class Solution {
    int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] p = new int[m][n];

        int prefix = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = prefix;
                prefix = (int) ((long) prefix * grid[i][j] % MOD);
            }
        }

        int suffix = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                p[i][j] = (int) ((long) p[i][j] * suffix % MOD);
                suffix = (int) ((long) suffix * grid[i][j] % MOD);
            }
        }

        return p;
    }
}