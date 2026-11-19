class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int len = words.length - 1;
        List<String> ans = new ArrayList<>(len);
        for (int i = 1; i < len; i++)
            if (words[i].equals(second) && words[i - 1].equals(first))
                ans.add(words[i + 1]);
        return ans.toArray(new String[0]);
    }
}