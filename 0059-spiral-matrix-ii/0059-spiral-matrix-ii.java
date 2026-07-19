class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int k = 1;
        int top = 0, left = 0;
        int bot = n - 1, right = n - 1;
        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                mat[top][i] = k++;
            }
            top++;
            for (int i = top; i <= bot; i++) {
                mat[i][right] = k++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                mat[bot][i] = k++;
            }
            bot--;
            for (int i = bot; i >= top; i--) {
                mat[i][left] = k++;
            }
            left++;
        }
        return mat;
    }
}