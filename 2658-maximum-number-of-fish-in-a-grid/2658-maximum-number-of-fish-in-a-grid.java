class Pair {
    int x;
    int y;

    Pair(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

class Solution {
    int m;
    int n;

    public int findMaxFish(int[][] grid) {
        int fish = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                fish = Math.max(fish, dfs(grid, i, j));
            }
        }
        return fish;
    }

    public int dfs(int grid[][], int x, int y) {
        int fish = 0;
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0) {
            fish = grid[x][y];
            grid[x][y] = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) == 1) {
                        fish += dfs(grid, x + i, y + j);
                    }
                }
            }
        }
        return fish;
    }
}
