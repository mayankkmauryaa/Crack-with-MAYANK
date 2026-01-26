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


class Solution_maths {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = (n * (n - 1)) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return total - sum;
    }
}

class Solution_prefix {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i=0; i<nums.length; i++)  ans+=i-nums[i];
        return ans;
    }
}

