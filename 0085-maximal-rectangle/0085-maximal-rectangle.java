class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;

        int cols = matrix[0].length;

        int[] histogram = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j]++;
                } else {
                    histogram[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, MaxAreaInHistogram(histogram));
        }

        return maxArea;
    }

    public int MaxAreaInHistogram(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>(); // stores indexes

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                // that's the element we'll calculate area for
                int height = arr[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                int width = nse - pse - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        // for leftovers
        while (!st.isEmpty()) {

            int height = arr[st.pop()];
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            int width = nse - pse - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}