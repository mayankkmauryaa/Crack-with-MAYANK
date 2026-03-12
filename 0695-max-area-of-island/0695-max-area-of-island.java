class Solution {
    int m;
    int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(i, j, grid);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int bfs(int r, int c, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        grid[r][c] = 0;
        int area = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) == 1) {
                        int nx = x + i;
                        int ny = y + j;

                        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            if (grid[nx][ny] == 1) {
                                q.add(new int[] { nx, ny });
                                grid[nx][ny] = 0;
                                area++;
                            }
                        }
                    }
                }
            }
        }
        return area;
    }
}