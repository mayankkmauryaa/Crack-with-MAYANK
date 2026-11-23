class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];
        for (int[] m : matches) {
            if (losses[m[0]] == 0) losses[m[0]] = -1;
            if (losses[m[1]] == -1) losses[m[1]] = 1;
            else losses[m[1]]++;
        }
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            if (losses[i] == -1) zero.add(i);
            else if (losses[i] == 1) one.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zero);
        ans.add(one);
        return ans;
    }
}
