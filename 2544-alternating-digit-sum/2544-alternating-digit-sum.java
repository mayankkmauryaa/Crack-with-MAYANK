class Solution {
    public int alternateDigitSum(int n) {
        int digits = 0;
        int temp = n;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }
        int sum = 0;
        int sign = (digits & 1) == 0 ? -1 : 1;
        while (n != 0) {
            sum += (n % 10) * sign;
            sign *= -1;
            n /= 10;
        }
        return sum;
    }
}