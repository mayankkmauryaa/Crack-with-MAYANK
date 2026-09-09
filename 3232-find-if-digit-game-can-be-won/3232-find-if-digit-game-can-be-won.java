class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum_s = 0;
        int sum_d = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 10) sum_s += nums[i];
            else sum_d += nums[i];
        }
        return sum_s != sum_d;
    }
}