class Solution {

    // The first integer of each row is greater than the last integer of the previous row.

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        
        // O(log(m × n))
        int high = m * n - 1;   // total items

        while (low <= high) {
            // index in the imaginary 1D array
            int mid = low + (high - low) / 2;

            // we choose n here because sorted array is split up into n pieces {columns}
            int row = mid / n;
            int col = mid % n;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}


class Worst_Case_Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}