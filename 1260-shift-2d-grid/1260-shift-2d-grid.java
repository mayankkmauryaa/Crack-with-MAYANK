class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int tot = n * m;
        k %= tot;
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            ans.add(list);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oldIdx = i * n + j;
                int newIdx = (oldIdx + k) % tot;
                int newRow = newIdx / n;
                int newCol = newIdx % n;
                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return ans;
    }
}