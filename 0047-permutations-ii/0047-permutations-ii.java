class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteHelper(nums, 0);
        return res;
    }

    private void permuteHelper(int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums)
                permutation.add(num);
            if (!res.contains(permutation))
                res.add(permutation);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permuteHelper(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}