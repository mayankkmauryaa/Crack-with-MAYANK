class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> set = new HashSet<>();
        int residue = 0;

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));

            int prefixLengthMod = (i + 1) % 3;
            if (set.size() == prefixLengthMod)
                residue++;
        }

        return residue;
    }
}
