class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        // dp[0] = 0;
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (Math.abs(nums[j] - nums[i]) <= target && dp[j] != -1) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        // }
        // return dp[n - 1];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int num = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (dp[j] != -1 && dp[j] >= dp[i] && Math.abs(nums[j] - num) <= target){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[0];
    }
}