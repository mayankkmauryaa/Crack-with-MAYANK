class Pair {
    int x;
    int y;

    Pair(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
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

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n + 1];
        q.add(1);
        vis[1] = true;
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair p : adj.get(node)) {
                ans = Math.min(ans, p.y);
                if (!vis[p.x]) {
                    vis[p.x] = true;
                    q.add(p.x);
                }
            }
        }
        return ans;
    }
}