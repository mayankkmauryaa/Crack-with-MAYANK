class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(convert(date2) - convert(date1));
    }

    private static int convert(String str) {
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(5, 7));
        int day = Integer.parseInt(str.substring(8, 10));
        int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int res = day;
        for (int i = 0; i < month - 1; i++) res += days[i];
        for (int i = 1971; i < year; i++) res += isleap(i) ? 366 : 365;
        if (isleap(year) && month > 2) res++;
        return res;
    }

    private static boolean isleap(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) return true;
        return false;
    }

}