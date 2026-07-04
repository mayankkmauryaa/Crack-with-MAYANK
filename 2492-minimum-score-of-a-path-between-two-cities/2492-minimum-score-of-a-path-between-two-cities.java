class Pair {
    int x;
    int y;

    Pair(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

class Solution {
    boolean vis[];
    List<List<Pair>> adj;
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        adj = new ArrayList<>();
        vis = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        vis[1] = true;

        dfs(1);
        return ans;
    }

    public void dfs(int node) {
        vis[node] = true;

        for (Pair p : adj.get(node)) {
            ans = Math.min(ans, p.y);
            if (!vis[p.x]) {
                dfs(p.x);
            }
        }
    }
}