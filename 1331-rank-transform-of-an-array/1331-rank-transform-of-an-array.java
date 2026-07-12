class Solution {
    public int[] arrayRankTransform(int[] arr) {
        ArrayList<Integer> uniqueArr = new ArrayList<>();
        HashMap<Integer, Integer> numRankMap = new HashMap<>();

        for (int num : arr) {
            if (!numRankMap.containsKey(num)) {
                uniqueArr.add(num);
                numRankMap.put(num, 0);
            }
        }

        Collections.sort(uniqueArr);

        for (int i = 0; i < uniqueArr.size(); i++) {
            numRankMap.put(uniqueArr.get(i), i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = numRankMap.get(arr[i]);
        }

        return arr;
    }
}