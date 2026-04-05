class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        int n = moves.length();
        for (int i = 0; i < n; i++) {
            char dir = moves.charAt(i);

            if (dir == 'U') y++;
            if (dir == 'D') y--;
            if (dir == 'R') x++;
            if (dir == 'L') x--;
        }

        return x == 0 && y == 0;
    }
}