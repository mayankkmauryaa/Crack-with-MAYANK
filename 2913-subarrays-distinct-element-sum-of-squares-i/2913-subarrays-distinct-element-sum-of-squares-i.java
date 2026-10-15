class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[101];
            int count = 0;
            for (int j = i; j < n; j++) {
                int num = nums.get(j);
                if (!seen[num]) {
                    seen[num] = true;
                    count++;
                }
                sum += count * count;
            }
        }
        return sum;
    }
}