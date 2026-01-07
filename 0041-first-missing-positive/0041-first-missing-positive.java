class Solution {
    public int firstMissingPositive(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums)
            if (num > 0)
                list.add(num);
        Collections.sort(list);

        int missing = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == missing)
                missing++;
            else if (list.get(i) > missing)
                return missing;
        }
        return missing;
    }
}
