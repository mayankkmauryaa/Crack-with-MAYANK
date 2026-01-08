class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        long ans = 0;

        while (left <= right) {
            ans = left * left + right * right;

            if (ans == c)
                return true;

            else if (ans < c)
                left++;

            else
                right--;
        }

        return false;
    }
}