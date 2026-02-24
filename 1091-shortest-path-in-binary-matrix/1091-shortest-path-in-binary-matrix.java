class Pair {
    int val1;
    int val2;

    Pair(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }
}

class Solution {
    boolean vis[][];
    int n;
    int count;

    public int shortestPathBinaryMatrix(int[][] grid) {

        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        vis = new boolean[n][n];
        return bfs(grid, 0, 0);
    }

    private int bfs(int[][] grid, int r, int c) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        vis[r][c] = true;

        count = 1;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {
                int x = q.peek().val1;
                int y = q.peek().val2;
                q.poll();
                if (x == n - 1 && y == n - 1)
                    return count;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {

                        if (i == 0 && j == 0)
                            continue;

                        int xx = x + i;
                        int yy = y + j;
                        if (xx >= 0 && xx < n && yy >= 0 && yy < n) {

                            if (!vis[xx][yy] && grid[xx][yy] == 0) {
                                vis[xx][yy] = true;
                                q.add(new Pair(xx, yy));
                            }
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}