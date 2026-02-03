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
    public ListNode doubleIt(ListNode head) {
        int carry = dfs(head);

        if (carry > 0) {
            ListNode num = new ListNode(carry);
            num.next = head;
            return num;
        }
        return head;
    }

    private int dfs(ListNode node) {
        if (node == null)
            return 0;

        int carry = dfs(node.next);
        int val = node.val * 2 + carry;

        node.val = val % 10;
        return val / 10;
    }
}
