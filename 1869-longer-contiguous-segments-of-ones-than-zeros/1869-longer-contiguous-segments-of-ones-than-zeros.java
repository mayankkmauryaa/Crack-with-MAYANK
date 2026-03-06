class Solution {
    public boolean checkZeroOnes(String s) {
        int max1 = 0, max0 = 0;
        int count1 = 0, count0 = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
                count0 = 0;
                max1 = Math.max(max1, count1);
            } else {
                count0++;
                count1 = 0;
                max0 = Math.max(max0, count0);
            }
        }

        return max1 > max0;
    }
}