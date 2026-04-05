class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int s = 0;
        int n = moves.length();
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') l++;
            else if (ch == 'R') r++;
            else s++;
        }
        if (l > r) return l - r + s;
        return r - l + s;
    }
}