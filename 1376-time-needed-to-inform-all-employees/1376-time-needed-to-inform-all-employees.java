
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

class Pair {
    int node;
    int time;

    Pair(int x, int y) {
        this.node = x;
        this.time = y;
    }
}

class Solution_BFS {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                adj.get(manager[i]).add(i);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(headID, 0));
        int maxTime = 0;
        while (!q.isEmpty()) {
            Pair next = q.poll();
            int node = next.node;
            int time = next.time;
            maxTime = Math.max(maxTime, time);

            for (int neigh : adj.get(node)) {
                q.add(new Pair(neigh, time + informTime[node]));
            }
        }
        return maxTime;
    }
}