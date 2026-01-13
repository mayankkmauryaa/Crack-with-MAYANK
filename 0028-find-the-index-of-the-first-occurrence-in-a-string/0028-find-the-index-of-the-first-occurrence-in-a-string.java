class Solution {
    public int strStr(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() == s2.length() && s1.charAt(0) != s2.charAt(0))
            return -1;

        int i = 0, j = 0;
        int start = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                if (j == 0)
                    start = i;
                i++;
                j++;
                if (j == s2.length())
                    return start;
            } else {
                if (j > 0)
                    i = start + 1;
                else
                    i++;
                j = 0;
            }
        }
        return -1;
    }
}
