class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n]; // component mapping
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff)
                comp[i] = comp[i - 1]; // refers that it can be on the same connected component
            else
                comp[i] = comp[i - 1] + 1;
        }

        boolean[] path = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++)
            path[i] = (comp[queries[i][0]] == comp[queries[i][1]]);

        return path;
    }
}