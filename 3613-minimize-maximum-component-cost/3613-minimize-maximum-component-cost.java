class Solution {
    List<List<int[]>> graph;
    boolean[] vis;
    List<List<Integer>> adj;

    public int minCost(int n, int[][] edges, int k) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int low = 0, high = 0, ans = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
            high = Math.max(high, w);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int mid, int k) {
        int n = graph.size();
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int u = 0; u < n; u++) {
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                if (w <= mid) {
                    adj.get(u).add(v);
                }
            }
        }

        vis = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                if (components > k)
                    return false;
                dfs(i);
            }
        }

        return true;
    }

    private void dfs(int node) {
        vis[node] = true;
        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei);
            }
        }
    }
}