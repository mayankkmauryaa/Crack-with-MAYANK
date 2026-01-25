class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;

        for (int num : nums) {
            if (!set.contains(num) && num <= k) {
                k++;
                sum += num;
            }
            set.add(num);
        }

        long total = (long) (1 + k) * k / 2;
        long ans = total - sum;
        return ans;

    }
}
