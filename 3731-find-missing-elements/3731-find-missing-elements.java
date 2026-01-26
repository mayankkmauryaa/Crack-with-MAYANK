class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean[] present = new boolean[101];
        int min = 101, max = 0;

        for (int num : nums) {
            present[num] = true;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
