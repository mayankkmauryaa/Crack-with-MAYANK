class Solution_brute {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                max = Math.max((nums[i] - 1) * (nums[j] - 1), max);
        return max;
    }
}

class Solution_better {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 1;
        int max2 = 1;
        for (int ele : nums) {
            if (max1 <= ele) {
                max2 = max1;
                max1 = ele;
            } else if (max2 <= ele) max2 = ele;
        }
        return (max1 - 1) * (max2 - 1);
    }
}