class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> arrayList = new ArrayList<>();
        int count = 0;
        int same = 0;
        for (int num : nums) {
            if (num < target) count++;
            else if (num == target) same++;
        }
        while (same != 0) {
            arrayList.add(count++);
            same--;
        }
        return arrayList;
    }
}