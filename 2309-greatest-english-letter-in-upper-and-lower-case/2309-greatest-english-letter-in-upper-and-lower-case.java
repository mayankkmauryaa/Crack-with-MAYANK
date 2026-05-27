class Solution {
    public String greatestLetter(String s) {
        String ans = "";
        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray())
            set.add(ch);


        for (char ch : set)
            if (Character.isLowerCase(ch) && set.contains(Character.toUpperCase(ch)))
                ans = String.valueOf((char)Math.max(ans.isEmpty() ? 0 : ans.charAt(0),Character.toUpperCase(ch)));
                
        return ans;
    }
}