class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long count = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 2 && s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b' && s.charAt(i) == 'c') {
                left = i - 1;
            }
            count += i - left + 1;
        }
        return count;
    }
}