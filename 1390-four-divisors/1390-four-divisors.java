class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            int count = 0;
            int sum = 0;
            // Iterate i from 1 to sqrt(n)
            // Avoids double counting
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    // If i * i == n, it contributes one divisor
                    if (i * i == n) {   
                        count++;
                        sum += i;
                    } 
                    // it contributes two divisors: i and n / i
                    else {
                        count += 2;
                        sum += i + n / i;
                    }
                    if (count > 4) {
                        break;
                    }
                }
            }
            ans += count == 4 ? sum : 0;
        }
        return ans;
    }
}