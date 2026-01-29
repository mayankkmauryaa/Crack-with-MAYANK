class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans[] = new int[m];

        for (int i = 0; i < m; i++) {
            int j = 0;
            while (nums2[j] != nums1[i]) j++;
            ans[i] = -1;

            for (j = j + 1; j < n; j++) {
                if (nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}
