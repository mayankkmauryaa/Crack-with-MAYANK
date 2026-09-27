class Solution {
    public String reverseParentheses(String s) {
        while (s.contains("(")) {
            int open = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') open = i;
                if (s.charAt(i) == ')') {
                    int close = i;
                    String inside = s.substring(open + 1, close);
                    String reversed = new StringBuilder(inside).reverse().toString();
                    s = s.substring(0, open) + reversed + s.substring(close + 1);
                    break;
                }
            }
        }
        return s;
    }
}