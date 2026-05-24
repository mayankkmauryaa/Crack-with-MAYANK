class Solution {
    public int minimumSwaps(int[] nums) {
        int zeros = 0;
        int swaps = 0;
        for (int num : nums) {
            if (num == 0) zeros++;
        }
        for (int i = nums.length - 1; i >= 0 && zeros > 0; i--) {
            if (zeros == 0) break;
            if (nums[i] != 0) swaps++;
            zeros--;
        }
        return swaps;
    }
}