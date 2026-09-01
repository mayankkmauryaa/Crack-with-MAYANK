class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int s0 = source[0], s1 = source[1];
        int t0 = target[0], t1 = target[1];
        if ((s0 + s1) % 2 != (t0 + t1) % 2) return -1;
        if (Math.abs(s0 - t0) == Math.abs(s1 - t1)) return 1;
        return 2;
    }
}