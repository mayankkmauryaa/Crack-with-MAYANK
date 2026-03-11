class Solution {
    int[] color;
    int V;

    public boolean isBipartite(int[][] graph) {
        V = graph.length;
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = -1;
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!check(graph, i))
                    return false;
            }
        }
        return true;
    }

    private boolean check(int[][] graph, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int next = q.poll();
            for (int neigh : graph[next]) {
                if (color[neigh] == -1) {
                    color[neigh] = 1 - color[next];
                    q.add(neigh);
                } else if (color[next] == color[neigh])
                    return false;
            }
        }
        return true;
    }
}