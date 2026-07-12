class Solution {
    public int[] arrayRankTransform(int[] arr) {
         
        Map<Integer, Integer> rank = new HashMap<>(); 
        int[] unique = Arrays.stream(arr).distinct().sorted().toArray();
        for (int i = 0; i < unique.length; i++) {
            rank.put(unique[i], i + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
}
