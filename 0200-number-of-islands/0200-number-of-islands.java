class Pair {
    int val1;
    int val2;

    public Pair(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }
}

class Solution {
    int n;
    int m;
    boolean vis[][];

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int r, int c, char[][] grid) {
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        while (!q.isEmpty()) {
            int row = q.peek().val1;
            int col = q.peek().val2;
            q.poll();
            for (int rx = -1; rx <= 1; rx++) {
                for (int cx = -1; cx <= 1; cx++) {
                    if (Math.abs(rx + cx) == 1) {

                        int n_row = row + rx;
                        int n_col = col + cx;

                        if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m) {
                            if (grid[n_row][n_col] == '1' && !vis[n_row][n_col]) {
                                vis[n_row][n_col] = true;
                                q.add(new Pair(n_row, n_col));
                            }
                        }
                    }
                }
            }
        }
    }
}