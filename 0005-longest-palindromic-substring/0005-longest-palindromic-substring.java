class Solution {
    int start = 0;
    int maxLen = 1;
    boolean dp[][];

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;
        if (dp[i][j]) return false;
        if (s.charAt(i) != s.charAt(j)) return false;
        return dp[i][j] = isPalindrome(s, i + 1, j - 1);
    }
}