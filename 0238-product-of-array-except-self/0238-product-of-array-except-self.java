class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int st = 1;
        int end = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = st;
            st *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= end;
            end *= nums[i];
        }
        return ans;
    }
}