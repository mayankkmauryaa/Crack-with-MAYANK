class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        int sign = 1;
        int i = 0;
        int n = s.length();
        // Whitespace: Ignore any leading whitespace (" ").
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        // Reading digits until a non-digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Overflow check BEFORE multiplication
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }

        return (int) (sign * ans);

    }
}