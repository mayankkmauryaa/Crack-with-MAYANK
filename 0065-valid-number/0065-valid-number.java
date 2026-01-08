class Solution {
    public boolean isNumber(String s) {
        boolean digit = false;
        boolean dot = false;
        boolean exp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digit = true;
            } 
            else if (c == '+' || c == '-') {
                // sign only at start or after e/E
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } 
            else if (c == '.') {
                // dot only once and not after e
                if (dot || exp)
                    return false;
                dot = true;
            } 
            else if (c == 'e' || c == 'E') {
                // e must come after digit and only once
                if (exp || !digit)
                    return false;
                exp = true;
                digit = false; // reset → must have digits after e
            } 
            else {
                return false;
            }
        }

        return digit;
    }
}
