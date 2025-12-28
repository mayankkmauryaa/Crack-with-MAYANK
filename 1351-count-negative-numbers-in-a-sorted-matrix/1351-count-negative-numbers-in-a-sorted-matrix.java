class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = m - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                count += n - j;
                i--;
            } else
                j++;
        }
        return count;
    }

    public int countNegatives1(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }
}