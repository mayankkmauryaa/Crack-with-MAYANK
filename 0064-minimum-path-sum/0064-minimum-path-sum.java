class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    ans[j] = grid[i][j];
                } else {
                    int top = (i > 0) ? ans[j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? ans[j - 1] : Integer.MAX_VALUE;
                    ans[j] = Math.min(top, left) + grid[i][j];
                }
            }
        }
        return ans[m - 1];
    }
}