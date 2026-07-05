class Solution {
    public int maxDigitRange(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
        }
        int max = 0;
        for (int num : nums) {
            int r = range(num);
            max = Math.max(r, max);
            list.get(r).add(num);
        }
        int ans = 0;
        for (int i = 0; i < list.get(max).size(); i++) {
            ans += list.get(max).get(i);
        }
        return ans;
    }

    public int range(int num) {
        int min = 9;
        int max = 0;
        while (num > 0) {
            int rem = num % 10;
            min = Math.min(min, rem);
            max = Math.max(max, rem);
            num /= 10;
        }
        return Math.abs(max - min);
    }
}