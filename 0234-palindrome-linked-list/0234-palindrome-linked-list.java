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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next!= null){
            slow= slow.next;
            fast=fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow=slow.next;

        while(slow!=null){
            if(slow.val!=temp.val) return false ;
            
            slow=slow.next;
            temp=temp.next;
        }
        return true ;
        // if(slow==null) return true;
        // return false;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}