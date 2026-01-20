// Infinity - Class
class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        char[] x = s.toCharArray();
        for (char c : x) {
            if (c == 'B' && !st.isEmpty() && st.peek() == 'A') {
                st.pop();
            } else if (c == 'D' && !st.isEmpty() && st.peek() == 'C') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.size();
    }
}