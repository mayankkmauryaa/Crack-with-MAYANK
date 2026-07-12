class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for (int x : clone) {
            if (!ranks.containsKey(x)) {
                ranks.put(x, rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranks.get(arr[i]);
        }
        return arr;
    }
}