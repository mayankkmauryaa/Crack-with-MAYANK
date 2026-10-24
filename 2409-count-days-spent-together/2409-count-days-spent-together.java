class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        return Math.max(0, Math.min(calculate(leaveAlice), calculate(leaveBob))
                - Math.max(calculate(arriveAlice), calculate(arriveBob)) + 1);
    }

    int calculate(String s) {
        int m = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int q = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

        return (275 * m) / 9 - 2 * ((m + 9) / 12) + q - 30;
    }
}

