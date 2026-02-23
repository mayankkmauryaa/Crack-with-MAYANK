class Solution {
    int n;
    boolean vis[];

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(isConnected, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int idx) {
        vis[idx] = true;
        for (int i = 0; i < n; i++) {
            if (!vis[i] && isConnected[idx][i] == 1) {
                dfs(isConnected, i);
            }
        }
    }
}