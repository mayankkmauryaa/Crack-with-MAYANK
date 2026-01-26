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

class Solution_set {
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

class Solution_sort {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            for (int x = prev + 1; x < curr; x++) {
                result.add(x);
            }
        }
        return result;
    }
}
