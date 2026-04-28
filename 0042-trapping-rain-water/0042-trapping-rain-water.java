class Solution_2xArray {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = height[0];
        rightmax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftmax[i], rightmax[i]) - height[i];
        }
        return water;
    }
}

class Solution_1xArray {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightmax = new int[n];
        int leftMax = height[0];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            water += Math.min(leftMax, rightmax[i]) - height[i];
        }
        return water;
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 1;
        int right = n - 2;
        int rightmax = height[n - 1];
        int leftmax = height[0];
        int water = 0;
        while (left <= right) {
            if (leftmax < rightmax) {
                leftmax = Math.max(leftmax, height[left]);
                water += leftmax - height[left];
                left++;
            } else {
                rightmax = Math.max(rightmax, height[right]);
                water += rightmax - height[right];
                right--;
            }
        }
        return water;
    }
}
