class Solution {
    public String removeOuterParentheses(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (!stack.isEmpty()) answer.append(c);
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.isEmpty()) answer.append(c);
            }
        }
        return answer.toString();
    }
}