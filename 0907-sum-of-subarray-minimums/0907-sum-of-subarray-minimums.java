class Solution {
    int[] pse;
    int[] nse;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int mod = 1_000_000_007;
        findPSE(arr);
        findNSE(arr);

        // int minContri[] = new int[n];
        for (int i = 0; i < n; i++) {
            // contribution technique = (n - i) * (i + 1);
            long left = i - pse[i];
            long right = nse[i] - i;
            long contribution = arr[i] * left * right;
            sum = (sum + contribution) % mod;
        }
        return (int) sum;
    }

    public void findPSE(int[] arr) {
        pse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

    }

    public void findNSE(int[] arr) {
        nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

}