class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int inc = i - 1;
        while (i < n && nums[i - 1] > nums[i]) {
            i++;
        }
        int dec = i - 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int flag = i - 1;
        return (inc != 0) && (dec != inc) && (flag == n - 1 && flag != dec);
    }
}