class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int len = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;
            int max_freq = 0;
            for (int j = i; j < n; j++) {
                int val = s.charAt(j) - 'a';
                freq[val]++;
                if (freq[val] == 1)
                    distinct++;
                max_freq = Math.max(max_freq, freq[val]);
                if (max_freq * distinct == j - i + 1) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}