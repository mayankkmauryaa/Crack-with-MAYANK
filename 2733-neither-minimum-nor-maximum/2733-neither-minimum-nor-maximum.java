class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3)
            return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        for (int n : nums)
            if (n != min && n != max)
                return n;

        return -1;
    }
}
