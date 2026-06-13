class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int wt = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                wt += weights[ch - 'a'];
            }
            int res = wt % 26;
            char rev = (char) ('z' - res);
            sb.append(rev);
        }
        return sb.toString();
    }
}