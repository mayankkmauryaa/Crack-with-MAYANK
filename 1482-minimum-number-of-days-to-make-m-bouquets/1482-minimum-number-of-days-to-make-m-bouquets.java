class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((long) m * k > n)
            return -1;
        int min = bloomDay[0];
        int max = bloomDay[0];

        for (int val : bloomDay) {
            min = Math.min(val, min);
            max = Math.max(val, max);
        }

        int ans = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;
                max = mid - 1; // try smaller day
            } else {
                min = mid + 1; // need more days
            }
        }

        return ans;
    }

    public boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}