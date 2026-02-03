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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode st = list1;
        while (st != null && a > 1) {
            st = st.next;
            a--;
        }
        ListNode end = list1;
        while (end != null && b >= 0) {
            end = end.next;
            b--;
        }

        st.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = end;

        return head;
    }
}