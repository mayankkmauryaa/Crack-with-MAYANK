class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public String sortVowels(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                map.putIfAbsent(ch, new int[] { 0, i });
                map.get(ch)[0]++;
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            int freq1[] = map.get(a);
            int freq2[] = map.get(b);
            if (freq1[0] != freq2[0]) {
                return freq2[0] - freq1[0];
            } else {
                return freq1[1] - freq2[1];
            }
        });
        pq.addAll(map.keySet());
        List<Character> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int count = map.get(ch)[0];
            for (int i = 0; i < count; i++) {
                list.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                sb.append(list.get(i++));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}