class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for (int num : nums) {
            while (!st.isEmpty()) {
                int top = st.peek();
                int hcf = gcd(top, num);
                if (hcf <= 1)
                    break;
                num = (num / hcf) * top; // LCM
                st.pop();
            }
            st.push(num);
        }
        return st;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}