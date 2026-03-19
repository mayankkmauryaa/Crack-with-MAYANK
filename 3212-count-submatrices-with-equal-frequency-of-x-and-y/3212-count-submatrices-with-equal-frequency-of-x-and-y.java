class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sumX[] = new int[cols];
        int sumY[] = new int[cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            int countX = 0;
            int countY = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'X')
                    countX++;
                else if (grid[i][j] == 'Y')
                    countY++;

                sumX[j] += countX;
                sumY[j] += countY;

                if (sumX[j] > 0 && sumX[j] == sumY[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
