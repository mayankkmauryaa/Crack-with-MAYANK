class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            // Compute horizontal distance between current and previous point.
            int x2 = points[i][0];
            int x1 = points[i - 1][0];
            int dx = Math.abs(x2 - x1);

            // Compute vertical distance between current and previous point.
            int y2 = points[i][1];
            int y1 = points[i - 1][1];
            int dy = Math.abs(y2 - y1);

            // Use diagonal moves as much as possible.
            // Minimum time between two points = max(dx, dy).
            ans += Math.max(dx, dy);
        }
        return ans;
    }
}