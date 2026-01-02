class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        // int ans = -1;
        for (int i : nums) {
            high = Math.max(high, i);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int th = threshold(nums, mid);
            if (th <= threshold) {
                // ans = low;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }

    int threshold(int arr[], int val) {
        int ans = 0;
        for (int i : arr) {
            ans += Math.ceil((double) i / val);
        }
        return ans;
    }
}