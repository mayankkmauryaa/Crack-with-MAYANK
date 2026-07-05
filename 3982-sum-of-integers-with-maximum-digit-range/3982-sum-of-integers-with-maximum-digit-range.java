class Solution {
    public int maxDigitRange(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(range(num), max);
        }
        int ans = 0;
        for (int num : nums) {
            if (range(num) == max)
                ans += num;
        }
        return ans;
    }

    public int range(int num) {
        int min = 9;
        int max = 0;
        while (num > 0) {
            int rem = num % 10;
            min = Math.min(min, rem);
            max = Math.max(max, rem);
            num /= 10;
        }
        return Math.abs(max - min);
    }
}
