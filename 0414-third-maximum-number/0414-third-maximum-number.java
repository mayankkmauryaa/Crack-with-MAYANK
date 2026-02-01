class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int size = list.size();
        return size >= 3 ? list.get(size - 3) : list.get(size - 1);
    }
}
