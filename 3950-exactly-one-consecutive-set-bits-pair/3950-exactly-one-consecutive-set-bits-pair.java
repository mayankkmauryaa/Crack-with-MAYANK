class Solution {
    private boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean consecutiveSetBits(int n) {
        return isPowerOfTwo(n & (n >> 1));
    }
}