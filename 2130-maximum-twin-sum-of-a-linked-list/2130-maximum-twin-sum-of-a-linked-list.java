/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        int k = 0;
        int[] ans = new int[size];
        while (temp != null) {
            ans[k++] = temp.val;
            temp = temp.next;
        }
        int i = 0;
        int j = size - 1;
        int max = 0;
        while (i <= j) {
            int sum = ans[i] + ans[j];
            if (sum > max) {
                max = sum;
            }
            i++;
            j--;
        }
        return max;

    }
}

class Solution_DFS {
    int res;
    ListNode left;

    public int pairSum(ListNode head) {
        left = head;
        dfs(head);
        return res;
    }

    private void dfs(ListNode right) {
        if (right.next != null) dfs(right.next);
        res = Math.max(res, left.val + right.val);
        left = left.next;
    }
}