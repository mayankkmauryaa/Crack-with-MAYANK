class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.putIfAbsent(match[0], 0);
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (int player : map.keySet()) {
            if (map.get(player) == 0) zeroLoss.add(player);
            else if (map.get(player) == 1) oneLoss.add(player);
        }
        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);
        return ans;
    }
}
