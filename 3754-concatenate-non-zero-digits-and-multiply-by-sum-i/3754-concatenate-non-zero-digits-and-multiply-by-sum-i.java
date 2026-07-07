class Solution {
    public long sumAndMultiply(int n) {
        int temp = n;
        long sum = 0;

        long x = 0;

        while (n > 0) {
            int rem = n % 10;
            n /= 10;
            if (rem != 0) {
                x = x * 10 + rem;
                sum += rem;
            }
        }

        long ans = 0;
        while (x > 0) {
            ans = ans * 10 + (x%10);
            x /= 10;
        }

        return ans * sum;

    }
}