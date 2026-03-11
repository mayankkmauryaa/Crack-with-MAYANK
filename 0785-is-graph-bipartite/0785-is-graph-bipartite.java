class Solution {
    int V;
    int color[];

    public boolean isBipartite(int[][] graph) {
        V = graph.length;
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = -1;
        for (int i = 0; i < V; i++)
            if (color[i] == -1)
                if (!dfs(i, 0, graph))
                    return false;
        return true;
    }

    private boolean dfs(int node, int col, int[][] graph) {
        color[node] = col;
        for (int neigh : graph[node]) {
            if (color[neigh] == -1) {
                if (!dfs(neigh, 1 - col, graph))
                    return false;
            } else if (color[neigh] == col)
                return false;
        }
        return true;
    }
}