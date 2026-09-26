class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (num > 0) set.add(num);
        int count = 1;
        for (int i = 1; i <= set.size(); i++) {
            if (set.contains(i)) count++;
            else return count;
        }
        return count;
    }
}
