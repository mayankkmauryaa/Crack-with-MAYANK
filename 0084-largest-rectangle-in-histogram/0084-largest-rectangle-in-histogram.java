class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
class Solutions {
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

class Solution_Brute_force {
    // T.C : O(5N)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nse = findNSE(heights);
        // T.C : 2*O(2N)
        // S.C : O(2N)
        int[] pse = findPSE(heights);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // T.C : O(N)
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Next Smaller Element index
    // S.C : O(N)

    private int[] findNSE(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    // Previous Smaller Element index
    // S.C : O(N)
    private int[] findPSE(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }
}