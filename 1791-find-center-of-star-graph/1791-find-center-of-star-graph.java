class Solution_degree {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            degree[u]++;
            degree[v]++;
        }
        for (int i = 1; i <= n; i++)
            if (degree[i] == n - 1) return i;
        return -1;
    }
}

class Solution {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}