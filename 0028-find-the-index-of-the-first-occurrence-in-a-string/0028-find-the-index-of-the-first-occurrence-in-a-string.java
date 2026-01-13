class Solution {
    public int strStr(String s1, String s2) {
        int i = 0, j = 0;
        int start = 0;

        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                if (j == 0) start = i;
                i++;
                j++;
                if (j == s2.length()) return start;
            } 
            else {
                if(j>0) i = start + 1;
                else i++;
                j = 0;
            }
        }
        return -1;
    }
}



