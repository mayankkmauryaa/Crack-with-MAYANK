class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();

        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            int count = 0;
            int y = startPos[0];
            int x = startPos[1];

            for (int j = i; j < m; j++) {
                char ch = s.charAt(j);
                if (ch == 'L') x--;
                if (ch == 'R') x++;
                if (ch == 'U') y--;
                if (ch == 'D') y++;

                if (y < 0 || x < 0 || y >= n || x >= n) break;
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}