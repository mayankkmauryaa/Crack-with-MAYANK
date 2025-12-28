class Solution {
    public int maximumCount(int[] nums) {
        int negative = search(nums, 0);
        int positive = search(nums, 1);
        return Math.max(negative, nums.length - positive);
    }

    private int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}
