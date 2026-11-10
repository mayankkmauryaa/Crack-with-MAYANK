class Solution {
    int[] dp;

    public int climbStairs(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, costs);
    }

    int solve(int i, int n, int[] costs) {
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= 3; j++) {
            if (i + j <= n) {
                int cost = costs[i + j - 1] + j * j;
                ans = Math.min(ans, cost + solve(i + j, n, costs));
            }
        }
        return dp[i] = ans;
    }
}
