class Pair {
    int first;
    int second;

    Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        if (fresh == 0)
            return 0;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottenNow = false;

            for (int s = 0; s < size; s++) {
                int x = q.peek().first;
                int y = q.peek().second;
                q.poll();

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (Math.abs(i + j) == 1) {
                            int nx = x + i;
                            int ny = y + j;

                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                if (grid[nx][ny] == 1) {
                                    grid[nx][ny] = 2;
                                    q.add(new Pair(nx, ny));
                                    fresh--;
                                    rottenNow = true;
                                }
                            }
                        }
                    }
                }
            }
            if (rottenNow)
                time++;
        }
        return fresh == 0 ? time : -1;
    }
}