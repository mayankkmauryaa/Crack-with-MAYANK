class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0;
        boolean even = true;
        for(int i = 0; i < nums.length; i++){
            if(even) sum = sum + nums[i];
            else sum = sum - nums[i];
            even = !even;
        }
        return sum;
    }
}