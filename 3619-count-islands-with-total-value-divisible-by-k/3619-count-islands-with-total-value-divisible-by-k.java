class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int sum = dfs(grid, visited, i, j);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;
        int total = grid[x][y];

        total += dfs(grid, visited, x - 1, y); // up
        total += dfs(grid, visited, x + 1, y); // down
        total += dfs(grid, visited, x, y - 1); // left
        total += dfs(grid, visited, x, y + 1); // right

        return total;
    }
}
