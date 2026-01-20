/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        map.put(head, 1);
        while (head != null) {
            if (map.containsKey(head.next)) {
                return head.next;
            } else {
                map.put(head.next, 1);
            }
            head = head.next;
        }
        return null;
    }
}
