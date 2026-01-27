class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList();
        int n = tickets.length;
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        int time = 0;
        while (tickets[k] != 0) {
            int buy = q.remove();
            tickets[buy]--;
            time++;
            if (tickets[buy] != 0) {
                q.add(buy);
            }
        }
        return time;
    }
}