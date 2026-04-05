class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char dir : moves.toCharArray()) {
            if (dir == 'L') x++;
            if (dir == 'R') x--;
            if (dir == 'D') y++;
            if (dir == 'U') y--;
        }
        return x == 0 && y == 0;
    }
}
