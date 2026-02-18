// Let:
// P = sum of elements assigned +
// N = sum of elements assigned -

// totalSum = sum(nums)

// We know:
// P - N = target
// P + N = totalSum


// Add both equations:
// 2P = totalSum + target
// P = (totalSum + target) / 2


// So the problem becomes:
// Count subsets whose sum = (totalSum + target) / 2

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
            
        // Edge cases
        if (Math.abs(target) > sum) return 0;
        
        if ((sum + target) % 2 != 0) return 0;
        int s1 = (sum + target) / 2;

        return count_of_Subset_with_a_given_Target(nums, s1);
    }

    private int count_of_Subset_with_a_given_Target(int[] arr, int target) {
        int n = arr.length;
        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                dp[i][j] = dp[i - 1][j];

                if (arr[i - 1] <= j)
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
            }
        }
        return dp[n][target];
    }
}
