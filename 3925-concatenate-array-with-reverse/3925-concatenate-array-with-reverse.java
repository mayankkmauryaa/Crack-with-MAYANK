class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n + n];
        int k = (2 * n) - 1;
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[k] = nums[i];
            k--;
        }
        return ans;
    }
}