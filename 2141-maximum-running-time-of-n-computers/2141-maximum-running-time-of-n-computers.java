class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long low = 0;
        long sum = 0;
        for (int bat : batteries) {
            sum += bat;
        }
        long high = sum / n;
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            if (canCharge(batteries, n, mid)) {
                low = mid;
            } else
                high = mid - 1;
        }
        return low;
    }

    public boolean canCharge(int arr[], int n, long mid) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += Math.min(arr[i], mid);
            if (count >= n * mid)
                return true;
        }
        return count >= mid * n;
    }
}