class Solution {
    public int alternatingSum(int[] nums) {
        boolean flag = true;
        int sum = 0;
        for (int n : nums) {
            if (flag) sum += n;
            else sum -= n;
            flag = !flag;
        }
        return sum;

    }
}