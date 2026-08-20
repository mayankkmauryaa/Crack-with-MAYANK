class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n], nums2 = new int[n];
        int n1 = 0, n2 = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) nums1[n1++] = nums[i];
            else if (i == 1) nums2[n2++] = nums[i];
            else {
                if (nums1[n1 - 1] > nums2[n2 - 1]) nums1[n1++] = nums[i];
                else nums2[n2++] = nums[i];
            }
        }
        for (int i = 0; i < n2; i++)
            nums1[n1++] = nums2[i];
        return nums1;
    }
}