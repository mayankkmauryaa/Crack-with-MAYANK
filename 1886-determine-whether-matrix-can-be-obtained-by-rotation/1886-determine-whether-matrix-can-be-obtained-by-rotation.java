class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // Try all 4 possible rotations (0°, 90°, 180°, 270°)
        for (int i = 0; i < 4; i++) {
            if (isEqual(mat, target))
                return true;
            rotate(mat);
        }
        return false;
    }

    private void rotate(int[][] mat) {
        int n = mat.length;

        // Step 1: Transpose the matrix (swap across diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // This completes the 90° clockwise rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
}