class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>(); // store indexes
        int area = 0;
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // T.C. : O(N) + stack traversals : O(N)
            // S.C. : O(N)
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int elementIdx = st.peek(); // we'll calculate area for this one
                st.pop();

                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                area = heights[elementIdx] * (nse - pse - 1);
                maxArea = Math.max(area, maxArea);

            }

            st.push(i);
        }

        // what if elements are still left in the stack lets say the last one orr the smallest one
        while (!st.isEmpty()) {
            int nse = n;
            int elementIdx = st.peek();
            st.pop();

            int pse = st.isEmpty() ? -1 : st.peek();

            area = heights[elementIdx] * (nse - pse - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}