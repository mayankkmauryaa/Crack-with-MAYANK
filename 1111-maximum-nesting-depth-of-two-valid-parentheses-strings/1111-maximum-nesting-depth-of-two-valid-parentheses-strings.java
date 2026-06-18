class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int ans[] = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                ans[i] = count % 2;
                count++;
            }
            if (ch == ')') {
                count--;
                ans[i] = count % 2;
            }
        }
        return ans;
    }
}