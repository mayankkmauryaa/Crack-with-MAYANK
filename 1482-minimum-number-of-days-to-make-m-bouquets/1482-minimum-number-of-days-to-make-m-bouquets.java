class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n)
            return -1;
        int min = min_max(bloomDay)[0];
        int max = min_max(bloomDay)[1];
        while (min <= max) {
            int mid = min + (max - min) / 2;
            boolean ans = possible(bloomDay, mid, m, k);
            if (!ans)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return min;
    }

    boolean possible(int arr[], int day, int m, int k) {
        int c = 0;
        int bouqet = 0;
        for (int i : arr) {
            if (i <= day)
                c++;
            else {
                bouqet += (c / k);
                c = 0;
            }
        }
        bouqet += (c / k);
        return bouqet >= m;
    }

    int[] min_max(int arr[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return new int[] { min, max };
    }
}