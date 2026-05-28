class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        int idx = 1;
        int count = 1;
        int ans[] = new int[n];
        ans[0] = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]==nums[i-1]) count++;
            else count = 1;

            if(count <= k) ans[idx++]=nums[i];
        }
        return Arrays.copyOf(ans, idx);
    }
}