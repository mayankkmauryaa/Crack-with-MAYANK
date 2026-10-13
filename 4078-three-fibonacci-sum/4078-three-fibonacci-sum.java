class Solution {
    public boolean threeFibonacciSum(int n) {
        if (n % 2 != 0) return false;
        int target = n / 2;
        long a = 1, b = 1;

        if (target == a) return true;

        while (b < target) {
            long c = a + b;
            a = b;
            b = c;
            if (b == target) return true;
        }
        return false;
    }
}