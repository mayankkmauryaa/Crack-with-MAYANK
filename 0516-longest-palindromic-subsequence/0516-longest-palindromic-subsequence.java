class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        return longestCommonSubsequence(s, rev);

        // char[] str1 = s.toCharArray();
        // char[] str2 = rev.toCharArray();

        // int n = str1.length;

        // int[][] dp = new int[n + 1][n + 1];

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if (str1[i - 1] == str2[j - 1]) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         } else {
        //             dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        //         }
        //     }
        // }
        // return dp[n][n];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int n = text2.length();
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1[i - 1] == str2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}