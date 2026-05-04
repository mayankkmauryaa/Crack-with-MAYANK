class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev = reverse(n);
        int st = Math.min(n, rev);
        int end = Math.max(n, rev);
        int sum = 0;
        for (int i = st; i <= end; i++) {
            if (isPrime(i))
                sum += i;
        }
        return sum;
    }

    int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            int rem = n % 10;
            n /= 10;
            rev = rev * 10 + rem;
        }
        return rev;
    }

    boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}