class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns)
            if (word.indexOf(s) != -1) count++;
        return count;
    }
}

class Solution_contains {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns)
            if (word.contains(s)) count++;
        return count;
    }
}