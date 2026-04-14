class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        for (boolean v : visited)
            if (v == false)
                return false;
        return true;
    }

    public void dfs(int src, List<List<Integer>> graph, boolean[] visited) {
        if (visited[src] == true)
            return;
        visited[src] = true;
        List<Integer> neighbours = graph.get(src);
        for (int neighbour : neighbours)
            dfs(neighbour, graph, visited);
    }
}