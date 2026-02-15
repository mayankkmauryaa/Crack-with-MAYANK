class Solution {
    public String addBinary(String a, String b) {
        char arrA[] = a.toCharArray();
        char arrB[] = b.toCharArray();

        StringBuilder s = new StringBuilder();

        int i = arrA.length - 1;
        int j = arrB.length - 1;

        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            // char to digit
            int aa = i >= 0 ? arrA[i] - '0' : 0;
            int bb = j >= 0 ? arrB[j] - '0' : 0;
            int sum = aa + bb + carry;
            int digit = sum % 2;
            carry = sum / 2;
            i--;
            j--;
            // digit to char
            s.append((char) (digit + '0'));
        }
        return s.reverse().toString();
    }
}