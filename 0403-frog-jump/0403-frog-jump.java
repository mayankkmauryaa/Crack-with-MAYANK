class Solution {

    Boolean[][] memo;

    public boolean canCross(int[] stones) {

        memo = new Boolean[stones.length][stones.length + 1];

        return dfs(stones, 0, 0);
    }

    private boolean dfs(int[] stones, int index, int lastJump) {
        if (index == stones.length - 1) return true;

        if (memo[index][lastJump] != null) return memo[index][lastJump];

        for (int jump = lastJump - 1;
             jump <= lastJump + 1;
             jump++) {

            if (jump <= 0) continue;

            int nextPosition = stones[index] + jump;

            for (int next = index + 1;
                 next < stones.length;
                 next++) {

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