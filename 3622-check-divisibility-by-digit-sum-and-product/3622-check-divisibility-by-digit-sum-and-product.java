class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;
        while (n != 0) {
            int rem = n % 10;
            sum += rem;
            prod *= rem;
            n /= 10;
        }
        if (temp % (prod + sum) == 0)
            return true;
        return false;
    }
}