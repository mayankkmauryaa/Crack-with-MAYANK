class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int ans[] = new int[n];
        int l=0;
        int r=n-1;
        for(int i=0, j=n-1; i<n; i++, j--){
            if(nums[i]<pivot){
                ans[l]=nums[i];
                l++; 
            }
            if(nums[j]>pivot){
                ans[r]=nums[j];
                r--;
            }
        }
        while(l<=r){
            ans[l]=pivot;
            l++;
        }
        return ans;
    }
}