class Solution {
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i += 2) {
            int second = nums[i + 1];
            int digits = String.valueOf(second).length();
            int merged = nums[i] * (int) Math.pow(10, digits) + second;
            ans = Math.min(ans, merged);
        }
        return ans;
    }
}