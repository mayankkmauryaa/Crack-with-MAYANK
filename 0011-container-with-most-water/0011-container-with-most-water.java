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