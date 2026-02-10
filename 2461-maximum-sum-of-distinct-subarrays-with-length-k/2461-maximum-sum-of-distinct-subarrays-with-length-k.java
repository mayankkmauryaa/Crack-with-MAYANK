class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long windowSum = 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;

        for (int r = 0; r < n; r++) {

            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            windowSum += nums[r];

            while (freq.get(nums[r]) > 1) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                windowSum -= nums[l];
                l++;
            }
            
            if (r - l + 1 > k) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                windowSum -= nums[l];
                l++;
            }
            
            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}
