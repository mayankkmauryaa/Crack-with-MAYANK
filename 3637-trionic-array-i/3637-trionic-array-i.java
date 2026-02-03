class Solution {
    public boolean isTrionic(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (end - start < 3)
            return false;

        int i = start;

        // first increasing
        while (i + 1 <= end && nums[i] < nums[i + 1])
            i++;
        if (i == start)
            return false;

        int decStart = i;

        // decreasing
        while (i + 1 <= end && nums[i] > nums[i + 1])
            i++;
        if (i == decStart)
            return false;

        int inc2Start = i;

        // second increasing
        while (i + 1 <= end && nums[i] < nums[i + 1])
            i++;
        if (i == inc2Start)
            return false;

        return i == end;
    }
}