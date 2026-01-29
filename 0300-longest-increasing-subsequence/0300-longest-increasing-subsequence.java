class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

class Solution_Recursion {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int index, int prevIndex) {
        if (index == nums.length)
            return 0;

        // skip current element
        int notTake = dfs(nums, index + 1, prevIndex);

        // take current element if increasing
        int take = 0;

        // max(dfs(index + 1, prevIndex),
        //     1 + dfs(index + 1, index))   // if valid

        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + dfs(nums, index + 1, index);
        }

        return Math.max(take, notTake);
    }
}
