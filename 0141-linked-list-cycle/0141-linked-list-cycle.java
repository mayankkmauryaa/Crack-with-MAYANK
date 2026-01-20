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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {     // step and next step check
            fast = fast.next.next;                      // 2 step
            slow = slow.next;                           // 1 step
            if (fast == slow) return true;              // agar mil gye to cycle h
        }

        return false;        
    }
}