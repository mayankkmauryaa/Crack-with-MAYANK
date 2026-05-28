class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        if (n <= k) return nums;
        int idx = 0;
        for (int num : nums)
            if (idx < k || num != nums[idx - k])
                nums[idx++] = num;
        return Arrays.copyOf(nums, idx);
    }
}