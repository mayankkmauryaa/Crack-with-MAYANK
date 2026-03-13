class Solution {
    List<List<Integer>> paths;
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path);
        return paths;
    }

    private void dfs(int node, int[][] graph, List<Integer> path) {
        if (node == n - 1)
            paths.add(new ArrayList<>(path));
        for (int neigh : graph[node]) {
            path.add(neigh);
            dfs(neigh, graph, path);
            path.remove(path.size() - 1);
        }
    }
}