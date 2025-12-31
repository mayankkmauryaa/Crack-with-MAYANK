// T.C - N log N

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        // min days
        int left = 0;
        // max days
        int right = row * col;
        int day = 0;

        // trying whether on a particular day we can cross or not then a/c apply B.S.

        // log n
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // n = row * col
            boolean success = canCross(row, col, cells, mid);
            if (success) {
                day = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return day;
    }

    public boolean canCross(int row, int col, int[][] cells, int day) {
        boolean isWater[][] = new boolean[row][col];

        // On day (i + 1), cell (ri, ci) becomes water (1-based index).
        // going till day only and marking it as water
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            isWater[r][c] = true;
        }

        // trying bfs to check if we can get  top to bottom
        // Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q = new ArrayDeque<>();

        boolean vis[][] = new boolean[row][col];

        // checking column-wise i.e 1st row
        for (int i = 0; i < col; i++) {
            if (!isWater[0][i]) {
                // adding the particular col to check through
                q.add(new int[] { 0, i });
                vis[0][i] = true;
            }
        }

        while (!q.isEmpty()) {
            int land[] = q.poll();
            int r = land[0];
            int c = land[1];

            // base case if we reached the bottom no need to go further
            if (r == row - 1)
                return true;

            // directions check
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    // only for 4-directional
                    if (Math.abs(i + j) == 1) {
                        int nr = r + i;
                        int nc = c + j;
                        // boundations for original matrix
                        if (nr >= 0 && nr < row && nc >= 0 && nc < col) {

                            // must not be water or visited
                            if (!isWater[nr][nc] && !vis[nr][nc]) {
                                q.add(new int[] { nr, nc });
                                vis[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}