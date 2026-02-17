/*
                            []
                   /         |           \
                 [1]        [2]          [3]
               /     \       |
           [1,2]    [1,3]   [2,3]
             |
         [1,2,3]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Undo choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}

/*
                           []
                 /                       \
             [1]                         []                             Level 0 (idx=0)
       (include 1)                (exclude 1)
          /           \               /            \
      [1,2]          [1]           [2]             []                   Level 1 (idx=1)
  (inc2)  (exc2)  (inc2) (exc2)  (inc2)(exc2)   (inc2)(exc2)
      /    \         /    \        /    \          /    \
    [1,2,3] [1,2]  [1,3]  [1]    [2,3]   [2]    [3]      []             Level 2 (idx=2)
*/
class Solution_ {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        createSubset(0, nums, ans, subset);
        return ans;
    }

    private void createSubset(int idx, int nums[], List<List<Integer>> ans, List<Integer> sub) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[idx]);
        createSubset(idx + 1, nums, ans, sub);
        sub.remove(sub.size() - 1);
        createSubset(idx + 1, nums, ans, sub);
    }
}