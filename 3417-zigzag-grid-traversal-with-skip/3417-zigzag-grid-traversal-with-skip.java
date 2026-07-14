class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean flag = true;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0)
                for (int j = 0; j < n; j++) {
                    if(flag) ans.add(grid[i][j]);
                    flag = !flag;
                }
            else
                for (int j = n - 1; j >= 0; j--) {
                    if(flag) ans.add(grid[i][j]);
                    flag = !flag;
                }
        }
        return ans;
    }
}