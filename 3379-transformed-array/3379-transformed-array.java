class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = nums[(i + nums[i] % n + n) % n];
        }
        return ans;
    }
}
// Module on nums[i] to make it small.
// nums[i] % n + n to make it positive.