class Solution {
    public int centeredSubarrays(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < len; j++) {
                sum += nums[j];
                set.add(nums[j]);
                count += set.contains(sum) ? 1 : 0;
            }
        }
        return count;
    }
}
