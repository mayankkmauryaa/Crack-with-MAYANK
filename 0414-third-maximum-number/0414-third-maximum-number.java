class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num!= first) {
                third = second;
                second = num;
            } else if (num > third && num!=first && num!=second) {
                third = num;
            }
        }
        return third != Long.MIN_VALUE ? (int) third : (int) first ;
    }
}

class Solution_TreeSet {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int n : nums) {
            set.add(n);
            if (set.size() > 3) {
                set.pollFirst();
            }
        }

        return set.size() == 3 ? set.first() : set.last();
    }
}

class Solution_HashSet_Sorting {
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