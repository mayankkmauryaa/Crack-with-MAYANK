class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        while (top <= bottom) {
            int midRow = top + (bottom - top) / 2;
            if (target >= matrix[midRow][0] && target <= matrix[midRow][n - 1])
                return binarySearch(matrix[midRow], target);
            else if (target < matrix[midRow][0]) bottom = midRow - 1;
            else top = midRow + 1;
        }
        return false;
    }
    private boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) return true;
            else if (row[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}