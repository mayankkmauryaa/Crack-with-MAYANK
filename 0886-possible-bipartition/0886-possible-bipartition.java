class Solution {
    List<List<Integer>> graph;
    int[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int d[] : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }
        color = new int[n + 1];
        for (int i = 0; i <= n; i++)
            color[i] = -1;
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int col) {
        color[node] = col;
        for (int neigh : graph.get(node)) {
            if (color[neigh] == col)
                return false;
            if (color[neigh] == -1) {
                if (!dfs(neigh, 1 - col))
                    return false;
            }
        }
        return true;
    }
}