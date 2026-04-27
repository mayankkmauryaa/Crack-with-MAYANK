class Solution {
    int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return maximumMoney(nums, 0);
    }

    public int maximumMoney(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx] != -1)
            return dp[idx];
        int pick = nums[idx] + maximumMoney(nums, idx + 2);
        int notpick = maximumMoney(nums, idx + 1);

        return dp[idx] = Math.max(pick, notpick);
    }
}