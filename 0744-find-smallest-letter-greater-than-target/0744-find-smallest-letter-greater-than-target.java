class Solution_linear {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++)
            if (target < letters[i])
                return letters[i];
        return letters[0];
    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < letters[m])
                e = m - 1;
            else
                s = m + 1;
        }
        return letters[s % n];
    }
}