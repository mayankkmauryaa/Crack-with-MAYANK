class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;
        int count= 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > jump) return false;
            if(jump < i + nums[i]) count++;
            jump = Math.max(jump, i + nums[i]);
        }
        System.out.println(count);
        return true;
    }
}