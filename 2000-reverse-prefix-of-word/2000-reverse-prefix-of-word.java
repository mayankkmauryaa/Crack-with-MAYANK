class Solution {
    public String reversePrefix(String word, char ch) {
        char arr[] = word.toCharArray();
        int ind = word.indexOf(ch);
        if (ind == -1) return word;
        int l = 0;
        int r = ind;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            r--;
            l++;
        }
        return new String(arr);
    }
}