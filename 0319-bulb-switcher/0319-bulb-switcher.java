class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}

class Solution_brute {
    public int bulbSwitch(int n) {
        boolean[] bulb = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                bulb[j - 1] = !bulb[j - 1];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (bulb[i])
                count++;
        }
        return count;
    }
}
