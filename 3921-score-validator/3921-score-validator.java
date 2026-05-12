class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int count = 0;
        for (String e : events) {
            if (count == 10) break;
            if (e.equals("WD")) score += 1;
            else if (e.equals("NB")) score += 1;
            else if (e.equals("W")) count += 1;
            else score += Integer.parseInt(e);
        }
        return new int[] { score, count };
    }
}