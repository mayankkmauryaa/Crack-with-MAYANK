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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int ans = 0;
        int base = 1;
        while (temp != null) {
            temp = temp.next;
            base *= 2;
        }
        temp = head;
        while (temp != null) {
            int val = temp.val;
            base /= 2;
            ans += val * base;
            temp = temp.next;
        }
        return ans;
    }
}