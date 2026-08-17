class Solution {
    List<List<Integer>> res;
    List<Integer> comb;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        comb = new ArrayList<>();
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int num = start; num <= n; num++) {
            comb.add(num);
            backtrack(num + 1, n, k);
            comb.remove(comb.size() - 1);
        }
    } 
}