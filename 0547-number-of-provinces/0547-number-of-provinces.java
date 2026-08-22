class Solution {
    int n;
    boolean[] vis;

    public void BFS(int u, int[][] isConnected) {
        vis[u] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < n; i++) {
                if (!vis[i] && isConnected[curr][i] == 1) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        vis = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                BFS(i, isConnected);
            }
        }
        return count;
    }
}