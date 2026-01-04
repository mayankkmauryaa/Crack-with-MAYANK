class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x=nums1.length;
        int y=nums2.length;

        int[] combo = new int[x+y];
        int k=0;
        for(int i=0; i<x; i++){
            combo[k]=nums1[i];
            k++;
        }
        for(int i=0; i<y; i++){
            combo[k]=nums2[i];
            k++;
        }
        Arrays.sort(combo);
        int z=combo.length;

        if (z%2==1){
            return combo[z/2];
        }
        else {
            return ((combo[z/2]+combo[z/2-1])/2.000);
        }
    }
}