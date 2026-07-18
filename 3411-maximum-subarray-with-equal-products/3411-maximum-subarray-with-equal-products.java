class Solution {
    public int maxLength(int[] nums) {
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int gcd = nums[i];
                int lcm = 1;
                int product = 1;
                for (int k = i; k <= j; k++) {
                    gcd = gcd(nums[k], gcd);
                    lcm = lcm(nums[k], lcm);
                    product *= nums[k];
                }
                if (product == (lcm * gcd)) {
                    int max = (j - i + 1);
                    ans = Math.max(ans, max);
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}