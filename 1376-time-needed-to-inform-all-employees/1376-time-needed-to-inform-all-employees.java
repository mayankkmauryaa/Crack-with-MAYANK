
class Solution {
    List<List<Integer>> adj = new ArrayList<>();

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                adj.get(manager[i]).add(i);
        }
        return dfs(headID, informTime);
    }

    public int dfs(int root, int[] time) {
        int max = 0;
        for (int neigh : adj.get(root)) {
            max = Math.max(max, dfs(neigh, time));
        }
        return time[root] + max;
    }
}
