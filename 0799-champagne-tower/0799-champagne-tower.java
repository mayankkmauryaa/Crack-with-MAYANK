class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // 0 <= query_glass <= query_row < 100
        double[][] dp = new double[101][101];
        dp[0][0] = (double) poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1.0) {
                    double overflow = (dp[i][j] - 1.0) / 2.0;
                    dp[i][j] = 1.0;
                    dp[i + 1][j] += overflow;
                    dp[i + 1][j + 1] += overflow;
                }
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }
}