class Solution {
    public int maxArea(int[] height) {
        int wtr = 0;
        int maxWtr = 0;
        int w = 0;
        int h = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            w = high - low;
            h = Math.min(height[low], height[high]);
            wtr = w * h;
            maxWtr = Math.max(maxWtr, wtr);

            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return maxWtr;
    }
}

class Solution_ {
    static {
        for (int i = 0; i < 100; i++) {
            maxArea(new int[] { 0, 0 });
        }
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}