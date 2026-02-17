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
