class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        return subsetSum(nums, sum / 2, nums.length);
    }

    public boolean subsetSum(int[] arr, int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // Sum 0 is always possible
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        // Positive sum with 0 elements is impossible
        for (int j = 1; j <= sum; j++)
            dp[0][j] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}