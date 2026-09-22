class Solution {
    Boolean[][] memo;
    int n;

    public boolean canCross(int[] stones) {
        n = stones.length;
        memo = new Boolean[n][n + 1];
        return dfs(stones, 0, 0);
    }

    private boolean dfs(int[] stones, int index, int lastJump) {
        if (index == n - 1) return true;
        if (memo[index][lastJump] != null) return memo[index][lastJump];

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0) continue;

            int nextPosition = stones[index] + jump;

            for (int next = index + 1; next < n; next++) {
                if (stones[next] == nextPosition) {
                    if (dfs(stones, next, jump)) return memo[index][lastJump] = true;
                    break;
                }
                if (stones[next] > nextPosition) break;
            }
        }

        return memo[index][lastJump] = false;
    }
}