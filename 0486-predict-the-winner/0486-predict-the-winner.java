class Solution {
    int[][] memo;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                memo[i][j] = -1;
        return solve(0, n - 1, nums) >= 0;
    }

    private int solve(int i, int j, int[] nums) {
        if (i == j) return nums[i];
        if (memo[i][j] != -1) return memo[i][j];
        int left = nums[i] - solve(i + 1, j, nums);
        int right = nums[j] - solve(i, j - 1, nums);
        return memo[i][j] = Math.max(left, right);
    }
}