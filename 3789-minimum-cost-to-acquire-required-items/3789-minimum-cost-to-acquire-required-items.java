class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long answer = 0;
        int commonNeed = Math.min(need1, need2);
        answer += (long) commonNeed * Math.min((long) cost1 + cost2, costBoth);
        answer += (long) (need1 - commonNeed) * Math.min(cost1, costBoth);
        answer += (long) (need2 - commonNeed) * Math.min(cost2, costBoth);
        return answer;
    }
}