class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (x == 0 || x == 1)
            return x;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0)
            return 1.0;
        double ans = pow(x, n / 2);
        return n % 2 == 0 ? ans * ans : x * ans * ans;
    }
}