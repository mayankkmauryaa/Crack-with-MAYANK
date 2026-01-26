class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int x = 1;
        for (int num : nums) {
            xor ^= num;
            xor ^= x;
            x++;
        }
        return xor;
    }
}
