class Solution {
    public long minOperations(int[] nums) {
        // wherever the current element is greater than the next element ; just count up that spike
        long ops = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            ops += Math.max(0, nums[i] - nums[i + 1]);
        }
        return ops;
    }
}