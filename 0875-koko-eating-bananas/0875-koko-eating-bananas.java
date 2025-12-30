class Solution {
    public int max(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int calculateHrs(int[] arr, int h) {
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += Math.ceil((double) arr[j] / h);
        }
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hrs = calculateHrs(piles, mid);
            if (hrs <= h)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    // brute force
    public int bruteforce(int[] piles, int h) {
        int max = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        for (int i = 1; i < max; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.ceil((double) piles[j] / i);
            }
            if (sum <= h)
                return i;
        }
        return max;
    }
}