class Solution {
    List<List<Integer>> ans;
    List<Integer> list;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();;
        list = new ArrayList<>();
        backtrack(candidates, 0, target);
        return ans;
    }

    private void backtrack(int arr[], int idx, int sum) {
        if (sum < 0) return;
        else if (sum == 0) ans.add(new ArrayList<>(list));
        else {
            for (int i = idx; i < arr.length; i++) {
                list.add(arr[i]);
                backtrack(arr, i, sum - arr[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}