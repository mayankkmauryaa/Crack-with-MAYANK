class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min = nums[0];
        int max = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (min > num)
                min = num;
            if (max < num)
                max = num;
        }

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}